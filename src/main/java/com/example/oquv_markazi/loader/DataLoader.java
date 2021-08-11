package com.example.oquv_markazi.loader;

import com.example.oquv_markazi.entity.Admin;
import com.example.oquv_markazi.entity.Role;
import com.example.oquv_markazi.repository.AdminRepository;
import com.example.oquv_markazi.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String init;

    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AdminRepository adminRepository;


    public DataLoader(RoleRepository roleRepository, PasswordEncoder passwordEncoder, AdminRepository adminRepository) {
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.adminRepository = adminRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            if (init.equalsIgnoreCase("create")){
                Role roleUser = new Role();
                roleUser.setRoleName("ROLE_USER");
                Role roleAdmin = new Role();
                roleAdmin.setRoleName("ROLE_ADMIN");
                List<Role> roleList = new ArrayList<>(Arrays.asList(roleUser, roleAdmin));
                roleList = roleRepository.saveAll(roleList);

                Admin admin = new Admin();

                admin.setFullname("Hasan1");
                admin.setSocial("ok");
                admin.setPassword(passwordEncoder.encode("hasan01"));
                admin.setRoles(roleList);
                admin.setUsername("adminHasan");
                adminRepository.save(admin);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
