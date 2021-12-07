package student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import student.entity.student;
import student.service.StudentService;

@Controller
@RequestMapping("/students")
public class studentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/list")
	public String listStudents(Model model)
	{
		List<student> studentList= studentService.findAll();
		model.addAttribute("Student", studentList);
		return "list-Students";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model)
	{
		student newStudent=new student();
		
		model.addAttribute("studForm", newStudent);
		
		return "student-Form";
	}
	
	@PostMapping("/save")
	public String saveStudent(@RequestParam ("studentId") int studentId ,@RequestParam ("firstName") String firstName,
							  @RequestParam ("department") String department,@RequestParam ("country") String country)
	{
		System.out.println(studentId);
		student theStudent;
		if(studentId!=0)
		{
			theStudent=studentService.findById(studentId);
			theStudent.setFirstName(firstName);
			theStudent.setDepartment(department);
			theStudent.setCountry(country);
		}
		else
			theStudent=new student(firstName,department,country);
		
		studentService.saveStudentInfo(theStudent);
		return "redirect:/students/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int studentId)
	{
		studentService.deleteByStudentId(studentId);
		return "redirect:/students/list";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam("department") String department,Model theModel)
	{
		if(department.trim().isEmpty())
			return "redirect:/students/list";
		else {
			List<student> theStudentList=studentService.searchBy(department);
			theModel.addAttribute("Student", theStudentList);
			return "list-Students";
		}
		
		
	}
}
