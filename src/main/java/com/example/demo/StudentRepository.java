package com.example.demo;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

import com.example.demo.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Iterable<Student> findByName(String name);

    List<Integer> getIdsByName(String name);

}