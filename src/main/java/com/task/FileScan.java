package com.task;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.core.task.support.ConcurrentExecutorAdapter;

public class FileScan implements Runnable {
	private ConcurrentHashMap<String, String> filePathMap = null;
	
	public FileScan(ConcurrentHashMap<String, String> filePathMap) {
		this.filePathMap = filePathMap;
	}

	public void run() {
		try {
			File inFile = new File("D:/inFile");
			BufferedInputStream bf = new BufferedInputStream(new FileInputStream(inFile));
			while(true){
				if(inFile.listFiles().length>0){
					File[] files = inFile.listFiles();
					for (File file : files) {
						 
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
