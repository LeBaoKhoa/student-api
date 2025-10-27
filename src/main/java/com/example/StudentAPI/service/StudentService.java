package com.example.StudentAPI.service;

import com.example.StudentAPI.exception.ResourceNotFoundException;
import com.example.StudentAPI.model.Student;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    private final Map<Integer, Student> studentDB = new HashMap<>();
    private int nextId = 1;

    public List<Student> getAll() {
        return new ArrayList<>(studentDB.values());
    }

    public Student getById(int id) {
        if (!studentDB.containsKey(id)) {
            throw new ResourceNotFoundException("Không tìm thấy sinh viên có id = " + id);
        }
        return studentDB.get(id);
    }

    public Student add(Student s) {
        s.setId(nextId++);
        studentDB.put(s.getId(), s);
        return s;
    }

    public Student update(int id, Student newData) {
        Student existing = getById(id);
        existing.setName(newData.getName());
        existing.setAge(newData.getAge());
        existing.setEmail(newData.getEmail());
        return existing;
    }

    public void delete(int id) {
        if (!studentDB.containsKey(id)) {
            throw new ResourceNotFoundException("Không tìm thấy sinh viên có id = " + id);
        }
        studentDB.remove(id);
    }
}
