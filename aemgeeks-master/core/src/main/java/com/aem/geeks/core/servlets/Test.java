package com.aem.geeks.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;


//@SlingServlet(paths="/bin/trainingproject/testservlet")  --Felix SCR Annotation

//OSGI Declarative Service Annotation
@Component(
		service=Servlet.class,
		property={
				"sling.servlet.paths="+ "/bin/capstone"
		}
)

public class Test extends SlingSafeMethodsServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
    	response.setHeader("Content-Type", "text/html");
    	response.getWriter().print("<h1>Sling Servlet Called</h1>"); 
    	response.getWriter().close();
    }   
}