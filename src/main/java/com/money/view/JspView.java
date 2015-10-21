package com.money.view;

import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by jennifert on 2015/10/21.
 */
public class JspView extends AbstractView {

	public static final String JSP_FILE_ROOT = "/WEB-INF/jsp";
	public static final String RESOURCE_BUNDLE_JSP = "/WEB-INF/jsp/resourceBundle.jsp";
	protected String prefixPath = JSP_FILE_ROOT;
	protected String filePath;
	private static JspView instance = new JspView();

	public JspView() {
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		if (model != null) {
			for (Map.Entry<String, Object> entry : model.entrySet()) {
				request.setAttribute(entry.getKey(), entry.getValue());
			}
		}
		String jspFile = null;
		if (filePath != null) {
			jspFile = prefixPath + filePath;
		} else {
			jspFile = prefixPath + url.substring(0, url.lastIndexOf(".")) + ".jsp";
		}
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher(RESOURCE_BUNDLE_JSP).include(request, response);
		request.getRequestDispatcher(jspFile).forward(request, response);
	}

	public JspView(String filePath) {
		this.filePath = filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void setPrefixPath(String prefixPath) {
		this.prefixPath = prefixPath;
	}

	public static JspView getSingletonInstance() {
		return instance;
	}

}

