package com.smxy.healthmedical.serviceImpl;

import com.smxy.healthmedical.bean.Info;
import com.smxy.healthmedical.dao.InfoMapper;
import com.smxy.healthmedical.service.ReadFileService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/**
 * 功能描述:
 * @param:
 * @return:
 * @author: luoxin
 * @date: 2018/10/26 15:10
 */
@Service
public class ReadFileServiceImpl implements ReadFileService {
	@Autowired
    InfoMapper infoMapper;
	@Override
	public List<Info> javaPoi(String realpath) throws IOException {
		List<Info> list = readXls(realpath);
        System.out.print(list);
        for(int i=0;i < list.size();i++){
            Info info = new Info();
            info = list.get(i);
            infoMapper.insertSelective(info);
        }
      return list;
	}
	@Override
	public List<Info> readXls(String realpath) throws IOException {
		InputStream is = new FileInputStream(realpath);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        Info info = null;
        List<Info> list = new ArrayList<>();
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                   info = new Info();
//                    HSSFCell pinfoId = hssfRow.getCell(0);
                    HSSFCell pinfoName = hssfRow.getCell(0);
                    HSSFCell pinfoAge = hssfRow.getCell(1);
                    HSSFCell pinfoGender = hssfRow.getCell(2);
                    HSSFCell ppinfoIllname = hssfRow.getCell(3);
                    HSSFCell pinfoInfo = hssfRow.getCell(4);
                    HSSFCell piId = hssfRow.getCell(5);
                    //将id临时变成字符串
//                    pinfoId.setCellType(pinfoId.CELL_TYPE_STRING);
//                    info.setPinfoId(Integer.parseInt(getValue(pinfoId)));
                    info.setPinfoName(getValue(pinfoName));
                    info.setPinfoAge(getValue(pinfoAge));
                    info.setPinfoGender(getValue(pinfoGender));
                    info.setPpinfoIllname(getValue(ppinfoIllname));
                    info.setPinfoInfo(getValue(pinfoInfo));
                    //将部门id临时变成字符串
                    piId.setCellType(piId.CELL_TYPE_STRING);
                    System.out.println(getValue(piId));
                    info.setPiId(Integer.valueOf(getValue(piId)));
                    list.add(info);
                }
            }
        }
        return list;
	}
	@Override
	public String getValue(HSSFCell hssfCell) {
		if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
	}
}
