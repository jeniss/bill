package com.money.controller;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.money.po.TestObject;
import com.money.view.JspView;
import com.money.view.WrapperResponseUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jennifert on 2015/10/21.
 */
@Controller
@RequestMapping(value = "/test")
public class Test {
	@RequestMapping(value = "/testView.do")
	public ModelAndView testView(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();

		model.put("childPage", "childPage");
		String content = WrapperResponseUtil.getInstance().getHTML(new JspView("/test2.jsp"), request, response, model);
		model.put("content", content);

		return new ModelAndView("/test1", model);
	}

	@RequestMapping(value = "/testJson.do")
	@ResponseBody
	public String testJson() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("datetime", new Date());
		model.put("name:", "哈哈");
		model.put("des", "hehe");


		TestObject test = new TestObject();
		test.setName("哈哈");
		test.setDes("hehe");
		test.setDatetime(new Date());
		model.put("test", test);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", model);
		return jsonObject.toString();
	}
}
