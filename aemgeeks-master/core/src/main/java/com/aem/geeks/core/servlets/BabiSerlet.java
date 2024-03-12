// package com.aem.geeks.core.servlets;



// import javax.servlet.Servlet;

// // import javax.servlet.Servlet;

// // import org.apache.sling.api.SlingHttpServletRequest;
// // import org.apache.sling.api.SlingHttpServletResponse;
// // import org.apache.sling.api.resource.Resource;
// // import org.apache.sling.api.servlets.HttpConstants;
// // import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
// // import org.osgi.service.component.annotations.Component;
// // import org.slf4j.Logger;
// // import org.slf4j.LoggerFactory;
// // @Component(service = Servlet.class,
// //  property = {
// //                 "sling.servlet.methods=" + HttpConstants.METHOD_GET,
// //                 "sling.servlet.resourceTypes=" + "aemgeeks/components/content/multifiled",
// //                 "sling.servlet.selectors=jun",
// //                 "sling.servlet.extensions=recent"
// //         })
// // public class BabiSerlet extends SlingSafeMethodsServlet{
// //       Logger LOG = LoggerFactory.getLogger(BabiSerlet.class);

// //       protected void doGet(SlingHttpServletRequest req, SlingHttpServletResponse res){
// //             Resource resource = req.getResource();

// //             try {
// //             // Your servlet code here
// //             LOG.info("Servlet doGet method called");
// //         } catch (Exception e) {
// //             LOG.error("An error occurred in the servlet", e);
// //         }
// //       }

// // }



// import javax.servlet.ServletContext;
// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import org.osgi.service.component.annotations.Component;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

// import java.io.IOException;

//  @Component(service = Servlet.class,
//  property = {
//             "sling.servlet.methods=" + HttpConstants.METHOD_GET,
//             "sling.servlet.resourceTypes=" + "aemgeeks/components/content/multifiled",
//             "sling.servlet.selectors=jun",
//             "sling.servlet.extensions=recent"
//    })


// public class BabiSerlet extends HttpServlet {

//     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//             Logger LOG = LoggerFactory.getLogger(BabiSerlet.class);

//         try {
//             // Your code to add a component to the page

//             // For example:
//             // SomeComponent component = new SomeComponent();
//             // page.addComponent(component);

//             // Log a message indicating successful addition
//             logMessage("Component added successfully.");

//         } catch (Exception e) {
//             // Log the error message
//             logError("Error adding component to the page", e);

//             // Handle the exception as needed
//             // For example, you might want to send an error response to the client
//             response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error adding component to the page");
//         }
//     }

//     private void logMessage(String message) {
//         ServletContext context = getServletContext();
//         context.log(message);
//     }

//     private void logError(String message, Throwable throwable) {
//         ServletContext context = getServletContext();
//         context.log(message, throwable);
//     }

   
// }



    
