package net.san.timer;

import net.san.entity.Exchange;
import net.san.service.TrackerService;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by aragaki on 1/13/2018.
 */
public class Worker {

    public void start(Map<String, List<Exchange>> exchanges) {
        try {
            JobDetail job = JobBuilder.newJob(TrackerService.class).withIdentity("trackerJob", "trackerGroup").build();

            Trigger trigger = TriggerBuilder
                    .newTrigger()
                    .withIdentity("trackerJob", "trackerGroup")
                    .startNow()
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0/5 * * * ?"))
                    .build();

            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.getContext().put("exchanges", exchanges);
            scheduler.start();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
