package br.com.felipesilva.prometheus.controllers;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/hello")
@RestController
public class HelloWorldController {

    private final MeterRegistry meterRegistry;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public String helloWorld() {
        meterRegistry.counter("hello_world").increment();
        return "Hello World!";
    }
}
