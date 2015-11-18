package com.money.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.money.util.exception.BusinessException;
import com.money.util.view.JSONModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jennifert on 2015/11/17.
 */
public abstract class BaseController {
	public static final String STATUS_SUCCESS_KEY = "success";
	public static final String STATUS_SYS_ERROR_KEY = "systemError";
	public static final String STATUS_BIZ_ERROR_KEY = "businessError";
	public static final String STATUS_NEED_LOGIN_KEY = "needLogin";
	protected Log logger = LogFactory.getLog(getClass());

	protected String createJson(Map<String, Object> model) {
		BaseModel baseModel = new BaseModel();
		baseModel.setData(model);
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(baseModel.toMap());
		} catch (JsonProcessingException e) {
			logger.error(Thread.currentThread().getStackTrace()[1].getClassName() + " : " + Thread.currentThread().getStackTrace()[1].getMethodName(), e);
			return "";
		}
	}

	protected String createErrorJson(Exception e) {
		logger.error(Thread.currentThread().getStackTrace()[1].getClassName() + " : " + Thread.currentThread().getStackTrace()[1].getMethodName(), e);
		BaseModel baseModel = new BaseModel();
		baseModel.setStatus(STATUS_SYS_ERROR_KEY);
		baseModel.setErrorMessage(e.getMessage());
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(baseModel.toMap());
		} catch (JsonProcessingException e1) {
			logger.error(Thread.currentThread().getStackTrace()[1].getClassName() + " : " + Thread.currentThread().getStackTrace()[1].getMethodName(), e1);
			return "";
		}
	}

	protected String createBusinessErrorJson(BusinessException e) {
		logger.error(Thread.currentThread().getStackTrace()[1].getClassName() + " : " + Thread.currentThread().getStackTrace()[1].getMethodName(), e);
		BaseModel baseModel = new BaseModel();
		baseModel.setStatus(STATUS_BIZ_ERROR_KEY);
		baseModel.setErrorMessage(e.getMessage());
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(baseModel.toMap());
		} catch (JsonProcessingException e1) {
			logger.error(Thread.currentThread().getStackTrace()[1].getClassName() + " : " + Thread.currentThread().getStackTrace()[1].getMethodName(), e1);
			return "";
		}
	}


	/**
	 * the base model for output
	 */
	public final class BaseModel {
		private Object data;
		private String status = STATUS_SUCCESS_KEY;
		private String errorMessage;

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}

		public Map<String, Object> toMap() {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("status", status);
			map.put("errorMessage", errorMessage == null ? "" : errorMessage);
			map.put("data", getData());
			return map;
		}
	}

}
