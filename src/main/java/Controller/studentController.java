package Controller;

import model.Student;
import service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "studentController", value = "/students")
public class studentController extends HttpServlet {
    private StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "home";
        }
        switch (action) {
            case "home":
                home(request, response);
                break;
            case "create":
                showFormCreate(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "update":
                showFormUpdate(request, response);
                break;
        }
    }

    public void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = studentService.findAll();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/students/home.jsp");
        request.setAttribute("studentList", studentList);
        requestDispatcher.forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentService.delete(id);
        response.sendRedirect("/students?action=home");
    }

    public void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/students/create.jsp");
        requestDispatcher.forward(request, response);
    }

    public void showFormUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        Student studentEdit = studentService.findStudentById(id);
        request.setAttribute("studentEdit", studentEdit);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/students/update.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create":
                add(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "search":
                searchStudent(request, response);
                break;
        }
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        int classRoomId = Integer.parseInt(request.getParameter("classRoomId"));
        Student newStudent = new Student(name, dateOfBirth, address, phone, email, classRoomId);
        studentService.add(newStudent);
        response.sendRedirect("/students?action=home");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nameEdit = request.getParameter("name");
        String dateOfBirthEdit = request.getParameter("dateOfBirth");
        String addressEdit = request.getParameter("address");
        String phoneEdit = request.getParameter("phone");
        String emailEdit = request.getParameter("email");
        int classroomIdEdit = Integer.parseInt(request.getParameter("classroomId"));
        Student studentEdit = new Student(nameEdit, dateOfBirthEdit, addressEdit, phoneEdit, emailEdit, classroomIdEdit);
        studentService.update(id, studentEdit);
        response.sendRedirect("/students?action=home");
    }

    public void searchStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search");
        request.setAttribute("studentList", studentService.findStudentByName(name));
        request.getRequestDispatcher("/students/home.jsp").forward(request, response);
    }

}