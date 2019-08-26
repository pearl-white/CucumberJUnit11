package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CustomResponse {

    private List<Teacher> teachers;

    // get mapping single student
    private int batch;
    private String birthDate;
    private String department;
    private String emailAddress;
    private String firstName;
    private String gender;
    private String joinDate;
    private String lastName;
    private String password;
    private String phone;
    private String premanentAddress;
    private int salary;
    private String section;
    private String subject;
    private int teacherId;
}
