package test;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonMapping {

    public static void main(String[] args) {

        String jsonBody ="{\n" +
                "        \t\t\"name\": \"John\",\n" +
                "        \t\t\"batch\": 17,\n" +
                "        \t\t\"subject\": \"Intro to Java\"\n" +
                "        \t}";

        String companyJson ="{\n" +
                "        \t\t\"company\": \"Goolge\",\n" +
                "        \t\t\"title\": \"Automation\",\n" +
                "        \t\t\"address\":{\n" +
                "        \t\t\t\"street\":\"123 N. Main st\",\n" +
                "        \t\t\t\"city\": \"Chicago\"\n" +
                "        \t\t}\n" +
                "        \t}";

        String listOfJson ="{\n" +
                "        \t\t\"company\": \"Goolge\",\n" +
                "        \t\t\"title\": \"Automation\",\n" +
                "        \t\t\"address\":[\n" +
                "        \t\t\t{\n" +
                "\t\t    \t\t\t\"street\":\"13 N. Main st\",\n" +
                "\t\t    \t\t\t\"city\": \"Chicago\"\n" +
                "\t\t    \t\t},\n" +
                "\n" +
                "\t\t    \t\t{\n" +
                "\t\t    \t\t\t\"street\":\"123 N. Main st\",\n" +
                "\t\t    \t\t\t\"city\": \"Chicago\"\n" +
                "        \t\t\t}\n" +
                "        \t\t\t\n" +
                "        \t\t]\n" +
                "        \t}";

        ObjectMapper mapper = new ObjectMapper();

        try {
//            Teacher teacher = mapper.readValue(jsonBody, Teacher.class);
//            System.out.println(teacher.getName());
//            System.out.println(teacher.getSubject());
        Company company = mapper.readValue(listOfJson, Company.class);

            System.out.println(company.getAddress().get(0).getStreet());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
