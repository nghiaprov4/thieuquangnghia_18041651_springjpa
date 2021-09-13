package com.example.student_springjpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentSpringjpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentSpringjpaApplication.class, args);
    }
    @Bean
    public CommandLineRunner run(StudentRepository repository) {
        return (args ->  {
             //insertStudents(repository);
            // System.out.println(repository.findAll());
           // repository.deleteStudent(1L);
            //repository.updateById(2L,"Tran");
            repository.AddStudent(7L,"NguyenThat","Hoc","toithayhoavangtrencoxanh");


        });
    }
    public void insertStudents (StudentRepository studentRepository) {
        Student student = Student.builder()
                .firstName("ThieuQuang")
                .lastName("Nghia")
                .email("thieuquangnghia2k@gmail.com")
                .build();
        studentRepository.save(student);

    }




}
