package com.example.demo.controller;

import com.example.demo.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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

    public Student getStudentFileById(int id) {
//        // Fetch student by ID
//        Student student = StudentRepository.findById(id)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
//
//        // Convert byte[] to file
//        File file = new File("output/" + student.getImagename()); // output directory
//        try (FileOutputStream fos = new FileOutputStream(file)) {
//            fos.write(student.getData()); // Writing the byte data to the file
//        }

        return StudentRepository.findById(id).orElse(null);
    }

//    public Iterable<Student> findAll() {
//        return StudentRepository.findAll();
//    }


//    @GetMapping("/{id1}/image");
//    public ResponseEntity<byte[]> getimage(@PathVariable int id1){
//
//        Student student=StudentRepository.findById(id1);
//        byte[] imageFile=student.getData();
//        return ResponseEntity.ok().body(imageFile);
//    }
//
}
