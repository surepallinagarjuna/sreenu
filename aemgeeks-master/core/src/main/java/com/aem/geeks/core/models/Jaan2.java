package com.aem.geeks.core.models;


import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class, defaultInjectionStrategy =  DefaultInjectionStrategy.OPTIONAL)


public class Jaan2 {

    @Inject
    private String max;

    public String getMax() {
        return max;
    }

}
