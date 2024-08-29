package com.aem.geeks.core.models;

import javax.inject.Inject;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Practice1 {

     @Inject
    private String place; 
    @Inject
    private String photo; 
   
    public String getPlace() {
        return place;
    }

    public String getPhoto() {
        return photo;
    }

   

   

}
