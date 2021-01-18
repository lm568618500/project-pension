package com.baidu.ueditor.upload;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.eims.cto.framework.common.core.utils.sequence.Sequence;
import com.eims.cto.framework.plugins.oss.fastdfs.api.OssFdsApi;

import gui.ava.html.image.generator.HtmlImageGenerator;

/** 
* 类说明 
* @author 作者:liuming 
* @version 创建时间：2019年3月18日 上午11:43:37 
* 
*/
public class FileUtils {
	public static boolean writeWordFile(String content,String filePathWord,String newFileName) {
		
		boolean flag = false;
		
		ByteArrayInputStream bais = null;
		
		FileOutputStream fos = null;
		
		try {
			//String content = readFile(filepath);
			
			byte b[] = content.getBytes("utf-8");
			
			bais = new ByteArrayInputStream(b);
			
			POIFSFileSystem poifs = new POIFSFileSystem();
			
			DirectoryEntry directory = poifs.getRoot();
			
			DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);
			
			String newFilePath =  filePathWord+newFileName+".doc";
			
			fos = new FileOutputStream(newFilePath);
			
			poifs.writeFilesystem(fos);
			
			bais.close();
			
			fos.close();
		} catch (Exception e) {

		}
		return flag;

	}
	
	public static boolean htmlForImg(String filepath,String filePathWord,String newFileName){
		boolean flag = false;
		try {
			//String content = readFile(filepath);
			Dimension dimension=new Dimension();
			dimension.height=1200;
			dimension.width=600;
			HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
			imageGenerator.loadHtml(filepath);
			imageGenerator.getBufferedImage();
			imageGenerator.setSize(dimension);
			imageGenerator.saveAsImage(filePathWord+newFileName+".png");
			
			//左转90度
			/*File file=new File(filePathWord+newFileName+".png");
			rotateImage90(file);*/
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("将HTML文件转换成图片异常");
		}
		
		return flag;
	}
	
	public static String htmlForImg(String filepath){
	   String url  = null;
		try {
			Dimension dimension=new Dimension();
			dimension.height=1200;
			dimension.width=600;
			HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
			imageGenerator.loadHtml(filepath);
			imageGenerator.setSize(dimension);
			imageGenerator.getBufferedImage();
			//输出流转换 = 将BufferedImage转换为InputStream桥接
	        BufferedImage image = imageGenerator.getBufferedImage();
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(image, "png", os);
            InputStream is = new ByteArrayInputStream(os.toByteArray());
	        Sequence sequence = new Sequence();
			File temp = new File("temp_" + sequence.nextId() + "");
			org.apache.commons.io.FileUtils.copyInputStreamToFile(is, temp);
			org.cleverframe.fastdfs.model.StorePath storePath = OssFdsApi.getOssFdsApi().upload(temp);
			//删除临时文件
			temp.delete();
			url = storePath.getFileHref();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("将HTML文件转换成图片异常");
		}
		
		return url;
	}
	
	/**
	 * 按比例压缩图片
	 * @param srcImageFile 
     *            源图像文件地址 
     * @param result 
     *            缩放后的图像地址 
     * @param scale 
     *            缩放比例 
     * @param flag 
     *            缩放选择:true 放大; false 缩小; 
	 * @return
	 */
	public static String checkImageScale(String filePathWord,String newFileName,String srcImageFile, String result,
        int scale, boolean flag){
		try {  
			saveImg(srcImageFile, filePathWord+newFileName+"1.png");
			File file=new File(filePathWord+newFileName+"1.png"); 
            BufferedImage src = ImageIO.read(file); // 读入文件  
            int width = src.getWidth(); // 得到源图宽  
            int height = src.getHeight(); // 得到源图长  
            if (flag) {// 放大  
                width = width * scale;  
                height = height * scale;  
            } else {// 缩小  
                width = width / scale;  
                height = height / scale;  
            }  
            java.awt.Image image = src.getScaledInstance(width, height,  
                    java.awt.Image.SCALE_DEFAULT);  
            BufferedImage tag = new BufferedImage(width, height,  
                    BufferedImage.TYPE_INT_RGB);  
            Graphics g = tag.getGraphics();  
            g.drawImage(image, 0, 0, null); // 绘制缩小后的图  
            g.dispose();  
            ImageIO.write(tag, "JPEG", new File(filePathWord+newFileName+".png"));// 输出到文件流  
        } catch (IOException e) {  
            e.printStackTrace();  
            return srcImageFile;
        }  
		return result;
	}
	public static void main(String[] args) throws Exception {
		String url = "http://fds.smq.com.cn:8008/group1/M00/00/00/wKh6AVyxTzmAKgFPAAsSRwmNCqY280.jpg";
        System.out.println(getFileLength(url)/1024);// 源图大小

	}
	/**
	 * 保存图片到本地
	 * @param urls
	 * @param urlName
	 */
	public static void saveImg(String urls,String urlName){
		try {
			//new一个URL对象  
	        URL url = new URL(urls);  
	        //打开链接  
	        HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
	        //设置请求方式为"GET"  
	        conn.setRequestMethod("GET");  
	        //超时响应时间为5秒  
	        conn.setConnectTimeout(5 * 1000);  
	        //通过输入流获取图片数据  
	        InputStream inStream = conn.getInputStream();  
	        //得到图片的二进制数据，以二进制封装得到数据，具有通用性  
	        byte[] data = readInputStream(inStream);  
	        //new一个文件对象用来保存图片，默认保存当前工程根目录  
	        File imageFile = new File(urlName);  
	        //创建输出流  
	        FileOutputStream outStream = new FileOutputStream(imageFile);  
	        //写入数据  
	        outStream.write(data);  
	        //关闭输出流  
	        outStream.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	}
	public static byte[] readInputStream(InputStream inStream) throws Exception{  
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        //创建一个Buffer字符串  
        byte[] buffer = new byte[1024];  
        //每次读取的字符串长度，如果为-1，代表全部读取完毕  
        int len = 0;  
        //使用一个输入流从buffer里把数据读取出来  
        while( (len=inStream.read(buffer)) != -1 ){  
            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度  
            outStream.write(buffer, 0, len);  
        }  
        //关闭输入流  
        inStream.close();  
        //把outStream里的数据写入内存  
        return outStream.toByteArray();  
    }  

	//左转90度
    public static File rotateImage90(File file) throws Exception
    {
        BufferedImage bufferedimage = ImageIO.read(file);
        int w = bufferedimage.getWidth();
        int h = bufferedimage.getHeight();
        int type = bufferedimage.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d = 
        		(img = new BufferedImage(h, w, type) ).createGraphics()
        ).setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.rotate(Math.toRadians(270), w / 2, h / 2 + (w-h)/2);
        graphics2d.drawImage(bufferedimage, 0, 0, null);
        graphics2d.dispose();
        ImageIO.write(img,"jpg",file);
        return file;
    }
    /**
	 * 获取网络文件大小
	 * @param url
	 * @param type
	 * @return
	 * @throws IOException 
	 */
    public static int getFileLength(String url1){
		int length=0;
		URL url;
		try {
			url = new  URL(url1);
			HttpURLConnection   urlcon=(HttpURLConnection)url.openConnection();   
			//根据响应获取文件大小 
			length=urlcon.getContentLength();
			urlcon.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		return length;
	}
	/**
	 * 
	 * @Description 转换成24位图的BMP
	 * @param image
	 * @return
	 */
	public static BufferedImage transform_Gray24BitMap(BufferedImage image){

	    int h = image.getHeight();
	    int w = image.getWidth();
	    int[] pixels = new int[w * h]; // 定义数组，用来存储图片的像素
	    int gray;
	    PixelGrabber pg = new PixelGrabber(image, 0, 0, w, h, pixels, 0, w);
	    try {
	        pg.grabPixels(); // 读取像素值
	    } catch (InterruptedException e) {
	        throw new RuntimeException("转换成24位图的BMP时，处理像素值异常");
	    }

	    for (int j = 0; j < h; j++){ // 扫描列  
	        for (int i = 0; i < w; i++) { // 扫描行
	            // 由红，绿，蓝值得到灰度值
	            gray = (int) (((pixels[w * j + i] >> 16) & 0xff) * 0.8);
	            gray += (int) (((pixels[w * j + i] >> 8) & 0xff) * 0.1);
	            gray += (int) (((pixels[w * j + i]) & 0xff) * 0.1);
	            pixels[w * j + i] = (255 << 24) | (gray << 16) | (gray << 8) | gray;
	        }
	    }

	    MemoryImageSource s= new MemoryImageSource(w,h,pixels,0,w);
	    java.awt.Image img =Toolkit.getDefaultToolkit().createImage(s);
	    BufferedImage buf = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);//如果要转换成别的位图，改这个常量即可
	    buf.createGraphics().drawImage(img, 0, 0, null);
	    return buf;
	}
	
	  public static void getPDF(String htmlFile, String pdfFile,String wkhtmltopdfAddress){
		  String execCmd = wkhtmltopdfAddress + " " + pdfFile + " " + htmlFile;
			if(!isWindows()){
			}
			run(execCmd);
		  
	  }
	  
	  static boolean isWindows(){
		    String os = System.getProperty("os.name");  
		    if(os.toLowerCase().startsWith("win")){  
		    	return true;
		    }  
			return false;
		}
	 static void run(String command){
			try {
				Process process = Runtime.getRuntime().exec(command);
				int waitFor = process.waitFor();
				Thread.sleep(1000 * 2);
			} catch (Exception e) {
				System.out.println("调用指令异常,可能wkhtmltopdf插件未安装.");
			}
		}
	public static String readFile(String filename) throws Exception {
		
		StringBuffer buffer = new StringBuffer("");
		
		BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
		
		try {

			while (br.ready()) {
				buffer.append(br.readLine());
			}
		} catch (Exception e) {

		}
		return buffer.toString();
	}

	/**
	 * html转pdf
	 * 
	 * @param srcPath
	 *            html路径，可以是硬盘上的路径，也可以是网络路径
	 * @param destPath
	 *            pdf保存路径
	 * @return 转换成功返回true
	 */
	public static boolean convert(String srcPath, String destPath,String wkhtmltopdfAddres) {

		File file = new File(destPath);
		File parent = file.getParentFile();
		// 如果pdf保存路径不存在，则创建路径
		if (!parent.exists()) {
			parent.mkdirs();
		}

		StringBuilder cmd = new StringBuilder();
		cmd.append(wkhtmltopdfAddres);
		cmd.append(" ");
		cmd.append(srcPath);
		cmd.append(" ");

		cmd.append(" --page-size A4");// 设置纸张大小
		cmd.append(destPath);

		boolean result = true;
		try {
			Process proc = Runtime.getRuntime().exec(cmd.toString());
			HtmlToPdfInterceptor error = new HtmlToPdfInterceptor(proc.getErrorStream());
			HtmlToPdfInterceptor output = new HtmlToPdfInterceptor(proc.getInputStream());
			error.start();
			output.start();
			proc.waitFor();
			System.out.println("HTML2PDF成功");
		} catch (Exception e) {
			System.out.println(("HTML2PDF失败"));
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	public static class HtmlToPdfInterceptor extends Thread {

		private InputStream is;

		public HtmlToPdfInterceptor(InputStream is) {
			this.is = is;
		}

		public void run() {
			try {
				InputStreamReader isr = new InputStreamReader(is, "utf-8");
				BufferedReader br = new BufferedReader(isr);
				br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
