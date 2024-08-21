package com.aem.geeks.core.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Model(adaptables = Resource.class)
public class CourseDetailsModel {

    @Self
    private Resource resource;

    @SlingObject
    private ResourceResolver resourceResolver;

    private List<Map<String, String>> courses;

    @PostConstruct
    protected void init() {
        Resource jsonResource = resourceResolver.getResource("/content/dam/aemgeeks/course-details.json/jcr:content/renditions/original");
        if (jsonResource != null) {
            InputStream jsonInputStream = jsonResource.adaptTo(InputStream.class);
            if (jsonInputStream != null) {
                ObjectMapper mapper = new ObjectMapper();
                try {
                    Map<String, List<Map<String, String>>> data = mapper.readValue(jsonInputStream, Map.class);
                    this.courses = data.get("courses");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Map<String, String>> getCourses() {
        return courses;
 }
}


