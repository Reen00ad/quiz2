package com.example.quiz2.Service;

import com.example.quiz2.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    ArrayList<Student> students=new ArrayList<>();

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public boolean updateStudent(int id,Student student){
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getId()==id){
                students.set(i,student);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(int id){
        for (int i = 0; i < students.size(); i++) {
        if(students.get(i).getId()==id){
            students.remove(i);
            return true;
        }
    }
        return false;
    }


    public Student search(int id){
        for(Student s :students){
            if(s.getId()==id){
                return s;
            }
        }
        return null;
    }

    public ArrayList<Student> majors(String major){
        ArrayList<Student> m=new ArrayList<>();
        for(Student s :students){
            if(s.getMajor().equalsIgnoreCase(major)){
                m.add(s);
            }
        }
        return m;
    }

}
