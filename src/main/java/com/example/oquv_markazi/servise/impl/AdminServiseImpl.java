package com.example.oquv_markazi.servise.impl;

import com.example.oquv_markazi.entity.Registrated;
import com.example.oquv_markazi.repository.AdminRepository;
import com.example.oquv_markazi.repository.RegistratedRepository;
import com.example.oquv_markazi.servise.AdminServise;
import com.sun.deploy.ui.AboutDialog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class AdminServiseImpl implements AdminServise {
    private final RegistratedRepository registratedRepository;

    @Override
    public List<Registrated> registeregList() {
        List<Registrated> registratedList = new ArrayList<>();
        registratedList = registratedRepository.findAll();
        return registratedList;
    }
}
