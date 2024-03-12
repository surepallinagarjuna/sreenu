package com.aem.geeks.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;


@Component (service =Servlet.class,
            immediate = true
    )
@SlingServletResourceTypes(resourceTypes =  {"/aemgeeks/service/naga"}, 
                   extensions = {"html","json","txt"},
                   methods = {"GET","Post","PUT","DELETE"},
                   selectors = {"s4","nani"}
                )
public class Recent extends SlingAllMethodsServlet{

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().write("respons path based");
    }
    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().write("respons path based Post");
    }
    @Override
    protected void doPut(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().write("respons path based Put");
    }
    @Override
    protected void doDelete(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().write("respons path based Delete");
    }

    
}

