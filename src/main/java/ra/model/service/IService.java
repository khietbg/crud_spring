package ra.model.service;

import ra.model.entity.Student;

import java.util.List;

public interface IService {
    List<Student> findAll();
    boolean save(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudent(String id);
    Student findById(String id);

}
