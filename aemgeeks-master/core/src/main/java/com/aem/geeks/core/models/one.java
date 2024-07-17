package com.aem.geeks.core.models;



import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class one {

    @Inject
    public String name;
    @Inject
    public String image;
    public String getName() {
        return name;
    }
    public String getImage() {
        return image;
    }
}

