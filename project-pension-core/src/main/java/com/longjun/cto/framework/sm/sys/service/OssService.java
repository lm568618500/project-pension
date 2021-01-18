package com.longjun.cto.framework.sm.sys.service;

import java.io.File;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.conf.SysSetting;
import com.eims.cto.framework.common.core.utils.WebKit;
import com.eims.cto.framework.common.core.utils.sequence.Sequence;
import com.eims.cto.framework.common.util.SettingKit;
import com.eims.cto.framework.plugins.oss.fastdfs.api.OssFdsApi;
import com.eims.cto.framework.plugins.oss.local.api.OssLocalApi;
import com.eims.cto.framework.plugins.oss.model.OssRet;
import com.longjun.cto.framework.sm.sys.entity.model.OssResModel;
import com.longjun.cto.framework.sm.sys.entity.view.OssResSaveView;
import com.longjun.cto.framework.sm.sys.es.OssTypeEnums;

import cn.hutool.core.convert.Convert;

/**
 * oss文件上传
 * 
 * @author yangxuan
 * @date 2019年3月25日 下午7:53:52
 */
@Component
public class OssService {

	static Logger log = LoggerFactory.getLogger(OssService.class);

	@Autowired
	WebKit webKit;

	@Autowired
	IOssResService iOssResService;

	public static Integer OSSTYPE = Convert.toInt(SettingKit.getValue("conf/sys.setting", "oss", "oss_type"), 1);

	/**
	 * 文件上传
	 * 
	 * @param files
	 * @return
	 * @throws BusinessException
	 */
	public List<OssResSaveView> save(MultipartFile... files) throws BusinessException {
		List<OssResSaveView> ret = new ArrayList<>();
		OssTypeEnums typeEnums = OssTypeEnums.matchEnums(OSSTYPE);
		ret = this.execLocal(typeEnums, files);
		return ret;
	}

	/**
	 * 2019年7月3日进行废除。采用配置文件进行处理
	 * 
	 * @param typeEnums
	 * @param files
	 * @return
	 * @throws BusinessException
	 */
	@Deprecated
	public List<OssResSaveView> save(OssTypeEnums typeEnums, MultipartFile... files) throws BusinessException {
		List<OssResSaveView> ret = new ArrayList<>();
		ret = this.execLocal(typeEnums,files);
		return ret;
	}

	public byte[] downloadFile(OssTypeEnums typeEnums, String group, String path) {
		byte[] bytes = OssFdsApi.getOssFdsApi().downloadFile(group, path);
		return bytes;
	}

	public List<OssResSaveView> execLocal(OssTypeEnums typeEnums, MultipartFile[] files) throws BusinessException {
		List<OssResSaveView> ret = new ArrayList<OssResSaveView>();
		try {
			OssResModel resModel = null;
			OssResSaveView tmpView = null;
			for (MultipartFile file : files) {
				tmpView = new OssResSaveView();
				resModel = new OssResModel();
				String fullPath = null;
				String group = "DEFAULT";
				String remoteResPath = null;
				String preViewPath = null;
				switch (typeEnums) {
				case LOCAL:
					Sequence sequence = new Sequence();
					File temp = new File("temp_" + sequence.nextId() + "");
					FileUtils.copyInputStreamToFile(file.getInputStream(), temp);
					OssRet ossRet = OssLocalApi.getOssLocalApi().upload(temp);
					//删除临时文件
					temp.delete();
					fullPath = ossRet.getFullHref();
					remoteResPath = ossRet.getHref();
					preViewPath = ossRet.getFullHref();
					break;

				case FASTDFS:
					org.cleverframe.fastdfs.model.StorePath storePath = OssFdsApi.getOssFdsApi().upload(
							file.getInputStream(), file.getSize(),
							FilenameUtils.getExtension(file.getOriginalFilename()));
					fullPath = storePath.getFullPath();
					group = storePath.getGroup();
					remoteResPath = storePath.getPath();
					preViewPath = SysSetting.OSS_PREVIEWBASEURL + "/" + fullPath;
					break;
				}
				log.debug("文件上传返回地址:[{}]", fullPath);
				resModel.setResName(file.getOriginalFilename());
				resModel.setResSize(file.getSize());
				resModel.setSuffix(FilenameUtils.getExtension(file.getOriginalFilename()));
				resModel.setOssType(OssTypeEnums.FASTDFS.getType());
				resModel.setFileHash(md5HashCode(file.getInputStream()));
				resModel.setIp(webKit.getRequest().getRemoteAddr());
				resModel.setGroup(group);
				resModel.setRemoteResPath(remoteResPath);
				resModel.setRemoteResFullPath(fullPath);
				resModel.setPreViewPath(preViewPath);
				this.iOssResService.saveModel(resModel);
				tmpView.setFileName(file.getOriginalFilename());
				tmpView.setFileSize(file.getSize());
				tmpView.setAttachment(resModel.getPreViewPath());
				tmpView.setRemoteName(fullPath);
				ret.add(tmpView);
			}
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("本地FASTDFS上传异常");
		}
	}

	public List<OssResSaveView> save(InputStream ins, String fileName) throws BusinessException {
		List<OssResSaveView> ret = new ArrayList<OssResSaveView>();
		try {
			OssResModel resModel = null;
			OssResSaveView tmpView = null;
			tmpView = new OssResSaveView();
			resModel = new OssResModel();
			ins.read();
			org.cleverframe.fastdfs.model.StorePath storePath = OssFdsApi.getOssFdsApi().upload(ins, ins.read(),
					FilenameUtils.getExtension(fileName));
			log.debug("文件上传返回地址:[{}]", storePath.getFullPath());
			resModel.setResName(fileName);
			resModel.setResSize(ins.read());
			resModel.setSuffix(FilenameUtils.getExtension(fileName));
			resModel.setOssType(OssTypeEnums.FASTDFS.getType());
			resModel.setFileHash(md5HashCode(ins));
			resModel.setIp(webKit.getRequest().getRemoteAddr());
			resModel.setGroup(storePath.getGroup());
			resModel.setRemoteResPath(storePath.getPath());
			resModel.setRemoteResFullPath(storePath.getFullPath());
			resModel.setPreViewPath((SysSetting.OSS_PREVIEWBASEURL + "/" + storePath.getFullPath()));
			this.iOssResService.saveModel(resModel);
			tmpView.setFileName(fileName);
			tmpView.setFileSize(ins.read());
			tmpView.setAttachment(resModel.getPreViewPath());
			tmpView.setRemoteName(storePath.getFullPath());
			ret.add(tmpView);
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("本地FASTDFS上传异常");
		}
	}

	/**
	 * java获取文件的md5值
	 * 
	 * @param fis 输入流
	 * @return
	 */
	public static String md5HashCode(InputStream fis) {
		try {
			// 拿到一个MD5转换器,如果想使用SHA-1或SHA-256，则传入SHA-1,SHA-256
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 分多次将一个文件读入，对于大型文件而言，比较推荐这种方式，占用内存比较少。
			byte[] buffer = new byte[1024];
			int length = -1;
			while ((length = fis.read(buffer, 0, 1024)) != -1) {
				md.update(buffer, 0, length);
			}
			fis.close();
			// 转换并返回包含16个元素字节数组,返回数值范围为-128到127
			byte[] md5Bytes = md.digest();
			BigInteger bigInt = new BigInteger(1, md5Bytes);// 1代表绝对值
			return bigInt.toString(16);// 转换为16进制
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

}
