package com.example.oquv_markazi.controller;

import com.example.oquv_markazi.model.Result;
import com.example.oquv_markazi.payload.GroupRequest;
import com.example.oquv_markazi.servise.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/group")
public class GroupController {

    private final GroupService groupService;
    @PostMapping("/add")
    public ResponseEntity addGroup(@RequestBody GroupRequest groupRequest){
        return groupService.addGroup(groupRequest)?ResponseEntity.ok(new Result(true, "yangi guruh yaratildi"))
                : new ResponseEntity(new Result(false, "guruh yaratilishida nimadur xato"), HttpStatus.BAD_REQUEST);
    }
}
