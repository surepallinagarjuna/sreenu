package com.aem.geeks.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name ="Config Schduler",
       description = "Config OCD description")

public @interface Config {

    @AttributeDefinition(
          name = "Scheduler name",
          description = "Scheduler name",
          type = AttributeType.STRING)
          String  Scheduler_name() default "Nagarjuna";

     @AttributeDefinition(
          name ="Install time",
          description = "Scheduler runningtime",
          type = AttributeType.INTEGER)
          int  Scheduler_runningtime() default 11;

          

    @AttributeDefinition(
        name = "Cron Job Experssion",
        description = "Cron Job Scheduler",
        type = AttributeType.STRING)
         String  Scheduler_Experssion() default "*/3 * * * * *";

    @AttributeDefinition(
          name = "Enable Scheduler",
          description = "Enable Scheduler",
          type = AttributeType.BOOLEAN)
          boolean  Enable_Scheduler() default true;


    @AttributeDefinition(
          name = "Concurrent Scheduler",
          description = "Concurrent Scheduler",
          type = AttributeType.BOOLEAN)
          boolean concurrent_scheduler() default true;
    
}
