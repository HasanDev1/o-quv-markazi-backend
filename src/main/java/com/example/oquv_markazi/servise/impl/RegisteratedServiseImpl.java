package com.example.oquv_markazi.servise.impl;

import com.example.oquv_markazi.entity.Registrated;
import com.example.oquv_markazi.repository.RegistratedRepository;
import com.example.oquv_markazi.servise.RegisteratedServise;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegisteratedServiseImpl implements RegisteratedServise {

    private final RegistratedRepository registratedRepository;

    @Override
    public boolean registerClient(Registrated registrated) {
        Registrated registrated1 = new Registrated();
        registrated1.setFullName(registrated.getFullName());
        registrated1.setPhoneNumber(registrated.getPhoneNumber());
        registrated1.setCourseType(registrated.getCourseType());
        registratedRepository.save(registrated1);
        return true;
    }

    @Override
    public Page<Registrated> allRegisteredStudents(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Registrated> registrateds = registratedRepository.findAll(pageRequest);
        return registrateds;
    }
}
