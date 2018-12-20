package com.smxy.healthmedical.service;

import javax.servlet.ServletOutputStream;
import java.io.FileInputStream;
public interface DownloadService {
	public void exportAls(FileInputStream fileInputStream,
                          ServletOutputStream outputStream);
	public void writeInExcel();
}
