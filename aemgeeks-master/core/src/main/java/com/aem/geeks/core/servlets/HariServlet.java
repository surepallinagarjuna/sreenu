package com.aem.geeks.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;

@Component(service = Servlet.class)
@SlingServletPaths(value = {"/bin/laya"})
public class HariServlet extends SlingSafeMethodsServlet {

    protected void doGet(SlingHttpServletRequest req, SlingHttpServletResponse res) throws IOException{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://surgesoftware.co.in/");
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);    
        try {
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                String responseBody = EntityUtils.toString(httpResponse.getEntity());
                int startIndex = responseBody.indexOf("<head>");
                int endIndex = responseBody.indexOf("</head>");
                
                if (startIndex != -1 && endIndex != -1) {
                    String headerHtml = responseBody.substring(startIndex, endIndex + "</head>".length());
    
                    res.getWriter().write(headerHtml);
                } else {
                    res.getWriter().write("Footer not found in the page.");
                }
            } else {
                res.getWriter().write("Failed to retrieve page: " + statusCode);
            }
        } finally {
            httpResponse.close();
            httpClient.close();
}
}


    }
    

