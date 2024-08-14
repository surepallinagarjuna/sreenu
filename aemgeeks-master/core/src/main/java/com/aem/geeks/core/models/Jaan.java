package com.aem.geeks.core.models;


import java.util.List;
    
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;


@Model (adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Jaan {
    @Inject
    @Default(values = "nagarjuna")
    private String pathfield;
    
    public String getPathfield() {
        return pathfield;
    }
    public List<Jaan1> getMultifield() {
        return multifield;
    }
    @ChildResource
    private List<Jaan1>multifield;
}
