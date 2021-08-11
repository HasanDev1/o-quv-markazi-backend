package com.example.oquv_markazi.controller;

import com.example.oquv_markazi.model.Result;
import com.example.oquv_markazi.payload.CourseRequest;
import com.example.oquv_markazi.servise.CourseServise;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseServise courseServise;
    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody CourseRequest courseRequest){
        return courseServise.addCourse(courseRequest)? ResponseEntity.ok(new Result(true, "yangi kurs qo`shildi"))
                : new ResponseEntity(new Result(false, "xatolik sodir bo`ldi"), HttpStatus.BAD_REQUEST);
    }

}
