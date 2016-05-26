package com.task;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.xu.manager.bean.DateFormat;
import com.xu.manager.bean.Order;
import com.xu.manager.dao.OrderDao;
@Component
public class TimeTask implements org.quartz.Job{
	 @Autowired
	 private OrderDao orderDao;
	 private static int k=0;
		 public void execute(JobExecutionContext arg0) throws JobExecutionException {
			   //业务逻辑 
	/*		 
		      System.out.println("定时任务"+ k++ +"开始执行----现在的时间是--"+DateFormat.getCurrentDateTimeStr());  
		      Order order = new Order();
		     List<Order> list =  orderDao.queryShopping(order);
		     for(int i=0;i<list.size();i++){
		    	 String orderTime = list.get(i).getOrderTime();
		    	 int status = list.get(i).getStatus();
		    	 String systemTime = DateFormat.getCurrentDateTimeStr();
		    	 String str1 = orderTime.substring(14, 16);//预定时间的分钟数
		    	 String str2 = systemTime.substring(14, 16);//当前系统时间
		    	 int a1 =Integer.parseInt(str1);
		    	 int a2 = Integer.parseInt(str2);
		    	 int a3 = Math.abs(a2-a1);
		    	 System.out.println(orderTime);
		    	 System.out.println(systemTime);
		    	 System.out.println(a3);
		    	 System.out.println(status);
		    	 if(a3 >=3&&status==2){//订单超过多少时间没处理并且汽车状态一直处于预定状态
		    		 orderDao.delete(String.valueOf(list.get(i).getId()));//删掉订单表里面的订单
		    		 System.out.println("已经删掉订单表里面的订单");
		    		 orderDao.updateStatusCar(String.valueOf(list.get(i).getId()));//更新汽车销售表里面汽车销售状态
		    		 System.out.println("更新汽车销售表里面汽车销售状态");
		    	 }
		     }
		     
		     System.out.println("........................");*/
			/* String path = "hdfs://192.168.236.130:9000/user/output/";
			 String localPath = "D:/downland/";
			 Path p = new Path(path);
			 Configuration configuration = new Configuration();
				configuration.addResource("/core-site.xml");
				configuration.addResource("/hdfs-site.xml");
				FileSystem fs = FileSystem.get(new URI("hdfs://ns1"),configuration);
				FSDataInputStream in =  fs.open(p);
				OutputStream out = new FileOutputStream(localPath);
				String tempPath = new String(path.getBytes("ISO-8859-1"),"UTF-8");
				String[] ps = tempPath.split("//ns1");
				if(ps.length>1){
					path = ps[1];
				}else {
					throw new Exception();
				}
				System.out.println(path);
				//FSDataInputStream inputStream = fs.open(new Path(path));
				//OutputStream ou = new FileOutputStream(localPath);
				//response.setContentType("application/octet-stream");  
		       // response.setHeader("Content-disposition", "attachment; filename="+fileName); 
		        //输出流
		        //BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());  
		        byte[] buff = new byte[2048];  
		        int bytesRead;  
		        while (-1 != (bytesRead = in.read(buff, 0, buff.length))) {  
		            out.write(buff, 0, bytesRead);  
		        }  
		        out.flush();
		        in.close();  
		        out.close(); */
				//return "success";
		 }
		 
		 
		
		}


