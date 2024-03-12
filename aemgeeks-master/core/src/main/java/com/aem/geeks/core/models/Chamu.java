package com.aem.geeks.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;

@Model (adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Chamu {


    @Inject
    @Default(values="chamu Reddy")
    private String my;

    @Inject
    @Required
    private String phone;

    @Inject
    private String date;

    @Inject
    @Default(values={"chamu Reddy","naid"})
    private String youtube;

    @Inject
    private String pen;

    public String getMy() {
        return my;
    }

    public String getPhone() {
        return phone;
    }

    public String getDate() {
        return date;
    }

    public String getYoutube() {
        return youtube;
    }

    public String getPen() {
        return pen;
    }

    public String getRed() {
        return red;
    }

    @Inject
    private String red;

    
}
