package com.aem.geeks.core.models;

import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Sidebar3 {
    @Inject
    private String icon; 
    @Inject
    private String mobile;

    @ChildResource
    private List<Sidebar4>year;

    public String getIcon() {
        return icon;
    }
    public String getMobile() {
        return mobile;
    }
    public List<Sidebar4> getYear() {
        return year;
    } 
   
    
}
