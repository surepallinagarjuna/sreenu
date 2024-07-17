package com.aem.geeks.core.models;

import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables=Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class two {
    @Inject
    public String mobile;
    @Inject
    public String desktop;
    @Inject
    private List<three> three;
   
    public String getMobile() {
        return mobile;
    }
    public String getDesktop() {
        return desktop;
    }
    public List<three> getThree() {
        return three;
    }
}

