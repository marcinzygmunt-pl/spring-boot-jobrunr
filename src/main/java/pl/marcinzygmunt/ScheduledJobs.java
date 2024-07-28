package pl.marcinzygmunt;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jobrunr.scheduling.BackgroundJob;
import org.jobrunr.scheduling.JobScheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pl.marcinzygmunt.service.SampleService;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class ScheduledJobs {

    private final JobScheduler jobScheduler;

    @Bean
    void scheduledJob() {
        BackgroundJob.<SampleService>schedule(
                UUID.randomUUID(),
                Instant.now().plus(Duration.ofSeconds(30)),
                sampleService -> sampleService.sampleBackgroundJob("Static"));
    }

    @Bean
    public void anotherScheduledJob() {
        jobScheduler.<SampleService>schedule(
                UUID.randomUUID(),
                Instant.now().plus(Duration.ofSeconds(30)),
                sampleService -> sampleService.sampleBackgroundJob("Static"));
    }


}
