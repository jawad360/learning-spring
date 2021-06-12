package com.techmania.springbootamigoscode.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> existingStudent = studentRepository.findStudentByEmail(student.getEmail());
        if(existingStudent.isPresent()){
            throw new IllegalStateException("Student already existing");
        }
        studentRepository.save(student);
    }

    public void removeStudent(Long id){
        studentRepository.deleteById(id);
    }
}
