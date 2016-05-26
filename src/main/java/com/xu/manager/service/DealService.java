package com.xu.manager.service;

import java.util.List;

import com.xu.manager.bean.CountByPrinvince;
import com.xu.manager.bean.CountMoneyByMonth;
import com.xu.manager.bean.Data;
import com.xu.manager.bean.ProductMoneyByName;
import com.xu.manager.bean.ProductNumByName;

public interface DealService {
	List<Data> query();

	List<ProductNumByName> queryPdByNumData();

	List<ProductMoneyByName> countMoneyByNameData();

	List<CountMoneyByMonth> countMoneyByMonth();

	List<CountByPrinvince> countMoneyByPrinvince();

}
