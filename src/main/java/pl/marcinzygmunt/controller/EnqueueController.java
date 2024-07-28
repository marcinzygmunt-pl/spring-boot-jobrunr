package pl.marcinzygmunt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.marcinzygmunt.service.EnqueueService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EnqueueController {

    private final EnqueueService enqueueService;

    @GetMapping("/enqueue")
    public ResponseEntity<?> enqueue() {
        enqueueService.enqueueJob();
        return ResponseEntity.ok().build();
    }

}
