package com.aem.geeks.core.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Servlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.aem.geeks.core.services.Osg;
import com.day.cq.wcm.api.Page;


@Component(service = Servlet.class)
@SlingServletPaths(
    value = {"/bin/manu"})

public class OSGIExampleServlet  extends SlingAllMethodsServlet
{
     @Reference
     Osg  OsgExample; 

    @Override
    protected void doGet(SlingHttpServletRequest req,SlingHttpServletResponse res) throws IOException{

        List<String> listPages = new ArrayList<String>();


        try {
            Iterator<Page> pages=OsgExample.getlistChildren(req);
            while (pages.hasNext()) {
                listPages.add(pages.next().getTitle());
            }
        } catch (Exception e) {
           
        }
        res.setContentType("application/json");
        res.getWriter().write(listPages.toString());
    }

       
}

    

