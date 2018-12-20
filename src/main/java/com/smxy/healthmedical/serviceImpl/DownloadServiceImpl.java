///*
//package com.smxy.healthmedical.serviceImpl;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.ServletOutputStream;
//
//import com.smxy.healthmedical.bean.Info;
//import com.smxy.healthmedical.dao.InfoMapper;
//import com.smxy.healthmedical.service.DownloadService;
//import jxl.Workbook;
//import jxl.WorkbookSettings;
//import jxl.write.Label;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//
//import org.apache.commons.lang3.StringUtils;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.smxy.medical.bean.Info;
//import com.smxy.medical.dao.InfoMapper;
//import com.smxy.medical.service.DownloadService;
//
//@Service("DownloadService")
//public class DownloadServiceImpl implements DownloadService {
//	@Autowired
//	InfoMapper infoMapper;
//	Info info;
////	@Override
//	public void exportAls(FileInputStream fileInputStream,ServletOutputStream outputStream) {
//		// Workbook工作簿
//		XSSFWorkbook book = null;
//		try {
//			book = new XSSFWorkbook(fileInputStream);
//		} catch (IOException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		//工作表 sheet
//		XSSFSheet sheet = book.getSheetAt(0);
//		List<Info> list = infoMapper.selectByExampleWithDept(null);
//		System.out.println(list.size());
//		int rowIndex = 1;//让表格从第二行开始导入
//		XSSFCell cell = null;
//		for (Info info : list) {
//			XSSFRow row = sheet.createRow(rowIndex);
//			int pinfoId = info.getPinfoId();
//			String pinfoName = info.getPinfoName();
//			String pinfoGender = info.getPinfoGender();
//			String ppinfoIllname = info.getPpinfoIllname();
//			String pinfoInfo = info.getPinfoInfo();
//			int piId = info.getPiId();
//			cell = row.createCell(0);
//			if(pinfoId != 0){
//				cell.setCellValue(pinfoId);
//			}
//			cell = row.createCell(1);
//			if(pinfoName != null){
//				cell.setCellValue(pinfoName);
//			}
//			cell = row.createCell(2);
//			if(pinfoGender != null){
//				cell.setCellValue(pinfoGender);
//			}
//			cell = row.createCell(3);
//			if(ppinfoIllname != null){
//				cell.setCellValue(ppinfoIllname);
//			}
//			cell = row.createCell(4);
//			if(pinfoInfo != null){
//				cell.setCellValue(pinfoInfo);
//			}
//			cell = row.createCell(6);
//			if(piId != 0){
//				cell.setCellValue(piId);
//			}
//		}
//		try {
//			book.write(outputStream);
//		} catch (IOException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//	}
//	*/
///*@Autowired
//	Info info;*//*
//
////	@Override
//	public void writeInExcel() {
//		List<String> headList = new ArrayList<>();
//        headList.add("pinfoId");
//        headList.add("pinfoName");
//        headList.add("pinfoGender");
//        headList.add("ppinfoIllname");
//        headList.add("pinfoInfo");
//        headList.add("piId");
//		String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//        basePath = StringUtils.substringBeforeLast(basePath, "/");
//        basePath = StringUtils.substringBeforeLast(basePath, "/");
//        basePath = StringUtils.substringBeforeLast(basePath, "/");
//        basePath = basePath+"/download/";
//        File templateFile = new File(basePath + "demo.xls");
//        //（二）导出的文件流
//        String resultFilePath = basePath + "patients.xls";
//        File resultFile = new File(resultFilePath);
//        //（三）excel文件对象
//        Workbook wb = null;//初始化一个EXCEL文件
//        WorkbookSettings settings = new WorkbookSettings();//Linux,wins关于单元格最大的字符限制
//        settings.setWriteAccess(null);
//        WritableWorkbook wwb = null;
//
//        try {
//            wb = Workbook.getWorkbook(templateFile);
//            wwb = Workbook.createWorkbook(resultFile, wb, settings);
//            WritableSheet sheet = wwb.createSheet("Sheet1", 0);//excel的工作表格
//            for (int i = 0; i < headList.size(); i++) {//数据 的列数
//                Label la = new Label(i, 0, wb.getSheet(0).getCell(i, 0).getContents());
//                sheet.addCell(la);
//            }
//            List<Map<Object, Object>> dataList=new ArrayList<>();
//            sheet.setRowView(0, 300);//设置第一行高度
//            List<Info> list = infoMapper.selectByExampleWithDept(null);
//            for (Info info : list) {
//            	Map<Object, Object> temp = new HashMap<>();
//            	temp.put("pinfoId",info.getPinfoId());
//                temp.put("pinfoName",info.getPinfoName());
//                temp.put("pinfoGender",info.getPinfoGender());
//                temp.put("ppinfoIllname",info.getPpinfoIllname());
//                temp.put("pinfoInfo",info.getPinfoInfo());
//                temp.put("piId",info.getPiId());
//                dataList.add(temp);
//			}
//            //导进excel的数据
//            for (int i = 0; i < dataList.size(); i++) {
//                Map<Object, Object> map = dataList.get(i);
//                Label C1 = new Label(0, i + 1, map.get("pinfoId").toString());
//                Label C2 = new Label(1, i + 1, (String) map.get("pinfoName"));
//                Label C3 = new Label(2, i + 1, (String) map.get("pinfoGender"));
//                Label C4 = new Label(3, i + 1, (String) map.get("ppinfoIllname"));
//                Label C5 = new Label(4, i + 1, (String) map.get("pinfoInfo"));
//                Label C6 = new Label(5, i + 1, map.get("piId").toString());
//                sheet.addCell(C1);
//                sheet.addCell(C2);
//                sheet.addCell(C3);
//                sheet.addCell(C4);
//                sheet.addCell(C5);
//                sheet.addCell(C6);
//            }
//            wwb.write();
//            wwb.close();
//            wb.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//	}
//}
//*/
