package ru.melkozerovau.MyFirstTestAppSpringBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class HelloController {
    ArrayList<String> arrayList;
    HashMap<String, String> hashMap;


    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(value = "value", defaultValue = "default value") String value) {
        if(arrayList == null) arrayList = new ArrayList<>();
        arrayList.add(value);

        return String.format("In array list added element '%s'!", value);
    }

    @GetMapping("/show-array")
    public String showArrayList() {
        return String.format("Array List: %s!", arrayList != null ? arrayList.toString() : "null");
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "value", defaultValue = "default value") String value) {
        if(hashMap == null) hashMap = new HashMap<>();
        int k = hashMap.size()+1;

        hashMap.put("key" + k, value);

        return String.format("In hash map in key " + k + " added value '%s'!", value);
    }

    @GetMapping("/show-map")
    public String showHashMap() {
        return String.format("Hash map: %s!", hashMap != null ? hashMap.toString() : "null");
    }

    @GetMapping("/show-all-lenght")
    public String showAllLenght() {
        return String.format("ArrayList " +
                (arrayList == null ? "not exist" : "has " + arrayList.size() + " elements") +
                "<br>HashMap " +
                (hashMap == null ? "not exist" : "has " + hashMap.size() + " elements"));
    }
}