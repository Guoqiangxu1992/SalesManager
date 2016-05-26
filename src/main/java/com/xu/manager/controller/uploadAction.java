package com.xu.manager.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
/*import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.xu.hdfs.HdfsPath;
import com.xu.manager.bean.Car;
import com.xu.manager.bean.DateFormat;
import com.xu.manager.bean.LoginUser;
import com.xu.manager.bean.PageBean;
import com.xu.manager.service.CarService;

@Controller
@Scope("prototype")
@RequestMapping("/hdfs")

public class uploadAction {

/*上传文件到hdfs*/
@RequestMapping(value = "/uploadfile.do")  
@ResponseBody
public String uploadUserIcon(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) {  
 if(file!=null){
	 String filepath = "hdfs://192.168.236.130:9000/user/input/"+file.getOriginalFilename(); 
	 String filename = file.getOriginalFilename();//文件名
	 if(filename.trim()!=""){
		 System.out.println("======>"+filename+"开始上传！！");
			//文件名
			Configuration configuration = new Configuration();
		    configuration.addResource("/core-site.xml");
		   configuration.addResource("/hdfs-site.xml");
		    try {
				FileSystem fs = FileSystem.get(URI.create(filepath),configuration);
				byte[] bytes = file.getBytes();
				InputStream inputStream = new ByteArrayInputStream(bytes);
				FSDataOutputStream outputStream = fs.create(new Path(filepath));
				IOUtils.copyBytes(inputStream, outputStream, 1024, true);
				System.out.println("======>"+filename+"上传成功！！");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		    
	 }
 }
	return "success";
   }

/*跳转到上传页面*/
@RequestMapping(value = "/upload.do")
public ModelAndView detail(Model model){
	return new ModelAndView("file/uploadFile");
}


/*跳转到上传程序上传页面*/
@RequestMapping(value = "/Proupload.do")
public ModelAndView proUpload(Model model){
	return new ModelAndView("file/proupload");
}



/*上传处理程序*/
@RequestMapping(value = "/uploadprogram.do")  
@ResponseBody
public String uploadUserIcon(HttpSession session,@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {  
     String name = file.getOriginalFilename();
     //String lastname=name.substring(name.lastIndexOf("."),name.length());
     String path = "/workspace";
	// String fileName = currentDate+ lastname;
	// String path = request.getSession().getServletContext()
			//	.getRealPath("workspace");
	// String a =  path.substring(0,path.length()-20);
	 //String upPath = path.substring(0,path.length()-20)+"\\uploadImage";
		File targetFile = new File(path, name);
	if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
	
	//carService.saveImag(currentDate,id);
	// 保存
	try {
		file.transferTo(targetFile);
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("上传处理程序失败");
	}
	return path;
   }
}
