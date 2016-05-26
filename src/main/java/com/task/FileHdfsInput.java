package com.task;

import java.util.concurrent.ConcurrentHashMap;

public class FileHdfsInput implements Runnable {
	private ConcurrentHashMap<String, String> filePathMap = null;
	
	public FileHdfsInput(ConcurrentHashMap<String, String> filePathMap) {
		this.filePathMap = filePathMap;
	}

	public void run() {
		
	}

}
