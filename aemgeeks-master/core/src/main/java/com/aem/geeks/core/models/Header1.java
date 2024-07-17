package com.aem.geeks.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.Calendar;

@Model(adaptables = Resource.class)
public class Header1 {

    @ValueMapValue
    private String name;

    @ValueMapValue
    private Calendar date;

    public String getText() {
        return name;
    }

    public Calendar getDate() {
        return date;
    }
}
