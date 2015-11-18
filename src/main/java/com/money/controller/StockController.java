package com.money.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.money.po.Stock;
import com.money.service.IStockService;
import com.money.util.view.JspView;
import com.money.util.view.WrapperResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jennifert on 2015/11/12.
 */
@Controller
@RequestMapping(value = "/stock")
public class StockController extends BaseController{
	@Autowired
	private IStockService stockService;

	@RequestMapping(value = "/addStock.do")
	@ResponseBody
	public BaseModel insertStock() {
		Stock stock = new Stock();
		try {
			stock.setCode("hhh123#哈哈");

			stock.setEntryDatetime(new Date());
			stock.setUpdateDatetime(new Date());
			stockService.insertStock(stock);
		}catch (Exception e) {
			logger.error(Thread.currentThread().getStackTrace()[1].getClassName() + " : " + Thread.currentThread().getStackTrace()[1].getMethodName(), e);
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Stock", stock);

		BaseModel baseModel = new BaseModel();
		baseModel.setData(map);
		return baseModel;
	}

	@RequestMapping(value = "/test.do")
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("childPage", "childPage22222222哈哈");
		String htmlData = WrapperResponseUtil.getInstance().getHTML(new JspView("/stock/test2.jsp"), request, response, model);

		model.put("content", htmlData);
		return new ModelAndView("/stock/test1", model);
	}
}
