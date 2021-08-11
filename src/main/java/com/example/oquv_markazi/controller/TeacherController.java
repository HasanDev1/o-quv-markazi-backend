package com.example.oquv_markazi.controller;

import com.example.oquv_markazi.model.Result;
import com.example.oquv_markazi.payload.TeacherRequest;
import com.example.oquv_markazi.servise.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody TeacherRequest teacherRequest){
        return teacherService.addTeacher(teacherRequest)?ResponseEntity.ok(new Result(true, "O`qituvchi qo'shildi"))
                : new ResponseEntity(new Result(false, "nimadir xato bo`ldi"), HttpStatus.BAD_REQUEST);
    }
}
