package com.javainterviewpoint;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.javainterviewpoint.Student;

public class SpringRestTemplateClient
{
    public static final String REST_BASE_URI = "http://localhost:8080";
    
    static RestTemplate restTemplate = new RestTemplate();
    
    /**POST**/
    public static void createStudent()
    {
        Student student = new Student();
        student.setId(5);
        student.setName("JIP");
        student.setAge(5);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        
        HttpEntity entity = new HttpEntity<>(student,headers);
        restTemplate.postForObject(REST_BASE_URI+"/student", entity,Student.class);
    }
    
    /**GET**/
    private static void getStudent(int id)
    {
        Student student = restTemplate.getForObject(REST_BASE_URI+"/student/"+id, Student.class);
        System.out.println("**** Student with id : "+id+"****");
        System.out.println("Id :"+student.getId()+"    Name : "+student.getName()+"   Age : "+student.getAge());
    }
    public static void getAllStudents()
    {
       

        List<Map<String, Object>> studentList = restTemplate.getForObject(REST_BASE_URI + "/students", List.class);
        if (studentList != null)
        {
            System.out.println("**** All Students ****");
            for (Map<String, Object> map : studentList)
            {
                System.out.println("Id : id=" + map.get("id") + "   Name=" + map.get("name") + "   Age="
                        + map.get("age"));
            }
        } else
        {
            System.out.println("No Students exist!!");
        }
    }
    
    /**PUT**/
    public static void updateStudent()
    {
        Student student = new Student();
        student.setId(3);
        student.setName("JIP33333");
        student.setAge(333);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity entity = new HttpEntity<>(student,headers);
        
        restTemplate.put(REST_BASE_URI + "/student", entity,Student.class);
    }
    
    /**DELETE**/
    public static void deleteStudent(int id)
    {
        restTemplate.delete(REST_BASE_URI + "/student/"+id);
    }
    public static void main(String args[])
    {
        createStudent();
        
        getAllStudents();
        getStudent(2);
        
        updateStudent();
        
        deleteStudent(4);
    }
}
