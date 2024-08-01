package pl.marcinzygmunt.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jobrunr.scheduling.BackgroundJob;
import org.springframework.stereotype.Service;
import pl.marcinzygmunt.BatchJobs;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeleteJobService {

    public void deleteJob(UUID jobID) {
        BackgroundJob.delete(jobID);
        log.info("Delete schedule JOB with id: {}",jobID);
    }

}
