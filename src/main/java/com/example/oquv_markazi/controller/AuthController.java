package com.example.oquv_markazi.controller;

import com.example.oquv_markazi.entity.Admin;
import com.example.oquv_markazi.entity.Registrated;
import com.example.oquv_markazi.model.Result;
import com.example.oquv_markazi.payload.LoginPayload;
import com.example.oquv_markazi.repository.AdminRepository;
import com.example.oquv_markazi.security.JwtTokenProvider;
import com.example.oquv_markazi.security.SecurityUtils;
import com.example.oquv_markazi.servise.RegisteratedServise;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final RegisteratedServise registeratedServise;
    private final AdminRepository adminRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final SecurityUtils securityUtils;


    @PostMapping("/register")
    public ResponseEntity registerClient(@RequestBody Registrated registrated){
        return registeratedServise.registerClient(registrated)? ResponseEntity.ok(new Result(true, "siz ro`yxatdan o`tdingiz. \nBiz siz bilan bog`lanamiz"))
                : new ResponseEntity(new Result(false, "nimadur xato ketti qaytadan urinib ko`ring"), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginPayload payload){
        Admin admin = adminRepository.findByUsername(payload.getUserName()).orElseThrow(()->new RuntimeException("user not found"));
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(payload.getUserName(), payload.getPassword()));
        String token  = jwtTokenProvider.createToken(admin.getUsername(), admin.getRoles());
        if (token==null){
            return new ResponseEntity(new Result(false, "something went wrong"), HttpStatus.BAD_REQUEST);
        }
        Map<String, Object> map = new HashMap();
        map.put("token", token);
        map.put("username", admin.getUsername());
        map.put("success",true);
        return ResponseEntity.ok(map);
    }

    @GetMapping("/me")
    public ResponseEntity getMe(){
        String username = securityUtils.getCurrentUser().orElseThrow(()->new RuntimeException("user not found"));
        return ResponseEntity.ok(adminRepository.findByUsername(username));
    }
}
