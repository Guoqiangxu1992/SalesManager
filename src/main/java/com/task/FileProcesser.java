package com.task;

import java.util.concurrent.ConcurrentHashMap;

public class FileProcesser {
	private static ConcurrentHashMap<String, String> filePathMap = new ConcurrentHashMap<String, String>();
	public static void main(String[] args) {
		new Thread(new FileScan(filePathMap)).start();
		new Thread(new FileHdfsInput(filePathMap)).start();
	}
}
