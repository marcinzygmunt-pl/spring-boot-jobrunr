package pl.marcinzygmunt.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jobrunr.scheduling.JobScheduler;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class EnqueueService {
    private int counter = 0;

    private final JobScheduler jobScheduler;

    public UUID enqueueJob() {
        counter++;
        UUID jobID = UUID.randomUUID();
        jobScheduler.<SampleService>enqueue(jobID,
                sampleService -> sampleService.sampleEnqueueJob(String.format("Enqueued from controller, no: %s",counter), 5));
        log.info("Enqueued JOB with no: {}",counter);
        return jobID;
    }
}
