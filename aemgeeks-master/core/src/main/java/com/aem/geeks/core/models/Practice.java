package com.aem.geeks.core.models;

import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;


@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Practice {
    @Inject
    private String logo;
    @Inject
    private String mobile;
    @Inject
    private String pic;
    @Inject
    private String king;

    @ChildResource
    private List<Practice1>mrs;
    public String getLogo() {
        return logo;
    }
    public List<Practice1> getMrs() {
        return mrs;
    }
    public String getMobile() {
        return mobile;
    }
    public String getPic() {
        return pic;
    }
    public String getKing() {
        return king;
    } 
}
