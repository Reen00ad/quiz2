package com.example.quiz2.Controller;

import com.example.quiz2.ApiResponce.ApiResponce;
import com.example.quiz2.Model.Student;
import com.example.quiz2.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @GetMapping("/get")
    public ResponseEntity getStudent(){
        ArrayList<Student> students=studentService.getStudents();
        return ResponseEntity.status(200).body(students);
    }


    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponce("student added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int id,@RequestBody @Valid Student student,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated=studentService.updateStudent(id,student);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponce("student updated"));
        }
        return ResponseEntity.status(400).body("not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id){
        boolean isDelete=studentService.deleteStudent(id);
        if(isDelete){
            return ResponseEntity.status(200).body(new ApiResponce("student deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponce("not found"));
    }

    @GetMapping("/search/{id}")
    public ResponseEntity search(@PathVariable int id){
        Student search=studentService.search(id);
        if(search==null){
            return ResponseEntity.status(400).body(new ApiResponce("not found"));
        }
        return ResponseEntity.status(200).body(search);
    }

    @GetMapping("/major/{major}")
    public ResponseEntity majors(@PathVariable String major){
        ArrayList<Student> m=studentService.majors(major);
            return ResponseEntity.status(200).body(m);


    }


}
