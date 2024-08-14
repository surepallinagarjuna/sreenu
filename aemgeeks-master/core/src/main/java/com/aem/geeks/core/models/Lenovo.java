package com.aem.geeks.core.models;

import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model (adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Lenovo {
    @Inject
    @Default(values = "nagarjuna")
    private String firstname;
    
    @Inject
    @Default(values = "madhava")
    private String lastname;

    @Inject
    private boolean virat;
    
    @Inject
    private String like;

    @Inject
    private String path;
    
    @Inject
    private List<String> nagarjuna;

    @ChildResource
    private List<Lenovo2>lenovo;

    public List<Lenovo2> getLenovo() {
        return lenovo;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public boolean getVirat() {
        return virat;
    }

    public String getLike() {
        return like;
    }

    public String getPath() {
        return path;
    }

    public List<String> getNagarjuna() {
        return nagarjuna;
    }

  
}
