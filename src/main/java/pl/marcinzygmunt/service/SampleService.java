package pl.marcinzygmunt.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Slf4j
@Service
public class SampleService {

    public void sampleBackgroundJob(String sampleString){
        log.info("Sample BACKGROUND JOB: {}",sampleString);
    }


    public void sampleEnqueueJob(String sampleString, int seconds){
        log.info("Sample ENQUEUED JOB: {} with delay of {}",sampleString, seconds);
        try {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void sampleScheduledJob(String sampleString, int seconds) {
        log.info("Sample SCHEDULED JOB: {} with delay of {}",sampleString, seconds);
        try {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
