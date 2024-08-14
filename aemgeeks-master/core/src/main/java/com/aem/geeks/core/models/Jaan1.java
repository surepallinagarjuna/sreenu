package com.aem.geeks.core.models;

import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(adaptables = Resource.class, defaultInjectionStrategy =  DefaultInjectionStrategy.OPTIONAL)


public class Jaan1 {

    @Inject
    private String sun;

    @Inject
    private String location;

    
    @ChildResource
    private List<Jaan2>code;


    public String getSun() {
        return sun;
    }


    public String getLocation() {
        return location;
    }


    public List<Jaan2> getCode() {
        return code;
    }

}