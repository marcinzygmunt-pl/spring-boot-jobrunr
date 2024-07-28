package pl.marcinzygmunt.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jobrunr.scheduling.JobScheduler;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EnqueueService {
    private int counter = 0;

    private final JobScheduler jobScheduler;

    public void enqueueJob() {
        counter++;
        jobScheduler.<SampleService>enqueue(
                sampleService -> sampleService.sampleEnqueueJob(String.format("Enqueued from controller, no: %s",counter), 5));
        log.info("Enqueued JOB with no: {}",counter);
    }
}
