package com.example.student_springjpa;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
   public List<Student> findByFirstName(String firstName);
   public List<Student> findByLastName(String lastName);

    //--------------------CRUD JPQL--------------------------------------------------
    @Query("select e from Student e where e.StudentID = ?1")
    public Student findByCustomId(Long id);

    @Transactional
    @Modifying
    @Query("update Student e set e.firstName = ?2 where e.StudentID = ?1 ")
    public void updateById(Long id, String firstName);

    @Modifying
    @Transactional
    @Query("DELETE FROM Student e WHERE e.StudentID = ?1")
    public void deleleStudentJPQL(Long id);


    //-----------------------CRUD Native---------------------------------------------------------
    @Query(value = "select * from tbl_student", nativeQuery = true)
    public List<Student> findAllStudentNative();

    @Query(value = "select * from tbl_student where StudentID = ?1"
            ,nativeQuery = true)
    public Student findByStudentNative(Long id);

    @Transactional
    @Modifying
    @Query(value = "update tbl_student e set e.last_name = ?2 where e.StudentID = ?1", nativeQuery = true)
    public void  updateStudentNative(Long id, String lastName);


    @Modifying
    @Query(value = "insert into tbl_student (id,first_name, last_name, email) ", nativeQuery = true)
    @Transactional
    public Object AddStudent(Long id, String firstName, String lastName, String email);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tbl_student WHERE StudentID = ?1", nativeQuery = true)
    public void deleteStudent(Long id);
}
