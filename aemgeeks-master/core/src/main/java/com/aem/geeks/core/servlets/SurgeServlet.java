// package com.aem.geeks.core.servlets;

// import java.io.IOException;

// import javax.lang.model.util.Elements;
// import javax.servlet.Servlet;

// import org.apache.http.client.methods.CloseableHttpResponse;
// import org.apache.http.client.methods.HttpGet;
// import org.apache.http.impl.client.CloseableHttpClient;
// import org.apache.http.impl.client.HttpClients;
// import org.apache.http.util.EntityUtils;
// import org.apache.sling.api.SlingHttpServletRequest;
// import org.apache.sling.api.SlingHttpServletResponse;
// import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
// import org.apache.sling.servlets.annotations.SlingServletPaths;
// import org.osgi.service.component.annotations.Component;
// import org.jsoup.Jsoup;
// import org.jsoup.nodes.Document;
// import org.jsoup.select.Elements;


// @Component(service = Servlet.class)
// @SlingServletPaths(value = {"/bin/surge"})
// public class SurgeServlet extends SlingSafeMethodsServlet{
//               protected void doGet(SlingHttpServletRequest req, SlingHttpServletResponse res) throws IOException {

//                 CloseableHttpClient httpClient = HttpClients.createDefault();
//         HttpGet httpGet = new HttpGet("https://surgesoftware.co.in/");
//         CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

//         try {
//             int statusCode = httpResponse.getStatusLine().getStatusCode();
//             if (statusCode == 200) {
//                 String responseBody = EntityUtils.toString(httpResponse.getEntity());
// // 
//                 // Use JSoup to parse the HTML
//                 Document document = Jsoup.parse(responseBody);

//                 // Select the footer element(s)
//                 Elements footerElements = document.select("footer");

//                 // Write the footer content to the response
//                 if (!footerElements.isEmpty()) {
//                     res.getWriter().write(footerElements.html());
//                 } else {
//                     res.getWriter().write("Footer not found in the page.");
//                 }
//             } else {
//                 res.getWriter().write("Failed to retrieve page: " + statusCode);
//             }
//         } finally {
//             httpResponse.close();
//             httpClient.close();
//         }

                
//         }
        
         
//     }


    
    
