package helper;


import models.CustomResponse;
import models.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HelperMethods {

    public static RequestBody convertMapToObject(Map<String, String> map){

        RequestBody requestBody = new RequestBody();

        requestBody.setFirstName(map.get("firstName"));
        requestBody.setLastName(map.get("lastName"));
        requestBody.setBirthDate(map.get("birthDate"));
        requestBody.setDepartment(map.get("department"));
        requestBody.setEmailAddress(map.get("emailAddress"));
        requestBody.setGender(map.get("gender"));
        requestBody.setJoinDate(map.get("joinDate"));
        requestBody.setPassword(map.get("password"));
        requestBody.setPhone(map.get("phone"));
        requestBody.setPremanentAddress(map.get("permenantAdd"));
        requestBody.setSection(map.get("section"));
        requestBody.setSubject(map.get("subject"));
        requestBody.setBatch(Integer.valueOf(map.get("batch")));
        requestBody.setSalary(Integer.valueOf(map.get("salary")));

        return requestBody;
    }

    public static void validate(CustomResponse response, List<Map<String, Object>> table,
                                    ArrayList<String> keys){

        // Compare first name, last name, teacher id, salary, batch, subject
        boolean check = true;
        String valueRS = null;
        String valueDB = null;

        Map<String, Object> map =null;

        for(Map<String, Object> mp: table){
            if((response.getTeacherId()+"").equals(mp.get("TEACHER_ID")+"")){
                map=mp;
            }
        }

        for(String key: keys){

            switch (key){

                case "firstName":
                    valueRS = response.getFirstName();
                    valueDB= map.get("FIRST_NAME")+"";
                    check = valueRS.equals(valueDB);
                    break;
                case "lastName":
                    valueRS = response.getLastName();
                    valueDB= map.get("LAST_NAME")+"";
                    check = valueRS.equals(valueDB);
                    break;
                case "teacher_id":
                    valueRS = response.getTeacherId()+"";
                    valueDB= map.get("TEACHER_ID")+"";
                    check = valueRS.equals(valueDB);
                    break;
                case "salary":
                    valueRS = response.getSalary()+"";
                    valueDB= map.get("SALARY")+"";
                    check = valueRS.equals(valueDB);
                    break;
                case "batch":
                    valueRS = response.getBatch()+"";
                    valueDB= map.get("BATCH")+"";
                    check = valueRS.equals(valueDB);
                    break;
                case "subject":
                    valueRS = response.getSubject();
                    valueDB= map.get("SUBJECT")+"";
                    check = valueRS.equals(valueDB);
                    break;

                default:
                    System.out.println("The "+key+ " is doesn't exist in switch statement!");

            }

            if(check){
                System.out.println("The "+key+" is verified with database");
            }else{
                System.out.println("The "+key+" is DOESN'T match " +
                        "with Database. " +
                        "The database value is "+valueDB+ "" +
                        "and response value is "+valueRS);
            }
        check =true;
        }

    }

}
