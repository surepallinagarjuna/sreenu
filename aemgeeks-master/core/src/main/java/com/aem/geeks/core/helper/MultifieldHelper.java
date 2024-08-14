package com.aem.geeks.core.helper;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

public class MultifieldHelper {
    private static final Logger LOG = LoggerFactory.getLogger(MultifieldHelper.class);
    private String bookName;
    private String bookSubject;
    private Date publishDate;
    private int copies;
    private List<NastedHalper> bookEditons;
    private List<NastedHalper> teamsHePlayed;
    private String cricketerName;
    private String profilePage;
    public MultifieldHelper(Resource resource){
        try {
            if(StringUtils.isNotBlank(resource.getValueMap().get("bookname", String.class))) {
                this.bookName = resource.getValueMap().get("bookname", String.class);
            }
            if(StringUtils.isNotBlank(resource.getValueMap().get("booksubject", String.class))) {
                this.bookSubject=resource.getValueMap().get("booksubject",String.class);
            }
            if(resource.getValueMap().get("publishdate",Date.class)!=null) {
                this.publishDate=resource.getValueMap().get("publishdate",Date.class);
            }
            if(resource.getValueMap().get("copies",Integer.class)!=null) {
                this.copies=resource.getValueMap().get("copies",Integer.class);
            }
            if(StringUtils.isNotBlank(resource.getValueMap().get("cricketername", String.class))) {
                this.cricketerName = resource.getValueMap().get("cricketername", String.class);
            }
            if(StringUtils.isNotBlank(resource.getValueMap().get("profilepage", String.class))) {
                this.profilePage = resource.getValueMap().get("profilepage", String.class);
            }

        }catch (Exception e){
            LOG.info("\n BEAN ERROR : {}",e.getMessage());
        }

    }

    public String getBookName() {
        return bookName;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public int getCopies() {
        return copies;
    }

    public String getBookSubject() {
        return bookSubject;
    }

    public List<NastedHalper> getBookEditons() {
        return bookEditons;
    }

    public void setBookEditons(List<NastedHalper> bookEditons) {
        this.bookEditons = bookEditons;
    }

    public List<NastedHalper> getTeamsHePlayed() {
        return teamsHePlayed;
    }

    public void setTeamsHePlayed(List<NastedHalper> teamsHePlayed) {
        this.teamsHePlayed = teamsHePlayed;
    }

    public String getCricketerName(){
        return cricketerName;
    }

    public String getProfilePage() {
        return profilePage;
    }

   
}
