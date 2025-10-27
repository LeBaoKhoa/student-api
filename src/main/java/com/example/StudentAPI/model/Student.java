package com.example.StudentAPI.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Student {

    private Integer id;

    @NotBlank(message = "Tên không được để trống")
    private String name;

    @Min(value = 0, message = "Tuổi phải >= 0")
    private Integer age;

    @Email(message = "Email không hợp lệ")
    private String email;

    public Student() {}

    public Student(Integer id, String name, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
