package com.xu.manager.bean;

import java.util.ArrayList;

import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;


public class HDFSOperation {
	
	private FileSystem fs;
	
	public ArrayList<FileBean> getFileList(String hdfsPath){
		Path path = new Path(hdfsPath);
		ArrayList<FileBean> fileList = new ArrayList<FileBean>();
		FileStatus[] status;
		try {
			status = fs.listStatus(path);
			for(FileStatus fs : status){
				fileList.add(new FileBean(fs));
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return fileList;
		
	}

}
