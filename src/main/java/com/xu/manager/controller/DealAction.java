package com.xu.manager.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.xu.manager.bean.CountByPrinvince;
import com.xu.manager.bean.CountMoneyByMonth;
import com.xu.manager.bean.Data;
import com.xu.manager.bean.ProductMoneyByName;
import com.xu.manager.bean.ProductNumByName;
import com.xu.manager.service.DealService;

@Controller
@Scope("prototype")
@RequestMapping("/deal")
public class DealAction {
	@Autowired
	private DealService dealService;
	/*产品销售总额报表*/
	@RequestMapping(value = "countMonByPro.do")
	public ModelAndView view(Model model){
		return new ModelAndView("report/countMonByPro");
		
	}
	
	
	@RequestMapping(value = "/countMonByProData.do")
	@ResponseBody
	public String fileReader() throws IOException{
		
		List<Data> list = dealService.query();
		Gson gson = new Gson();
		String json = gson.toJson(list);
        return json ;		
		
	}
	
/*商品销售数量报表*/
	
	
	@RequestMapping(value = "/countNumByName.do")
	public ModelAndView pdByNum(Model model){
		return new ModelAndView("report/countNumByName");
		
	}
	
	@RequestMapping(value = "/countNumByNameData.do")
	@ResponseBody
	public String pdByNumDataReader() throws IOException{
		
		List<ProductNumByName> list = dealService.queryPdByNumData();
		Gson gson = new Gson();
		String json = gson.toJson(list);
        return json ;		
		
	}
	
	
/*员工销售额报表*/
	
	
	@RequestMapping(value = "/countMoneyByName.do")
	public ModelAndView countMoneyByName(Model model){
		return new ModelAndView("report/countMoneyByName");
		
	}
	
	@RequestMapping(value = "/countMoneyByNameData.do")
	@ResponseBody
	public String countMoneyByNameData() throws IOException{
		
		List<ProductMoneyByName> list = dealService.countMoneyByNameData();
		Gson gson = new Gson();
		String json = gson.toJson(list);
        return json ;		
		
	}
	/*月份销售趋势报表*/
	@RequestMapping(value = "/countMoneyByMonth.do")
	public ModelAndView countMoneyByMonth(Model model){
		return new ModelAndView("report/countMoneyByMonth");
		
	}
	
	@RequestMapping(value = "/countMoneyByMonth1.do")
	@ResponseBody
	public String countMoneyByMonth1() throws IOException{
		
		List<CountMoneyByMonth> list = dealService.countMoneyByMonth();
		Gson gson = new Gson();
		String json = gson.toJson(list);
        return json ;		
		
	}
	
	/*区域销售趋势报表*/
	@RequestMapping(value = "/countMoneyByPrinvince.do")
	public ModelAndView countMoneyByPrinvince(Model model){
		return new ModelAndView("report/countMoneyByPrinvince");
		
	}
	
	@RequestMapping(value = "/countMoneyByPrinvince1.do")
	@ResponseBody
	public String countMoneyByPrinvince1() throws IOException{
		
		List<CountByPrinvince> list = dealService.countMoneyByPrinvince();
		int j = list.size();
		List<CountByPrinvince> list1 = new ArrayList<CountByPrinvince>();
		for(int i = 0;i<j;i++){
			double mon = list.get(i).getValue();
			double a1 = changeDouble(mon);
			String pri = list.get(i).getPrinvince();
			CountByPrinvince cp = new CountByPrinvince();
			cp.setValue(a1);
			cp.setPrinvince(pri);
			list1.add(cp);
		}
		Gson gson = new Gson();
		String json = gson.toJson(list1);
        return json ;		
		
	}
	
	
	//double 类型保留一位小数
    public double changeDouble(Double dou){
        NumberFormat   nf=new  DecimalFormat( "0.0 ");
        dou = Double.parseDouble(nf.format(dou));
        return dou;
    }
	
}
