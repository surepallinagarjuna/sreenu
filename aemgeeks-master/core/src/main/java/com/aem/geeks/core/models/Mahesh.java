package com.aem.geeks.core.models;

import java.util.List;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model (adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Mahesh {


    @ValueMapValue
    private List<String> multifield;

    public List<String> getMultifield() {
        return multifield;
    }

    public List<String> getFooter() {
        return footer;
    }

    @ValueMapValue
    private List<String> footer;

    

    
}
