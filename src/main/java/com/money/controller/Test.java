package com.money.controller;

import com.money.view.JspView;
import com.money.view.WrapperResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
}
