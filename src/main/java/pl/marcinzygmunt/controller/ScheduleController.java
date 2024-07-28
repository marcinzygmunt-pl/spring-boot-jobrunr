package pl.marcinzygmunt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.marcinzygmunt.service.ScheduleService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping("/schedule")
    public ResponseEntity<?> schedule(@RequestParam(defaultValue = "5") int offsetSeconds) {
        scheduleService.scheduleJob(offsetSeconds);
        return ResponseEntity.ok().build();
    }


}
