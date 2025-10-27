package com.example.StudentAPI.controller;

import com.example.StudentAPI.model.Student;
import com.example.StudentAPI.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public Student create(@Valid @RequestBody Student s) {
        return service.add(s);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable int id, @Valid @RequestBody Student s) {
        return service.update(id, s);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
