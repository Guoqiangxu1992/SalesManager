package com.xu.manager.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xu.manager.bean.CountByPrinvince;
import com.xu.manager.bean.CountMoneyByMonth;
import com.xu.manager.bean.Data;
import com.xu.manager.bean.ProductMoneyByName;
import com.xu.manager.bean.ProductNumByName;
import com.xu.manager.dao.CountMoneyByMonthDataDao;
import com.xu.manager.dao.CountMoneyByNameDataDao;
import com.xu.manager.dao.CountMoneyByPrinvinceDao;
import com.xu.manager.dao.DealDao;
import com.xu.manager.dao.PdByNumDataDao;

@Service("dealService")
@Scope("prototype")
@Transactional
public class DealServiceImpl implements DealService{

	@Autowired
	private DealDao dealDao;
	@Autowired
	private PdByNumDataDao pdByNumDataDao;
   @Autowired
   private CountMoneyByNameDataDao countMoneyByNameDataDao;
   @Autowired
   private CountMoneyByMonthDataDao countMoneyByMonthDataDao;
   @Autowired
   private CountMoneyByPrinvinceDao countMoneyByPrinvinceDao;
	public List<Data> query() {
		List<Data> list = dealDao.query();
		return list;
	}

	public List<ProductNumByName> queryPdByNumData() {
		List<ProductNumByName> list = pdByNumDataDao.query();
		return list;
	}

	@Override
	public List<ProductMoneyByName> countMoneyByNameData() {
		List<ProductMoneyByName> list = countMoneyByNameDataDao.query();
		return list;
	}

	@Override
	public List<CountMoneyByMonth> countMoneyByMonth() {
		List<CountMoneyByMonth> list = countMoneyByMonthDataDao.query();
		return list;
	}

	@Override
	public List<CountByPrinvince> countMoneyByPrinvince() {
		List<CountByPrinvince> list = countMoneyByPrinvinceDao.query();
		return list;
	}
	

}
