package com.example.demo.endpoint;

import com.example.demo.service.AService;
import com.example.demo.service.BService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncRestController {

    @Autowired
    private AService aService;
    @Autowired
    private BService bService;

    @GetMapping(path = "/a/{count}")
    public ResponseEntity<?> getCritical(@PathVariable(name = "count") int count) {
        for (int i = 0; i < count; i++) {
            aService.printA();
        }
        return ResponseEntity.ok("OK");
    }

    @GetMapping(path = "/b/{count}")
    public ResponseEntity<?> getNonCritical(@PathVariable(name = "count") int count) {
        for (int i = 0; i < count; i++) {
            bService.printB();
        }
        return ResponseEntity.ok("OK");

    }

}
