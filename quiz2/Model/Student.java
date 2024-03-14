package com.example.quiz2.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    @NotNull(message = "id cannot be null")
    private int id;
    @NotEmpty(message = "name cannot be empty")
    private String name;
    @NotNull(message = "age cannot be null")
    @Min(value = 18,message = "age must be greater than 18")
    private int age;
    @NotEmpty(message = "major cannot be null")
    private String major;
}
