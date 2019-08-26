package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Teacher {

    /*
    * {
		"batch": 0,
		"birthDate": "2019-08-20T23:48:00.450Z",
		"department": "string",
		"emailAddress": "string",
		"firstName": "string",
		"gender": "string",
		"joinDate": "2019-08-20T23:48:00.450Z",
		"lastName": "string",
		"password": "string",
		"phone": "string",
		"premanentAddress": "string",
		"salary": 0,
		"section": "string",
		"subject": "string",
		"teacherId": 0,
		"optionalTag": "+1"
	   }
    * */

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
