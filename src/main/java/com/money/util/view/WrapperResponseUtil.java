package com.money.util.view;

import org.springframework.web.servlet.view.JstlView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by jennifert on 2015/10/21.
 */
public class WrapperResponseUtil {
	private static WrapperResponseUtil wrapperResponseUtil;

	public static WrapperResponseUtil getInstance() {
		if (wrapperResponseUtil == null) {
			wrapperResponseUtil = new WrapperResponseUtil();
		}
		return wrapperResponseUtil;
	}

	public String getHTML(JspView jspView, HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) {
		if (jspView != null) {
			WrapperResponse wrapperResponse = new WrapperResponse(response);
			try {
				jspView.render(model, request, wrapperResponse);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return wrapperResponse.getHTML();
		}
		return null;
	}

	private class WrapperResponse extends HttpServletResponseWrapper {
		private CharArrayWriter charArrayWriter;
		private PrintWriter printWriter;

		public WrapperResponse(HttpServletResponse response) {
			super(response);
			charArrayWriter = new CharArrayWriter();
			printWriter = new PrintWriter(charArrayWriter);
		}

		@Override
		public PrintWriter getWriter() throws IOException {
			return printWriter;
		}

		public String getHTML() {
			return charArrayWriter.toString();
		}
	}
}
