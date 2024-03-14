package com.example.quiz2.Service;

import com.example.quiz2.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {

    ArrayList<Teacher> teachers=new ArrayList<>();

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public boolean updateTeacher(int id,Teacher teacher){
        for (int i = 0; i < teachers.size(); i++) {
            if(teachers.get(i).getId()==id){
                teachers.set(i,teacher);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTeacher(int id){
        for (int i = 0; i < teachers.size(); i++) {
            if(teachers.get(i).getId()==id){
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }

    public Teacher searchte(int id){
        for(Teacher t:teachers){
            if(t.getId()==id)
                return t;
        }
        return null;
    }

    public ArrayList<Teacher> salaryse(int salary){
        ArrayList<Teacher> s=new ArrayList<>();
        for (Teacher t:teachers){
            if(t.getSalary()>=salary){
                s.add(t);
            }
        }
        return s;
    }
}
