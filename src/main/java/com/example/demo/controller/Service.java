package com.example.demo.controller;

import com.example.demo.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private com.example.demo.StudentRepository StudentRepository;

    public Student saveImage(MultipartFile file) throws IOException {
        Student image = new Student();
        image.setImagename(file.getOriginalFilename());
        image.setData(file.getBytes());
        return StudentRepository.save(image);
    }

    public File getStudentFileById(Integer id) throws IOException {
        // Fetch student by ID
        Student student = StudentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));

        // Convert byte[] to file
        File file = new File("output/" + student.getImagename()); // output directory
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(student.getData()); // Writing the byte data to the file
        }

        return file; // Returning the file object
    }

    public Iterable<Student> findAll() {
        return StudentRepository.findAll();
    }
}
