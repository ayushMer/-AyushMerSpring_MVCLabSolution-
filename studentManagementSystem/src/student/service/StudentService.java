package student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import student.entity.student;

@Service
public interface StudentService {

	List<student> findAll();

	student findById(int studentId);
	
	void saveStudentInfo(student theStudent);
	
	void deleteByStudentId(int studentId);
	
	List<student> searchBy(String department);
	
}
