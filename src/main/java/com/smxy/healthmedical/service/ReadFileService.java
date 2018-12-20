package com.smxy.healthmedical.service;

import com.smxy.healthmedical.bean.Info;
import org.apache.poi.hssf.usermodel.HSSFCell;

import java.io.IOException;
import java.util.List;
/**
 *
 * 功能描述:
 *
 * @param:
 * @return:
 * @author: luoxin
 * @date: 2018/10/26 15:38
 */

public interface ReadFileService {
	public List<Info> javaPoi(String realpath)throws  IOException;
    public List<Info> readXls(String realpath) throws IOException ;
    public String getValue(HSSFCell hssfCell) ;
}
