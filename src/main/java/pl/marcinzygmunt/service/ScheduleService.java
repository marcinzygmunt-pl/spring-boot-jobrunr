package pl.marcinzygmunt.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jobrunr.scheduling.JobScheduler;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScheduleService {

    private int counter = 0;
    private final JobScheduler jobScheduler;

    public void scheduleJob(int offsetSeconds) {
        counter++;
        jobScheduler.<SampleService>schedule(
                UUID.randomUUID(),
                Instant.now().plus(Duration.ofSeconds(offsetSeconds)),
                sampleService -> sampleService.sampleScheduledJob(String.format("Static, no: %s",counter), 5));
        log.info("Schedule JOB with no: {}",counter);
    }
}

