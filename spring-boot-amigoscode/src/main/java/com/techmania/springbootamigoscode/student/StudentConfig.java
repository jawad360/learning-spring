package com.techmania.springbootamigoscode.student;

import com.techmania.springbootamigoscode.intructor.Instructor;
import com.techmania.springbootamigoscode.intructor.InstructorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository,
                                        InstructorRepository instructorRepository) {
        return args -> {
            List<Student> students = List.of(
                    new Student("Jawad", "jawad@gmail.com", LocalDate.of(2000, Month.JANUARY, 5)),
                    new Student("Jawad", "jawad@gmail.com", LocalDate.of(2009, Month.JANUARY, 5))
            );
          studentRepository.saveAll(students);

            Instructor instructor = new Instructor("Divya", "divya@gmail.com" );
            instructorRepository.save(instructor);
        };
    }
}
