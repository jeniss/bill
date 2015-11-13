package com.money.service.impl;

import com.money.mapper.IStockMapper;
import com.money.po.Stock;
import com.money.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jennifert on 2015/11/12.
 */
@Service
public class StockServiceImpl implements IStockService {
	@Autowired
	private IStockMapper stockMapper;

	@Override
	public void insertStock(Stock stock){
		stockMapper.insertStock(stock);
		Integer.parseInt("adsd");
	}
}
