package com.aem.geeks.core.servlets;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;

import com.day.cq.commons.jcr.JcrConstants;

import org.apache.sling.servlets.annotations.SlingServletResourceTypes;

@Component(service = Servlet.class)
@SlingServletResourceTypes(
    resourceTypes = "aemgeeks/components/page"
)
public class DemoServlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {

        final Resource resource = request.getResource();
        response.setContentType("text/plain");

        String pageTitle = resource.getValueMap().get(JcrConstants.JCR_TITLE, String.class);
        if (pageTitle == null) {
            pageTitle = "No title found";
        }

        response.getWriter().write("Page title = " + pageTitle);
    }
}
