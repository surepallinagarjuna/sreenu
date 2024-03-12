package com.aem.geeks.core.models;

import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(adaptables = {Resource.class,SlingHttpServletRequest.class},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Sidebar {
    @Inject
    private String logo;

    @Inject
    private String logomobile;

    @Inject
    private String pic;

    @Inject
    private String king;

    @ChildResource
    private List<Sidebar2>mrs;

     public String getLogo() {
        return logo;
    }

    public String getLogomobile() {
        return logomobile;
    }

    public String getPic() {
        return pic;
    }

    public String getKing() {
        return king;
    }

    public List<Sidebar2> getMrs() {
        return mrs;
    }

   
    
}
