package com.spring.student.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.spring.student.model.Marks;
import com.spring.student.model.Student;
import com.spring.student.util.RestConnector;

@Service
public class StudentService {
	@Autowired
	private RestConnector restConnector;

    private static final Map<Integer, Student> studentMap = new HashMap<Integer, Student>();
    static {
        studentMap.put(1, new Student(1,"Arun", "10", "AP", null));
        studentMap.put(2, new Student(2,"Ajay", "9", "AP", null));
        studentMap.put(3, new Student(3,"Ben", "6", "TN", null));
        studentMap.put(4, new Student(4,"Balu", "5", "TN", null));
        studentMap.put(5, new Student(5,"chetan", "7", "KA", null));
        studentMap.put(6, new Student(6,"dallas", "8", "KA", null));
        studentMap.put(7, new Student(7,"allen", "4", "TA", null));
        studentMap.put(8, new Student(8,"norries", "7", "TA", null));
        studentMap.put(9, new Student(9,"vyom", "4", "UP", null));
        studentMap.put(10, new Student(10,"kumar", "10", "UP", null));
    }

    @HystrixCommand(fallbackMethod="getDefaultStudent")
    public Student getStudentDetails(int id) {
    	if (studentMap.containsKey(id)) 
    		return studentMap.get(id);
    	else
    		throw new RuntimeException("No Record found.");
    }

    public List<Student> getAllStudentDetails() {
        List<Student> students =  new ArrayList<Student>();
        students.addAll(studentMap.values());
        return students;
    }

    @HystrixCommand(fallbackMethod="defaultStudent", commandKey="StudentDeatilsWithMArks", groupKey="Student-Service",
    		commandProperties={
    		@HystrixProperty (name="circuitBreaker.sleepWindowInMilliseconds", value="60000"),
    		@HystrixProperty (name="circuitBreaker.errorThresholdPercentage", value="5"),
    })
    public Student getStudentDetailsWithMarks(int id) {
    	Student student = studentMap.get(id);
        Marks marks = restConnector.getMarks(id);
        student.setMark(marks);
        return student;
    }
    
    private Student defaultStudent(int id){
    	Student student = new Student(id, "test_user", "SBC", "INDIA", null);
        Marks marks = new Marks(35, 35, 35);
        student.setMark(marks);
        return student;
    }
    
    private Student getDefaultStudent(int id){
    	return new Student(id, "test_user", "SBC", "INDIA", null);
    }
}
