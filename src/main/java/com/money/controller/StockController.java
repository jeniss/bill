package com.money.controller;

import com.money.po.Stock;
import com.money.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jennifert on 2015/11/12.
 */
@RequestMapping(value = "stock")
public class StockController {
	@Autowired
	private IStockService stockService;

	public void setStockService(IStockService stockService) {
		this.stockService = stockService;
	}

	@RequestMapping(value = "addStock.do")
	@ResponseBody
	public String insertStock(Stock stock) {
		stockService.insertStock(stock);
		return null;
	}
}
