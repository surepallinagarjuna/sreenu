package com.aem.geeks.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = "/apps/aemgeeks/components/content/carousellll")
public class CarouselNestedMultModel {

    @Inject
    private String place;

    public String getPlace() {
        return place;
    }

}
