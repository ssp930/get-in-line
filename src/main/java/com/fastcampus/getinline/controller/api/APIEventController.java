package com.fastcampus.getinline.controller.api;

import com.fastcampus.getinline.constant.ErrorCode;
import com.fastcampus.getinline.dto.APIErrorResponse;
import com.fastcampus.getinline.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class APIEventController {

    @GetMapping("events")
    public List<String> getEvents() {
        throw new GeneralException("ExceptionHandler test");
//        return List.of("event1", "event2");
    }

    @PostMapping("events")
    public Boolean createEvent() {
        throw new RuntimeException("ExceptionHandler test");
//        return true;
    }

    @GetMapping("events/{eventId}")
    public String getEvent(@PathVariable Integer eventId) {
        return "event : " + eventId;
    }

    @PutMapping("events/{eventId}")
    public boolean modifyEvent(@PathVariable Integer eventId) {
        return true;
    }

    @DeleteMapping("events/{eventId}")
    public boolean deleteEvent(@PathVariable Integer eventId) {
        return true;
    }

    @ExceptionHandler
    public ResponseEntity<APIErrorResponse> general(GeneralException e) {
        ErrorCode errorCode = e.getErrorCode();
        HttpStatus status = errorCode.isClientSideError() ?
                HttpStatus.BAD_REQUEST :
                HttpStatus.INTERNAL_SERVER_ERROR;

        return ResponseEntity
                .status(status)
                .body(APIErrorResponse.of(
                        false, errorCode, errorCode.getMessage(e)
                ));


    }







}
