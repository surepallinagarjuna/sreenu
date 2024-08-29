package com.aem.geeks.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.framework.Constants;
import javax.servlet.Servlet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Component(service = Servlet.class, property = {
        Constants.SERVICE_DESCRIPTION + "=Stack Exchange API Servlet",
        "sling.servlet.methods=" + "GET",
        "sling.servlet.paths=" + "/bin/stackexchange/questions"
})
public class StackExchangeServlet extends SlingAllMethodsServlet {

    private static final String STACK_EXCHANGE_API_URL = "https://api.stackexchange.com/2.3/questions?order=desc&sort=activity&site=stackoverflow&tagged=";

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        String tagged = request.getParameter("tagged");
        if (tagged == null || tagged.isEmpty()) {
            response.setStatus(SlingHttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Missing 'tagged' parameter");
            return;
        }

        String apiUrl = STACK_EXCHANGE_API_URL + tagged;
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL(apiUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                response.setStatus(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().write("Failed to get data from Stack Exchange API");
                return;
            }

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder responseBody = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBody.append(line);
            }

            response.setContentType("application/json");
            response.setStatus(SlingHttpServletResponse.SC_OK);
            response.getWriter().write(responseBody.toString());

        } catch (Exception e) {
            response.setStatus(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Error occurred: " + e.getMessage());
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
       }
    }
}