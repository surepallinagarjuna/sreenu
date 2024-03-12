package com.aem.geeks.core.servlets;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import java.io.IOException;


@Component(service = Servlet.class,
        property = {
                "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                "sling.servlet.resourceTypes=" + "aemgeeks/components/content/multifiled",
                "sling.servlet.selectors=jun",
                "sling.servlet.extensions=recent"
        })
        public class Junior extends SlingSafeMethodsServlet{

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
          String parameter = request.getParameter("page");
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(parameter);
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        try {
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                String responseBody = org.apache.http.util.EntityUtils.toString(httpResponse.getEntity());
                // response.setContentType("text/html");
                response.getWriter().write(responseBody);
            } else {
                response.getWriter().write("Failed to retrieve page: " + statusCode);
            }
        } finally {
            httpResponse.close();
            httpClient.close();
        }
    }
}