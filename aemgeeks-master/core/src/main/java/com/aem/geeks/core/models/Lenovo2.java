package com.aem.geeks.core.models;

import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(adaptables = Resource.class, defaultInjectionStrategy =  DefaultInjectionStrategy.OPTIONAL)

public class Lenovo2 {


    @Inject
    private String like;

    @Inject
    private String place;

    @ChildResource
    private List<Lenovo3>age;

    public List<Lenovo3> getAge() {
        return age;
    }

    public String getLike() {
        return like;
    }

    public String getPlace() {
        return place;
    }

    
    
    
}
