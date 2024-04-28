package com.ada.exam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ExamSchedulerController {

    @PostMapping("/schedule-exam")
    public String scheduleExam(@RequestParam("roomFile") MultipartFile roomFile,
                               @RequestParam("studentFile") MultipartFile studentFile) {
        // Logic to handle file uploads and process the algorithm
        List<String> resultList = AllocateRoomInGivenTimeAndDay.result(roomFile, studentFile);
        // Write resultList to output.csv file
        AllocateRoomInGivenTimeAndDay.finalResult(resultList);
        return "Exam scheduled successfully!";
    }
}

