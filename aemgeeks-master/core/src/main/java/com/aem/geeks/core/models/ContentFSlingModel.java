package com.aem.geeks.core.models;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.dam.cfm.ContentElement;
import com.adobe.cq.dam.cfm.ContentFragment;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ContentFSlingModel {

    private static final Logger logger = LoggerFactory.getLogger(ContentFSlingModel.class);

    @Self
    private Resource resource;

    @SlingObject
    private ResourceResolver resourceResolver;

    private String cfPath;
    private Optional<ContentFragment> contentFragment;

    private String 	name;
    private String addrees;
    // private String authors;
    // private String body;
    // private String byline;
    // private String canonicalurl;
    // private String donotincludelnleftrail;
    // private String featuredimagealttext;
    // private String featuredimagecaption;
    // private String featuredimagecredit;
    // private String gatingcharacterlimit;
    // private String headline;
    // private String nativeadvertisingmarketing;
    // private String noindex;
    // private String podcastid;
    // private String pressrelease;
    // private String primarycategory;
    // private String promoteingooglenews;
    // private String promoteinrss;
    // private String promoteinsitelist;
    // private String publisheddate;
    // private String relatedcontent;
    // private String relatedevents;
    // private String relatedinlinecontent;
    // private String secondarycategory;
    // private String seometadescription;
    // private String seotitle;
    // private String sponsorname;
    // private String summary;
    // private String syndicate;
    // private String tags;
    // private String uniqueid;
    // private String url;

    @PostConstruct
    public void init() {
        cfPath = "/content/dam/projects/hgcv/englishcf";
        Resource fragmentResource = resourceResolver.getResource(cfPath);
        contentFragment = Optional.ofNullable(fragmentResource.adaptTo(ContentFragment.class));

        if (contentFragment.isPresent()) {
            ContentFragment cf = contentFragment.get();
            	
            name = getElementContent("articletype");
            addrees = getElementContent("uraudioattachment");
            // authors = getElementContent("authors");
            // byline = getElementContent("byline");
            // gatingcharacterlimit = getElementContent("gatingcharacterlimit");
            // secondarycategory = getElementContent("secondarycategory");
            // tags = getElementContent("tags");

            // body = getElementContent("body");
            // canonicalurl = getElementContent("canonicalurl");
            // donotincludelnleftrail = getElementContent("donotincludelnleftrail");
            // featuredimagealttext = getElementContent("featuredimagealttext");
            // featuredimagecaption = getElementContent("featuredimagecaption");
            // featuredimagecredit = getElementContent("featuredimagecredit");
            // headline = getElementContent("headline");
            // nativeadvertisingmarketing = getElementContent("nativeadvertisingmarketing");
            // noindex = getElementContent("noindex");
            // podcastid = getElementContent("podcastid");
            // pressrelease = getElementContent("pressrelease");
            // primarycategory = getElementContent("primarycategory");
            // promoteingooglenews = getElementContent("promoteingooglenews");
            // promoteinrss = getElementContent("promoteinrss");
            // promoteinsitelist = getElementContent("promoteinsitelist");
            // publisheddate = getElementContent("publisheddate");
            // relatedcontent = getElementContent("relatedcontent");
            // relatedevents = getElementContent("relatedevents");
            // relatedinlinecontent = getElementContent("relatedinlinecontent");
            // seometadescription = getElementContent("seometadescription");
            // seotitle = getElementContent("seotitle");
            // sponsorname = getElementContent("sponsorname");
            // summary = getElementContent("summary");
            // syndicate = getElementContent("syndicate");
            // uniqueid = getElementContent("uniqueid");
            // url = getElementContent("url");
        } else {
            logger.warn("Content Fragment not found at path: {}", cfPath);
        }
    }

    private String getElementContent(String elementName) {
        return contentFragment.map(cf -> cf.getElement(elementName))
                .map(ContentElement::getContent)
                .orElse(StringUtils.EMPTY);
    }

//    public String getPublishedDateFormat() {
//        return contentFragment.map(cf -> cf.getElement("publisheddate").getValue().getValue())
//                .map(FragmentData::getValue)
//                .map(this::parseDate)
//                .orElse(StringUtils.EMPTY);
//    }

    private String parseDate(Object date) {
        if (date instanceof Calendar) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, YYYY");
            return dateFormat.format(((Calendar) date).getTime());
        }
        return StringUtils.EMPTY;
    }

    // Getter methods for ArticleAudioType variables

    public String getCfPath() {
        return cfPath;
    }

    public String getArticletype() {
        return name;
    }

    public String getUraudioattachment() {
        return addrees;
    }

    // public String getAuthors() {
    //     return authors;
    // }

    // public String getByline() {
    //     return byline;
    // }

    // public String getGatingcharacterlimit() {
    //     return gatingcharacterlimit;
    // }

    // public String getSecondarycategory() {
    //     return secondarycategory;
    // }

    // public String getTags() {
    //     return tags;
    // }

    // public String getBody() {
    //     return body;
    // }

    // public String getCanonicalurl() {
    //     return canonicalurl;
    // }

    // public String getDonotincludelnleftrail() {
    //     return donotincludelnleftrail;
    // }

    // public String getFeaturedimagealttext() {
    //     return featuredimagealttext;
    // }

    // public String getFeaturedimagecaption() {
    //     return featuredimagecaption;
    // }

    // public String getFeaturedimagecredit() {
    //     return featuredimagecredit;
    // }

    // public String getHeadline() {
    //     return headline;
    // }

    // public String getNativeadvertisingmarketing() {
    //     return nativeadvertisingmarketing;
    // }

    // public String getNoindex() {
    //     return noindex;
    // }

    // public String getPodcastid() {
    //     return podcastid;
    // }

    // public String getPressrelease() {
    //     return pressrelease;
    // }

    // public String getPrimarycategory() {
    //     return primarycategory;
    // }

    // public String getPromoteingooglenews() {
    //     return promoteingooglenews;
    // }

    // public String getPromoteinrss() {
    //     return promoteinrss;
    // }

    // public String getPromoteinsitelist() {
    //     return promoteinsitelist;
    // }

    // public String getPublisheddate() {
    //     return publisheddate;
    // }

    // public String getRelatedcontent() {
    //     return relatedcontent;
    // }

//     public String getRelatedevents() {
//         return relatedevents;
//     }

}
