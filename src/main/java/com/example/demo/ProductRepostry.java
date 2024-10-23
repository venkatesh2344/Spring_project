package com.example.demo;

import com.example.demo.Model.Student;
import com.example.demo.Model.products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepostry extends JpaRepository<products, Integer>
{
    Iterable<Student> findByName(String name);
}
