package com.aem.geeks.core.models;

import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(adaptables = Resource.class, resourceType = "/apps/aemgeeks/components/content/carousellll", defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CarouselModel {

    @Inject
    private String name;

    @Inject
    private String profile;

    @ChildResource
    private List<CarouselNestedMultModel> nestedmultifield;

    public String getName() {
        return name;
    }

    public String getProfile() {
        return profile;
    }

    public List<CarouselNestedMultModel> getNestedmultifield() {
        return nestedmultifield;
    }

}
