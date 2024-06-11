package com.aem.geeks.core.services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate =true)
public class ArticleService {

    private static final Logger LOG = LoggerFactory.getLogger(ArticleService.class);

    @Activate
    public void activate(){
        LOG.info("ArticleService - I am busy");

    }

    @Deactivate
    public void Deactivate(){
        LOG.info(" ArticleService - I am notbusy");

    }

    @Modified
    public void Modified(){
        LOG.info("ArticleService - i am alredy told na");

    }
    
}
