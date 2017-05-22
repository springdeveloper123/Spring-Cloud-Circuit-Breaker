package com.spring.student.util;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.spring.student.model.Marks;

@Component
public class RestConnector {
		
    public Marks getMarks(int id) {
        String baseUrl = "http://localhost:8085";
    	String resultsUrl = baseUrl + "/results/" + id;
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Integer> marks = (Map) restTemplate.getForObject(resultsUrl, Object.class);
        return new Marks(marks.get("language"), marks.get("math"), marks.get("art"));
    }
}
