package com.Mp8TheMorseEncoder.morse;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RestController
public class MorseEndpoint {


    private String receiverPort;
    private HashMap<String, String> hashMap;

    private String afterhash;

    public MorseEndpoint() {
        hashMap = new HashMap();

        List<String> letters = Stream.of("a b c d e f g h i j k l m n o p q r s t u v w x y z".split(" "))
                .collect(Collectors.toList());

        List<String> morse = Stream.of(".- / -... / -.-. / -.. / . / ..-. / --. / .... / .. / .--- / -.- / .-.. / -- / -. / --- / .--. / --.- / .-. / ... / - / ..- / ...- / .-- / -..- / -.-- / --..".split(" / "))
                .collect(Collectors.toList());

        IntStream.range(0, letters.size())
                .forEach(index -> hashMap.put(letters.get(index), morse.get(index)));
        hashMap.put(" ", ",");
    }


    @PostMapping("/morse")
    public void morseEncode(@RequestBody String letter) {
        System.out.println(letter);
            afterhash = hashMap.get(letter);
        System.out.println(afterhash);
    }

    @GetMapping("/morse")
    public String morsecoder(){

        return  afterhash;
    }

}




