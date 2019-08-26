package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.RequestBody;
import models.Teacher;
import org.junit.Assert;
import org.junit.Test;
import utilities.APIrunner;

import java.io.IOException;
import java.util.List;

public class MappingClass {

    String BASE_URL="http://api.cybertektraining.com/";
    @Test
    public void JsonToObject(){

        String jsonBody ="{\n" +
                "\t\t\"batch\": 0,\n" +
                "\t\t\"birthDate\": \"2019-08-20T23:48:00.450Z\",\n" +
                "\t\t\"department\": \"string\",\n" +
                "\t\t\"emailAddress\": \"string\",\n" +
                "\t\t\"firstName\": \"string\",\n" +
                "\t\t\"gender\": \"string\",\n" +
                "\t\t\"joinDate\": \"2019-08-20T23:48:00.450Z\",\n" +
                "\t\t\"lastName\": \"string\",\n" +
                "\t\t\"password\": \"string\",\n" +
                "\t\t\"phone\": \"string\",\n" +
                "\t\t\"premanentAddress\": \"string\",\n" +
                "\t\t\"salary\": 0,\n" +
                "\t\t\"section\": \"string\",\n" +
                "\t\t\"subject\": \"string\",\n" +
                "\t\t\"teacherId\": 0,\n" +
                "\t\t\"optionalTag\": \"+1\"\n" +
                "\t   }";



        ObjectMapper mapper = new ObjectMapper();

        try {
            Teacher teacher = mapper.readValue(jsonBody, Teacher.class);
            System.out.println(teacher.getFirstName());
            System.out.println(teacher.getBatch());
            System.out.println(teacher.getLastName());


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void ObjectToJsonString(){

        Teacher teacher = new Teacher();
        teacher.setBatch(11);
        teacher.setBirthDate("12/12/2019");
        teacher.setDepartment("Maths");
        teacher.setEmailAddress("some@gmail.com");
        teacher.setGender("Male");
        teacher.setLastName("LastName");
        teacher.setFirstName("Adam");


        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonBody = mapper.writeValueAsString(teacher);
            System.out.println(jsonBody);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void getMethod(){

        Response response = RestAssured.get("http://api.cybertektraining.com/teacher/all");
        //System.out.println(response.asString());
        Assert.assertTrue(response.statusCode()==200);

        ObjectMapper mapper = new ObjectMapper();

        try {
            MyResponse myResponse = mapper.readValue(response.asString(), MyResponse.class);
            List<Teacher> myTeachers = myResponse.getTeachers();

            for(Teacher teacher: myTeachers){
                if(teacher.getBatch()==11){
                    System.out.println("FirstName: "+teacher.getFirstName()+" batch : "+teacher.getBatch());
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        // get batch 11 first name
    }

    @Test
    public void deleteMethod(){

        for(int i=230; i>200; i--){
            Response response = RestAssured.delete(BASE_URL+"teacher/delete/"+i);
            System.out.println(response.statusCode());
        }
    }

    @Test
    public void postMethod(){

        Teacher teacher = new Teacher();
        teacher.setFirstName("Aaron");
        teacher.setLastName("Ruminski");
        teacher.setGender("Male");
        teacher.setEmailAddress("aaron@gmail.com");
        teacher.setDepartment("Maths");
        teacher.setBatch(11);
        teacher.setBirthDate("12/12/2019");
        teacher.setJoinDate("12/12/2019");
        teacher.setPassword("1231");
        teacher.setPhone("1231231212");
        teacher.setPremanentAddress("123 N. state st.");
        teacher.setSalary(100000000);
        teacher.setSection("SOme");
        teacher.setSubject("Intro to some class");

        Response response = RestAssured.given().
                contentType(ContentType.JSON).body(teacher).when().post(BASE_URL+"teacher/create");

        System.out.println("STATUS CODE: "+response.statusCode());
        System.out.println(response.asString());

    }

    @Test
    public void updateMethod(){

        Teacher teacher = new Teacher();
        teacher.setTeacherId(1106);
        teacher.setFirstName("John");
        teacher.setLastName("Smith");
        teacher.setGender("Male");
        teacher.setEmailAddress("John@gmail.com");
        teacher.setDepartment("Maths");
        teacher.setBatch(11);
        teacher.setBirthDate("12/12/2019");
        teacher.setJoinDate("12/12/2019");
        teacher.setPassword("1231");
        teacher.setPhone("1231231212");
        teacher.setPremanentAddress("123 N. state st.");
        teacher.setSalary(100000000);
        teacher.setSection("SOme");
        teacher.setSubject("Intro to some class");


        // task:
        // Test update API

        Response response = RestAssured.given().contentType(ContentType.JSON).body(teacher)
                .when().put(BASE_URL+"teacher/update");

        System.out.println(response.statusCode());
        System.out.println(response.asString());

        Response response1 = RestAssured.given().auth().basic("username", "password")
                .when().contentType(ContentType.JSON)
                .body(teacher).post("url");

    }

    @Test
    public void deleteStudentWithHeader(){

        Response response = RestAssured.given().header("Accept-Language", "en-US")
                .header("Content-Type", "application/json")
                .delete("http://cybertekchicago.com/student/delete/1448");
        System.out.println(response.asString());
        System.out.println(response.statusCode());
    }

    @Test
    public void testLombok(){

        TestLombok testLombok = new TestLombok();
        testLombok.setFirstName("SomeName");

        System.out.println(testLombok.getFirstName());

    }

    @Test
    public void testUtility0(){

        APIrunner.runGET("http://api.cybertektraining.com/teacher/all");
        System.out.println("Result: "+APIrunner.getCustomResponse().getTeachers().get(0).getTeacherId());

    }

    @Test
    public void testUtility1(){

        APIrunner.runGET("http://api.cybertektraining.com/teacher/1110");
        System.out.println("Size of teachers: "+APIrunner.getCustomResponse().getTeachers().size());
        System.out.println("First Name and Last Name "+
                APIrunner.getCustomResponse().getTeachers().get(0).getFirstName()+ " "+
                APIrunner.getCustomResponse().getTeachers().get(0).getLastName());

    }


    @Test
    public void testUtility2(){

        RequestBody requestBody = new RequestBody();

        requestBody.setFirstName("John");
        requestBody.setLastName("Smith");
        requestBody.setGender("Male");
        requestBody.setEmailAddress("John@gmail.com");
        requestBody.setDepartment("Maths");
        requestBody.setBatch(11);
        requestBody.setBirthDate("12/12/2019");
        requestBody.setJoinDate("12/12/2019");
        requestBody.setPassword("1231");
        requestBody.setPhone("1231231212");
        requestBody.setPremanentAddress("123 N. state st.");
        requestBody.setSalary(100000000);
        requestBody.setSection("SOme");
        requestBody.setSubject("Intro to some class");

        APIrunner.runPOST("http://api.cybertektraining.com/teacher/create", requestBody);
        System.out.println("CREATED TEACHER ID: "+APIrunner.getCustomResponse().getTeacherId());

    }


}













