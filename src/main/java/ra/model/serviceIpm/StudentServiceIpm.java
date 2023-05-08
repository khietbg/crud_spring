package ra.model.serviceIpm;

import org.springframework.stereotype.Service;
import ra.model.entity.Student;
import ra.model.service.IService;
import ra.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Service
public class StudentServiceIpm implements IService {
    @Override
    public List<Student> findAll() {
        List<Student> students = null;
        Connection conn = null;
        try {
            students = new ArrayList<>();
            conn = ConnectionDB.getConnection();
            CallableStatement call = conn.prepareCall("{call getAllStudent()}");
            ResultSet rs = call.executeQuery();
            while (rs.next()){
                Student student = new Student();
                student.setId((rs.getString("id")));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setAddress(rs.getString("address"));
                student.setPhone(rs.getString("phone"));
                students.add(student);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
       return students;
    }

    @Override
    public boolean save(Student student) {
        Connection conn = null;
        try {
            conn = ConnectionDB.getConnection();
            CallableStatement call = conn.prepareCall("{call createStudents(?,?,?,?,?)}");
            call.setString(1,student.getId());
            call.setString(2,student.getName());
            call.setInt(3,student.getAge());
            call.setString(4,student.getAddress());
            call.setString(5,student.getPhone());
           int res =  call.executeUpdate();
           if (res ==1){
               return true;
           }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return false;
    }

    @Override
    public boolean updateStudent(Student student) {
        Connection conn = null;
        try {
            conn = ConnectionDB.getConnection();
            CallableStatement call = conn.prepareCall("{call updateStudent(?,?,?,?,?)}");

            call.setString(1,student.getName());
            call.setInt(2,student.getAge());
            call.setString(3,student.getAddress());
            call.setString(4,student.getPhone());
            call.setString(5,student.getId());
            int res = call.executeUpdate();
            if (res==1){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    @Override
    public boolean deleteStudent(String id) {
        Connection conn = null;
        try {
            conn = ConnectionDB.getConnection();
            CallableStatement call = conn.prepareCall("{call deleteStudent(?)}");
          call.setString(1,id);
         int res =  call.executeUpdate();
         if (res == 1){
             return true;
         }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    @Override
    public Student findById(String id) {
        Connection conn = null;
        Student student = new Student();
        try {
            conn = ConnectionDB.getConnection();
            CallableStatement call = conn.prepareCall("{call findById(?)}");
            call.setString(1,id);
            ResultSet rs =  call.executeQuery();
            if (rs.next()){
                student.setId(rs.getString("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setAddress(rs.getString("address"));
                student.setPhone(rs.getString("phone"));
            }
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return student;

    }
}
