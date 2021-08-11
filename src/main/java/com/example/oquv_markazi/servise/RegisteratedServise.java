package com.example.oquv_markazi.servise;

import com.example.oquv_markazi.entity.Registrated;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RegisteratedServise {
    public boolean registerClient(Registrated registrated);
    public Page<Registrated> allRegisteredStudents(int page, int size);

}
