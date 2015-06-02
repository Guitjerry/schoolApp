package demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by jiangbin on 15/6/2.
 */
@Component
public class TaskJob {
    @Scheduled(cron = "0 14 11 * *")
    public void job1(){
        System.out.println("任务进行中");
    }
}
