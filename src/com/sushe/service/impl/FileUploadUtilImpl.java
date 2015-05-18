package com.sushe.service.impl;

import com.sushe.service.FileUploadUtil;
import org.aspectj.util.FileUtil;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/*
 * 实现文件上传的功能, 注意:一个功能封装成一个方法
 * */
@Service("fileUploadUtil")
public class FileUploadUtilImpl implements FileUploadUtil {
	// 获取文件的后缀名
	/*@SuppressWarnings("unused")
	private String getExtName(String oldName) {
		return FilenameUtils.getExtension(oldName);
	}*/

	// 生成唯一的文件名
	private String newFileName(String oldName) {
		return UUID.randomUUID().toString() + "-" + oldName;
	}

	// 传入新的文件名,和文件对象,实现文件长传功能,返回新的文件名
	@Override
	public String upload(File file, String oldName, String uploadPath) {
		String newName = this.newFileName(oldName);
		try {
			FileUtil.copyFile(file, new File(uploadPath, newName));
		} catch (Exception e) {
			// 没有处理异常,只是在控制输出异常信息
			// e.printStackTrace();
			throw new RuntimeException("数据类型转化出错!");
		} finally {
			file.delete();
		}
		return newName;
	}

	/**
	 *
	 * @param stream 输入流
	 * @param path 上传路径
	 * @param filename 文件名称
	 * @throws java.io.IOException
	 */
	public String SaveFileFromInputStream(InputStream stream,String path,String filename) throws IOException
	{
		File savedir140 = new File(path);
		// 如果目录不存在就创建
		if (!savedir140.exists()) {
			savedir140.mkdirs();
		}
		String newName = this.newFileName(filename);
		FileOutputStream fs=new FileOutputStream( path + "/"+ newName);
		byte[] buffer =new byte[1024*1024];
		int bytesum = 0;
		int byteread = 0;
		while ((byteread=stream.read(buffer))!=-1)
		{
			bytesum+=byteread;
			fs.write(buffer,0,byteread);
			fs.flush();
		}
		fs.close();
		stream.close();
		return newName;
	}

}
