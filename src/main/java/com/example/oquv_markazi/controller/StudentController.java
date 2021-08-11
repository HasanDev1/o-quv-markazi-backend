package com.example.oquv_markazi.controller;

import com.example.oquv_markazi.model.Result;
import com.example.oquv_markazi.servise.StudentService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/add/{registeredUuid}/{groupUuid}")
    public ResponseEntity addStudentFromRegistrated(@PathVariable UUID registeredUuid, @PathVariable UUID groupUuid){
        return   studentService.addStudent(registeredUuid, groupUuid)? ResponseEntity.ok(new Result(true, "yangi student qo`shildi"))
            : new ResponseEntity(new Result(false, "student qo`shilmadi"), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("all")
    public ResponseEntity getAllStudents(@RequestParam(defaultValue = "0", name = "page") int page, @RequestParam(defaultValue = "6", name = "size") int size ) throws NotFoundException {
        return ResponseEntity.ok(studentService.findAllByPage(page, size));
    }
}
