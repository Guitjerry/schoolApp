package com.sushe.service;

import java.io.File;
import java.io.InputStream;

public interface FileUploadUtil {
	// 传入新的文件名,和文件对象,实现文件长传功能,返回新的文件名
	public abstract String upload(File file, String oldName, String uploadPath);
	public void SaveFileFromInputStream(InputStream stream,String path,String filename) throws Exception;

}
