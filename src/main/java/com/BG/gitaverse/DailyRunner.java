package com.BG.gitaverse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DailyRunner implements CommandLineRunner {

    private final DailyEmailScheduler scheduler;

    public DailyRunner(DailyEmailScheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void run(String... args) {
        try {
            System.out.println("Running Daily Email Job...");
            scheduler.sendDailyEmail();
            System.out.println("Job Completed Successfully.");
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
