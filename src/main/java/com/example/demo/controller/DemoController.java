package com.example.demo.controller;
import com.example.demo.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:3000")// Replace with your front-end's address

public class DemoController {


    @Autowired
    private com.example.demo.StudentRepository StudentRepository;



    @GetMapping("/id/{id}")
    public @ResponseBody Optional<Student> getStudent(@PathVariable("id") int id){
        return StudentRepository.findById(id);
    }





@Autowired
private Service service;
    @GetMapping("/")
    public @ResponseBody Iterable<Student> getStudents(){
        return service.findAll();
    }
@GetMapping("image/{id}")
public ResponseEntity<FileSystemResource> getimage(@PathVariable int id){
    try {

        File file =service.getStudentFileById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new FileSystemResource(file));
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

}



    @PostMapping("/upload")
    public String uploadImage(@RequestPart("file") MultipartFile file) throws IOException {
        try{
            service.saveImage(file);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "hii";
//        try {
//            Student savedImage = service.saveImage(file);
//            return ResponseEntity.ok("Image uploaded successfully. Image ID: " + savedImage.getId());
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Image upload failed: " + e.getMessage());
//        }
    }


//    @GetMapping("/{name}")
//    public @ResponseBody Iterable<Student> getStudentByName(@PathVariable("name") String name){
//        return StudentRepository.findByName(name);
//    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Integer>> getStudentIds(@PathVariable String name) {
        // Logic to retrieve IDs by name
        List<Integer> ids = StudentRepository.getIdsByName(name);
        return ResponseEntity.ok(ids);
    }
    @PostMapping("/")
    public Student createUser(@RequestBody Student user) {
        return StudentRepository.save(user);
    }


    @PutMapping("/{id}")
    public @ResponseBody Student updateName(@PathVariable("id") int id,@RequestBody Student student){
        Student responseStudent = StudentRepository.findById(id).get();
        if(student.getName()!=null) responseStudent.setName(student.getName());
        return StudentRepository.save(responseStudent);
    }


    @DeleteMapping("{id}")
    public @ResponseBody void deleteStudent(@PathVariable("id") int id){
         StudentRepository.deleteById(id);
    }
    @DeleteMapping("all")
    public @ResponseBody void deleteAllStudent(){
        StudentRepository.deleteAll();
    }
}
