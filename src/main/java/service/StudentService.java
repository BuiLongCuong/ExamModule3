package service;

import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements iService<Student> {
    private Connection connection = ConnectToMySql.getConnection();

    @Override
    public void add(Student student) {
        String sql = "INSERT INTO student(name,dateOfBirth,address, phone, email,classroomId)\n" +
                "VALUES (?,?,?,?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2, student.getDateOfBirth());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setInt(6, student.getClassRoomId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int findById(int id) {
        return 0;
    }

    @Override
    public void delete(int id) {
        String sql = "delete from student where id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Student student) {
        String sql = " UPDATE  student  SET name = ?, dateOfBirth = ?, address = ?, phone = ?, email = ? , classroomId = ?\n" +
                " WHERE id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,student.getName());
            statement.setString(2,student.getDateOfBirth());
            statement.setString(3,student.getAddress());
            statement.setString(4,student.getPhone());
            statement.setString(5,student.getEmail());
            statement.setInt(6, student.getClassRoomId());
            statement.setInt(7,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        String sql = "select * from student;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("dateOfBirth");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                int classroomId = resultSet.getInt("classroomId");
                Student student = new Student(id,name, dateOfBirth, address,phone, email, classroomId);
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Student findStudentById(int id) {
        String sql = "select * from student where id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("dateOfBirth");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                int classroomId = resultSet.getInt("classroomId");
                Student student = new Student(id,name, dateOfBirth, address,phone, email, classroomId);
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Student> findStudentByName(String name_search) {
        String sql = "select * from student where name like ?;";
        List<Student> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name_search + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("dateOfBirth");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                int classroomId = resultSet.getInt("classroomId");
                Student student = new Student(id ,name, dateOfBirth, address,phone, email, classroomId);
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
