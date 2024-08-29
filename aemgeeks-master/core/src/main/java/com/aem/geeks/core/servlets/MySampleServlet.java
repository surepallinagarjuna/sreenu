package com.aem.geeks.core.servlets;

import com.aem.geeks.core.models.Chamu;
import com.google.gson.JsonObject;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.osgi.service.component.propertytypes.ServiceVendor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(
    service = { Servlet.class },
    property = {
        "sling.servlet.methods=GET",
        "sling.servlet.paths=/bin/servlet"
    }
)
@ServiceDescription("Simple Servlet using Sling Model")
@ServiceVendor("Your Company Name")
public class MySampleServlet extends SlingAllMethodsServlet {

    private static final Logger LOG = LoggerFactory.getLogger(MySampleServlet.class);

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        // Set the content type of the response
        response.setContentType("application/json");

        // Directly adapt the SlingHttpServletRequest to the Chamu model
        Chamu chamuModel = request.adaptTo(Chamu.class);

        if (chamuModel != null) {
            // Create a JSON object using GSON and populate it with data from the Chamu model
            JsonObject jsonResponse = new JsonObject();
            jsonResponse.addProperty("my", chamuModel.getMy());
            jsonResponse.addProperty("phone", chamuModel.getPhone());
            jsonResponse.addProperty("date", chamuModel.getDate());
            jsonResponse.addProperty("youtube", chamuModel.getYoutube());
            jsonResponse.addProperty("pen", chamuModel.getPen());
            jsonResponse.addProperty("red", chamuModel.getRed());

            // Write the JSON response
            response.getWriter().write(jsonResponse.toString());

            LOG.info("Servlet responded with a JSON message containing Chamu model data.");
        } else {
            // Handle the case where the model could not be adapted
            LOG.error("Could not adapt request to Chamu model");
            response.sendError(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Could not adapt request to Chamu model");
        }
    }
}
