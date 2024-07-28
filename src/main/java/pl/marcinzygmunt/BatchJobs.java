package pl.marcinzygmunt;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jobrunr.jobs.annotations.Job;
import org.jobrunr.scheduling.BackgroundJob;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.spring.annotations.Recurring;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pl.marcinzygmunt.service.SampleService;

import java.time.Duration;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class BatchJobs {

    private final JobScheduler jobScheduler;
    private final SampleService sampleService;

    @Bean
    void batchRecurringJob() {
        BackgroundJob.<SampleService>scheduleRecurrently(
                UUID.randomUUID().toString(),
                Duration.ofSeconds(30),
                sampleService -> sampleService.sampleBackgroundJob("Static"));
    }

    @Bean
    public void anotherJob() {
        jobScheduler.<SampleService>scheduleRecurrently(
                UUID.randomUUID().toString(),
                Duration.ofSeconds(30),
                sampleService -> sampleService.sampleBackgroundJob("Normal"));
    }

    @Recurring(id = "my-recurring-job", cron = "*/30 * * * * *")
    @Job(name = "My recurring job")
    public void executeSampleJob() {
        sampleService.sampleBackgroundJob("Annotation");
    }


}
