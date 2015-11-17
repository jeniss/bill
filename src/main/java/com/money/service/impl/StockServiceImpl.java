package com.money.service.impl;

import com.money.mapper.StockMapper;
import com.money.po.Stock;
import com.money.service.IStockService;
import org.springframework.stereotype.Service;

/**
 * Created by jennifert on 2015/11/12.
 */
public class StockServiceImpl implements IStockService {
	private StockMapper stockMapper;

	public void setStockMapper(StockMapper stockMapper) {
		this.stockMapper = stockMapper;
	}

	@Override
	public void insertStock(Stock stock){
		stockMapper.insertStock(stock);
//		Integer.parseInt("adsd");
//		throw new RuntimeException("Error");
	}
}
