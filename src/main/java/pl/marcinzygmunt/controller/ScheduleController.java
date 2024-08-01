package pl.marcinzygmunt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.marcinzygmunt.controller.model.JobInfo;
import pl.marcinzygmunt.service.ScheduleService;

import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping("/schedule")
    public ResponseEntity<?> schedule(@RequestParam(defaultValue = "5") int offsetSeconds) {
        UUID jobID = scheduleService.scheduleJob(offsetSeconds);
        return ResponseEntity.ok(new JobInfo(jobID));
    }





}
