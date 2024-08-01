package pl.marcinzygmunt.controller;

import lombok.RequiredArgsConstructor;
import org.jobrunr.storage.ConcurrentJobModificationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.marcinzygmunt.service.DeleteJobService;

import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DeleteJobController {
    private final DeleteJobService deleteJobService;
    @DeleteMapping("/delete/{jobID}")
    public ResponseEntity<?> delete(@PathVariable UUID jobID) {
        try {
            deleteJobService.deleteJob(jobID);
            return ResponseEntity.ok(jobID);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
