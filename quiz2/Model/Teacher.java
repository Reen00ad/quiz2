package com.example.quiz2.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    @NotNull(message = "id cannot be null")
    private int id;
    @NotEmpty(message = "name cannot be empty")
    private String name;
    @NotNull(message = "salary cannot be null")
    @Min(value = 3000,message = "salary must be greater than 3000")
    private int salary;
}
