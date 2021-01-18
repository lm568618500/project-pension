package com.baidu.ueditor.upload;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;



public class ExcelUtils {
	
	private static HSSFWorkbook workbook;

	public static void excelUtils(HttpServletResponse response,List<?> list,String[] header,String[] value,String name) throws IOException{
	    workbook = new HSSFWorkbook();

	    //生成一个表格，设置表格名称为"学生表"
	    HSSFSheet sheet = workbook.createSheet(name);

	    //设置表格列宽度为10个字节
	    sheet.setDefaultColumnWidth(15);

	    //创建第一行表头
	    HSSFRow headrow = sheet.createRow(0);
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        // 设置表头样式
        HSSFCellStyle style = workbook.createCellStyle();
	    //遍历添加表头(下面模拟遍历学生，也是同样的操作过程)
	    for (int i = 0; i < header.length; i++) {
	        //创建一个单元格
	        HSSFCell cell = headrow.createCell(i);

	        //创建一个内容对象
	        HSSFRichTextString text = new HSSFRichTextString(header[i]);

	        //将内容对象的文字内容写入到单元格中
	        cell.setCellValue(text);
	        
	    }
	    // 修改全局的全局日期格式
	   JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	   // 使用默认的全局日期格式
	   String r =  JSON.toJSONString(list,SerializerFeature.WriteDateUseDateFormat);
	    JSONArray jSONArray = JSONArray.parseArray(r);
	    for (int i = 0; i < jSONArray.size(); i++) {
	    	JSONObject obj = jSONArray.getJSONObject(i);
	        HSSFRow row = sheet.createRow(i + 1);
			for (int j = 0; j < value.length; j++) {
        	    Object data = obj.get(value[j]);
            	HSSFCell cell = row.createCell(j);
            	if(null != data){
            	   String str = data.toString();
            	   if(isHttpUrl(str) && (str.endsWith(".png") || str.endsWith(".jpg") || str.endsWith(".jpeg")  || str.endsWith(".gif"))){
            		   row.setHeight((short) (800));
                       drawPictureInfoExcel(workbook, patriarch, j,(i+1), data.toString()); 
            	   }else{
            		   setExcelValue(row.createCell(j), data, style);
            	   }
            	}else{
				   cell.setCellValue("");
            	}
			}
	    }
	    //准备将Excel的输出流通过response输出到页面下载
	    //八进制输出流
	    response.setContentType("application/octet-stream;charset=utf-8");
	    //这后面可以设置导出Excel的名称，此例中名为student.xls
	    response.setHeader("Content-disposition", "attachment;filename="+new String(name.getBytes(),"iso-8859-1")+".xls");
	    //刷新缓冲
	    response.flushBuffer();
	    //workbook将Excel写入到response的输出流中，供页面下载
	    workbook.write(response.getOutputStream());
	}
	
	
	private static void drawPictureInfoExcel(HSSFWorkbook wb,HSSFPatriarch patriarch,int col,int row,String pictureUrl){
        //rowIndex代表当前行
        try {
            URL url = new URL(pictureUrl);  
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
            //anchor主要用于设置图片的属性  
            HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 1023, 250,(short) col, row, (short) col, row);
            //Sets the anchor type （图片在单元格的位置）
            //0 = Move and size with Cells, 2 = Move but don't size with cells, 3 = Don't move or size with cells.
            anchor.setAnchorType(3);
            patriarch.createPicture(anchor, wb.addPicture(data, HSSFWorkbook.PICTURE_TYPE_JPEG));   
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] readInputStream(InputStream inStream) throws Exception{  
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
    
    /**
     * 设置Excel浮点数可做金额等数据统计
     * @param cell 单元格类
     * @param value 传入的值
     */
    public static void setExcelValue(HSSFCell cell, Object value, HSSFCellStyle style){
        if (value instanceof Integer || value instanceof Long) {
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(Long.valueOf(value.toString()));
        } else if (value instanceof BigDecimal) {
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(((BigDecimal)value).setScale(2, RoundingMode.HALF_UP).doubleValue());
        } else if (value instanceof Date) {
            System.out.println(value);
        } else {
            cell.setCellValue(value.toString());
        }
        cell.setCellStyle(style);
    }
    /**
     * 判断字符串是否为URL
     * @param urls 用户头像key
     * @return true:是URL、false:不是URL
     */
    public static boolean isHttpUrl(String urls) {
        boolean isurl = false;
        String regex = "(((https|http)?://)?([a-z0-9]+[.])|(www.))"
            + "\\w+[.|\\/]([a-z0-9]{0,})?[[.]([a-z0-9]{0,})]+((/[\\S&&[^,;\u4E00-\u9FA5]]+)+)?([.][a-z0-9]{0,}+|/?)";//设置正则表达式
        Pattern pat = Pattern.compile(regex.trim());//比对
        Matcher mat = pat.matcher(urls.trim());
        isurl = mat.matches();//判断是否匹配
        if (isurl) {
            isurl = true;
        }
        return isurl;
    }

}
