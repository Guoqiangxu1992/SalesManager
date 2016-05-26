package com.xu.manager.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.xu.manager.bean.FileBean;
import com.xu.manager.bean.HDFSOperation;


@Controller
@Scope("prototype")
@RequestMapping("/list")
public class ListAction {
	
	@RequestMapping(value = "/getlist.do")
	public ModelAndView getList(){
		return new ModelAndView("file/list");
	}
	
	@RequestMapping(value = "/list.do")
	@ResponseBody
	public String list() throws IOException, URISyntaxException{
		// HDFSOperation hdfsOperation = new HDFSOperation();	  
		 Configuration configuration = new Configuration();
		    configuration.addResource("/core-site.xml");
		   configuration.addResource("/hdfs-site.xml");
		   FileSystem fs = FileSystem.get(URI.create("hdfs://192.168.236.130:9000/user/input/"),configuration);
		   ArrayList<FileBean> fileList = new ArrayList<FileBean>();
			Path path = new Path("hdfs://192.168.236.130:9000/user/input/");
			FileStatus[] status;
			try {
				status = fs.listStatus(path);
				for(FileStatus f : status){
					fileList.add(new FileBean(f));
				}
			} catch (Exception e) {			
				e.printStackTrace();
			}
			//model.addAttribute("fileList",fileList);
			//return "success";
		   // ArrayList<FileBean> fileList = hdfsOperation.getFileList("hdfs://192.168.236.130:9000/user/");
		    for(int i =0;i<fileList.size();i++){
		    	System.out.println(fileList.get(i));
		    	System.out.println(fileList.get(i).getFileDir());
		    	System.out.println(fileList.get(i).getFileSize());
		    	System.out.println(fileList.get(i).getFileName());
		    	System.out.println(fileList.get(i).getHdfsPath());
		    	System.out.println(fileList.get(i).getModifyTime());
		    }	
		    Gson gson = new Gson();
		    String json = gson.toJson(fileList);
		return json;
	}
	

}
