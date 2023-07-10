package com.fastcampus.getinline.controller.api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class APIPlaceController {

    @GetMapping("places")
    public List<String> getplaces() {
        return List.of("event1", "event2");
    }

    @PostMapping("places")
    public Boolean createPlace() {
        return true;
    }

    @GetMapping("places/{placeId}")
    public String getEvent(@PathVariable Integer placeId) {
        return "event : " + placeId;
    }

    @PutMapping("places/{placeId}")
    public boolean modifyEvent(@PathVariable Integer placeId) {
        return true;
    }

    @DeleteMapping("places/{placeId}")
    public boolean deleteEvent(@PathVariable Integer placeId) {
        return true;
    }








}
