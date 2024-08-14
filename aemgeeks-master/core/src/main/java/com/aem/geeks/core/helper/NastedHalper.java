package com.aem.geeks.core.helper;

import org.apache.sling.api.resource.Resource;

import java.util.Date;

public class NastedHalper {
    private int bookEditon;
    private Date editonDate;
    private String iplTeam;
    public NastedHalper(Resource resource){
        if(resource.getValueMap().get("bookediton", Integer.class)!=null) {
            this.bookEditon = resource.getValueMap().get("bookediton", Integer.class);
        }
        if(resource.getValueMap().get("editondate",Date.class)!=null){
            this.editonDate=resource.getValueMap().get("editondate",Date.class);
        }
        if(resource.getValueMap().get("iplteam",String.class)!=null){
            this.iplTeam=resource.getValueMap().get("iplteam",String.class);
        }

    }

    public int getBookEditon() {
        return bookEditon;
    }

    public Date getEditonDate() {
        return editonDate;
    }

    public String getIplTeam() {
        return iplTeam;
    }

   
}