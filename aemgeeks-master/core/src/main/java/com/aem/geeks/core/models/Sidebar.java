package com.aem.geeks.core.models;



import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;


@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Sidebar {
    @Inject
    private String path;
    @Inject
    private String imageRef;
    @Inject
    private String link;
    @Inject
    private String button; 
    @Inject
    private String country;
    @ChildResource
    private List<one> one;
    public List<one> getOne() {
        return one;
    }
    @ChildResource
    private List<two> two;

    public List<two> getTwo() {
        return two;
    }
    public String getPath() {
        return path;
    }
    public String getImageRef() {
        return imageRef;
    }
    public String getLink() {
        return link;
    }
    public String getButton() {
        return button;
    }
    public String getCountry() {
        return country;
    }
}
