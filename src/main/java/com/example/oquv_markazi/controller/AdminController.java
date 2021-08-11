package com.example.oquv_markazi.controller;

import com.example.oquv_markazi.model.Result;
import com.example.oquv_markazi.servise.AdminServise;
import com.example.oquv_markazi.servise.RegisteratedServise;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registered")
@RequiredArgsConstructor
public class AdminController {
    private final AdminServise adminServise;
    private final RegisteratedServise registeratedServise;

    @GetMapping("all")
    public ResponseEntity getAllRegistered(){
        Boolean isList = adminServise.registeregList()!=null;
        return isList? ResponseEntity.ok(adminServise.registeregList())
                : new ResponseEntity(new Result(false, "Hech kim ro`yxatdan o`tmadi"), HttpStatus.NOT_FOUND);
    }

//    @GetMapping("all")
//    public ResponseEntity getAllStudents(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "6") int size){
//        return ResponseEntity.ok(studentService.findAllByPage(page, size));
//    }

    @GetMapping("/page")
    public ResponseEntity getAllByPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "6") int size){
        return ResponseEntity.ok(registeratedServise.allRegisteredStudents(page, size));
    }
}
