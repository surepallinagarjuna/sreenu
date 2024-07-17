package com.aem.geeks.core.models;


import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(adaptables = Resource.class, resourceType = "/apps/aemgeeks/components/content/carousellll", defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class CarouselMultifieldModel {

    @ChildResource
    private List<CarouselModel> carousel;

    public List<CarouselModel> getCarousel() {
        return carousel;
    }

   
}
