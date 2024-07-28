package pl.marcinzygmunt;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jobrunr.scheduling.BackgroundJob;
import org.jobrunr.scheduling.JobScheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pl.marcinzygmunt.service.SampleService;

@Component
@RequiredArgsConstructor
@Slf4j
public class EnqueueJobs {

    private final JobScheduler jobScheduler;

    @Bean
    void batchEnqueueJob() {
        BackgroundJob.<SampleService>enqueue(sampleService -> sampleService.sampleEnqueueJob("Static", 5));
    }

    @Bean
    public void anotherEnqueueJob() {
        jobScheduler.<SampleService>enqueue(
                sampleService -> sampleService.sampleEnqueueJob("Normal", 5));
    }


}
