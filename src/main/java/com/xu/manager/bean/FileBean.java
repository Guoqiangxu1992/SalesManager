package com.xu.manager.bean;

import org.apache.hadoop.fs.FileStatus;

public class FileBean {
	private String hdfsPath;
	private long fileSize;
	private long modifyTime;	
	private String fileName;
	private String fileDir;
	private boolean isDir;
	public String getHdfsPath() {
		return hdfsPath;
	}
	public void setHdfsPath(String hdfsPath) {
		this.hdfsPath = hdfsPath;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public long getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(long modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileDir() {
		return fileDir;
	}
	public void setFileDir(String fileDir) {
		this.fileDir = fileDir;
	}
	public boolean isDir() {
		return isDir;
	}
	public void setDir(boolean isDir) {
		this.isDir = isDir;
	}

	public FileBean(String hdfsPath, long fileSize, long modifyTime, String fileName, String fileDir, boolean isDir) {
		super();
		this.hdfsPath = hdfsPath;
		this.fileSize = fileSize;
		this.modifyTime = modifyTime;
		this.fileName = fileName;
		this.fileDir = fileDir;
		this.isDir = isDir;
	}
	
	@SuppressWarnings("deprecation")
	public FileBean(FileStatus fileStatus){
		hdfsPath = fileStatus.getPath().toString();
		fileSize = fileStatus.getLen();
		modifyTime = fileStatus.getModificationTime();
		fileName = fileStatus.getPath().getName();
		fileDir = fileStatus.getPath().getParent().getName();
		isDir = fileStatus.isDir();
	}	


}
