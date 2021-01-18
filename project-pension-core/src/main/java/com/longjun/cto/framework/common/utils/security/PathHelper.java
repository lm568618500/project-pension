package com.longjun.cto.framework.common.utils.security;
import com.abbott.sm.generator.utils.SettingKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Date;

/**
 * FilePathHelper是用来获取各种文件路径的工具类<br>
 * 请将各种文件存储路径策略都定义在此类中<br>
 * 特点：<br>
 *   FilePathHelper是对PathUtil的封装<br>
 *   FilePathHelper与项目是深度耦合的、PathUtil是不与项目耦合<br>
 * 目前已制定策略：<br>
 *   1.通用文件路径策略：通用的Attachment文件会按上传时间生成物理路径，如：2017年8月4日上传的文件的存储路径为：/mnt/project/webproject/attachments/2017/0804<br>
 * Created by wyjun on 2017/7/25.
 */
public class PathHelper {

  private static final Logger logger = LoggerFactory.getLogger(PathHelper.class);

  /**
   * 获得通用文件上传位置<br>
   * 策略：在配置的文件上传基础路径下面，根据当前日期生成文件夹，返回该文件夹路径<br>
   * 如：2017年8月4日上传的文件返回的路径为：/mnt/project/webproject/attachments/2017/0804<br>
   * @return
   */
  public static File getAttachmentUploadLocation(){
    Date now = new Date();
    String year = cn.hutool.core.date.DateUtil.format(now,"yyyy");
    String monthAndDay = cn.hutool.core.date.DateUtil.format(now,"MMdd");
    File attachmentUploadLocation = new File(SettingKit.getValue("conf/sys.setting", "file", "file.upload.base.location")+File.separator+year+File.separator+monthAndDay);
    if(!attachmentUploadLocation.exists()){
      attachmentUploadLocation.mkdirs();
    }
    return attachmentUploadLocation;
  }


}
