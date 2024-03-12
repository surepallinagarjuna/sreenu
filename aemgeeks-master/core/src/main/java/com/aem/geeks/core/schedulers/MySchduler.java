package com.aem.geeks.core.schedulers;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.geeks.core.config.Config;
import com.aem.geeks.core.services.Osg;
import com.day.cq.wcm.api.Page;


@Component(service =MySchduler.class, immediate = true )
@Designate(ocd = Config.class)
public class MySchduler  implements Runnable{

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Reference
    private Scheduler scheduler;

    @Reference
    Osg service;

    @Activate
    protected void activate( Config config){
        
        logger.info("Config activate method called");
        //Execute this method to add scheduler
        addScheduler(config);
    }
    //Add all configurations to schedule a scheduler depending on name and expression
    private void addScheduler(Config config) {
        logger.info("Scheduler added successfully");

        if (config.Enable_Scheduler()) {

            final ScheduleOptions options=scheduler.EXPR(config.Scheduler_Experssion());
            options.name(config.Scheduler_name());
            options.canRunConcurrently(config.concurrent_scheduler());

            //Add scheduler to call depending on option passed
            scheduler.schedule(this, options);
            logger.info("Scheduler added successfully name'{}'", config.Scheduler_name());
            
        } else {
            logger.info("Config desabled");
            
        }
    }

    public void removeScheduler(Config config){
        scheduler.unschedule(config.Scheduler_name());
    }

    //on deactivate componet it will unschedule scheduler
    @Deactivate
    protected void deactivate(Config config){
        removeScheduler(config);

    }
    //run() method will get call every minute
    @Override
    public void run() {
        logger.info("Config run method started");

        List<String> listpages = new ArrayList<>();

        try {
            Iterator<Page> pages = service.getpages();
        while (pages.hasNext()) {
            listpages.add(pages.next().getTitle());
            listpages.add(pages.next().getPath());           
        }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        logger.info("Config run method complete'{}'", listpages.toString());
    }
    
}
