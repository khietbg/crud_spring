package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.Student;
import ra.model.serviceIpm.StudentServiceIpm;


import java.util.List;

@Controller
@RequestMapping("studentController")
public class StudentController {
    @Autowired
    private StudentServiceIpm studentServiceIpm;
    @RequestMapping("getAll")
    public ModelAndView getAllStudent(){
        ModelAndView mav = new ModelAndView("students");
        List<Student> students = studentServiceIpm.findAll();
        mav.addObject("listStudent",students);
        return mav;
    }
    @GetMapping("initCreate")
    public String initCreate(Model model){
        Student stNew = new Student();
        model.addAttribute("stNew",stNew);
     return "newStudent";
    }
    @PostMapping("create")
    public String createStudent(Student stNew){
        boolean result = studentServiceIpm.save(stNew);
        if (result){
            return "redirect:getAll";
        }else {
            return "error";
        }
    }
    @GetMapping("delete")
    public String deleteStudent(String id){
        boolean res = studentServiceIpm.deleteStudent(id);
        if (res){
            return "redirect:getAll";
        }else {
            return "error";
        }
    }
    @GetMapping("edit")
    public String edit(Model model,String id){
        Student stUpdate =  studentServiceIpm.findById(id);
        System.out.println(stUpdate);
        model.addAttribute("stUpdate",stUpdate);
        return "updateStudent";
    }
    @PostMapping("update")
    public String updateStudent(Student student){
       boolean res = studentServiceIpm.updateStudent(student);
        if (res){
            return "redirect:getAll";
        }else {
            return "error";
        }
    }

}

