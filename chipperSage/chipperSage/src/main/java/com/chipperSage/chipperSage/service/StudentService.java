package com.chipperSage.chipperSage.service;

import com.chipperSage.chipperSage.Model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);

    public List<Student> getAllStudents();

}
