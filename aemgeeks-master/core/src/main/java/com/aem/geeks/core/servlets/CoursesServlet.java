package com.aem.geeks.core.servlets;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Component(service = { Servlet.class })
@SlingServletPaths("/bin/myapi/courses")
public class CoursesServlet extends SlingAllMethodsServlet {

    private static final long serialVersionUID = 1L;
    private static final String THIRD_PARTY_API_URL = "https://api.thirdparty.com/courses";

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        JsonObject coursesObject = fetchCoursesFromThirdPartyApi();
        response.getWriter().write(coursesObject.toString());
    }

    private JsonObject fetchCoursesFromThirdPartyApi() {
        JsonObject coursesObject = new JsonObject();
        JsonObject javaCourses = new JsonObject();
        JsonObject aemCourses = new JsonObject();

        try {
            URL url = new URL(THIRD_PARTY_API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            InputStreamReader reader = new InputStreamReader(conn.getInputStream());
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(reader);
            if (element.isJsonArray()) {
                JsonArray array = element.getAsJsonArray();
                for (JsonElement courseElement : array) {
                    JsonObject courseObject = courseElement.getAsJsonObject();
                    String category = courseObject.get("category").getAsString().toLowerCase();
                    JsonObject courseData = new JsonObject();
                    courseData.addProperty("title", courseObject.get("title").getAsString());
                    courseData.addProperty("image", courseObject.get("image").getAsString());
                    courseData.addProperty("description", courseObject.get("description").getAsString());

                    if (category.equals("java")) {
                        javaCourses.add(courseObject.get("title").getAsString(), courseData);
                    } else if (category.equals("aem")) {
                        aemCourses.add(courseObject.get("title").getAsString(), courseData);
                    }
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        coursesObject.add("java", javaCourses);
        coursesObject.add("aem", aemCourses);

        return coursesObject;
}
}