package com.mst.core.contexthub.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import com.google.gson.Gson;

@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "= Context Hub User Store Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths=/bin/mst/contexthub/user",
})
public class UserStoreServlet extends SlingSafeMethodsServlet {
	
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		
		Map<String, String> userMap = new HashMap<String, String>();
		userMap.put("gender", "male");
		userMap.put("age", "33");
		userMap.put("city", "phoenix");
		
		response.setContentType("text/json");
		response.getWriter().write(new Gson().toJson(userMap));
		
	}

}
