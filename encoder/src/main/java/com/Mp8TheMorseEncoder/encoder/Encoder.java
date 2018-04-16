package com.Mp8TheMorseEncoder.encoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class Encoder {


    @Value("#{'${letters}'.split('')}")
    private List<String> letters;

    @GetMapping("/encoder")
    public String getletter() {
        System.out.println(letters);
        String collect = letters.stream()
                .map(charc -> tomorse(charc))
                .collect(Collectors.joining(""));
        System.out.printf(collect);
        return  collect;
    }

    private String tomorse(String charc) {
        RestTemplate restTemplate1 = new RestTemplate();
        restTemplate1.postForEntity("http://localhost:9007/morse", charc, String.class);
        ResponseEntity<String> forEntity = restTemplate1.getForEntity("http://localhost:9007/morse", String.class);
        return  forEntity.getBody();

    }



}
