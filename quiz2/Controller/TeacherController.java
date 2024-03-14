package com.example.quiz2.Controller;

import com.example.quiz2.ApiResponce.ApiResponce;
import com.example.quiz2.Model.Teacher;
import com.example.quiz2.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        ArrayList<Teacher> teachers=teacherService.getTeachers();
        return ResponseEntity.status(200).body(teachers);
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponce("teacher added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable int id, @RequestBody @Valid Teacher teacher,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdated=teacherService.updateTeacher(id,teacher);
        if(isupdated){
            return ResponseEntity.status(200).body(new ApiResponce("teacher updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponce("not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable int id){
        boolean isdeleted=teacherService.deleteTeacher(id);
        if(isdeleted){
            return ResponseEntity.status(200).body(new ApiResponce("teacher deleted"));
        }
        return ResponseEntity.status(400).body("not found");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity searchte(@PathVariable int id){
        Teacher t=teacherService.searchte(id);
        if(t==null){
            return ResponseEntity.status(400).body(new ApiResponce("not found"));
        }
        return ResponseEntity.status(200).body(t);
    }

    @GetMapping("/salaryse/{salary}")
    public ResponseEntity salaryse(@PathVariable int salary){
        ArrayList<Teacher> s=teacherService.salaryse(salary);
        return ResponseEntity.status(200).body(s);
    }
}
