package com.spring.results.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.results.model.Marks;
import com.spring.results.service.StudentResultsService;

@RestController
@RequestMapping("/results")
public class StudentResultsSerivceRest {

    @Autowired
    StudentResultsService studentresultsService;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Marks getStudentresults(@PathVariable("id") int id){
    	Marks marks = studentresultsService.getStudentresults(id);
    	System.out.println("getStudentresults method : "+ marks);
        return marks;
    }

    @RequestMapping(method=RequestMethod.GET)
    public List<Marks> getAllStudentResults(){
    	List<Marks> marksList = studentresultsService.getAllStudentResults();
    	System.out.println("getAllStudentResults method : "+ marksList);
        return marksList;
    }
}
