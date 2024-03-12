package com.aem.geeks.core.models;

import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Sidebar2 {

    @Inject
    private String place; 

    @Inject
    private String photo; 

    @ChildResource
    private List<Sidebar3>navi;

    public String getPlace() {
        return place;
    }
    public String getPhoto() {
        return photo;
    }
    public List<Sidebar3> getNavi() {
        return navi;
    }
    
}
