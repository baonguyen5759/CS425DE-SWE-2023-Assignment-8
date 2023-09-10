package edu.mum.cs.cs425.studentmgmt;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
//@EnableJpaRepositories("edu.mum.cs.cs425.studentmgmt.repositories")
//@EntityScan("edu.mum.cs.cs425.studentmgmt.model")
public class StudentMgmtApp implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentMgmtApp.class, args);
	}

	private void saveStudent(Student student) {
		Optional<Student> optionalStudent = studentRepository.findById(1L);
		if (optionalStudent.isPresent()) {
			System.out.println("Error ! Student 1 is already existed");
		} else {
			studentRepository.save(student);
			System.out.println("Inserted data to Student table successfully !");
		}
	}

	@Override
	public void run(String... args) throws Exception {
		Transcript transcript = new Transcript("BS Computer Science");

		Classroom classroom = new Classroom("McLaughlin building", "M105");

		Student student = new Student("000-61-0001", "Anna", "Lynn", "Smith", 3.45f, LocalDate.of(2019, 5, 24));

		// Task 2.1
		student.setTranscripts(Arrays.asList(transcript));

		// Task 2.2
		student.setClassrooms(Arrays.asList(classroom));

		saveStudent(student);
	}
}
