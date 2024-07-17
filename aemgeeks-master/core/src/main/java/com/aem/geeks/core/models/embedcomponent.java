package com.aem.geeks.core.models;

import javax.annotation.Resource;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class embedcomponent {

    @ValueMapValue
    private String embedurl;

    public String getEmbedurl() {
        return embedurl;
    }



}
