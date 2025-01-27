package day06;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.util.Arrays;

//POJO ---> JSON ->serialization
//JSON ---> POJO ->deserialization

public class TestSerializationDeserialization {

    @Test(enabled = false)
    public void testSerialization() throws JsonProcessingException {

        StudentPojo studentPojo = new StudentPojo();

        studentPojo.setName("John");
        studentPojo.setLocation("USA");
        studentPojo.setPhone("123456");
        String[] courses = {"Java", "React"};
        studentPojo.setCourses(courses);

        //converting java object to json (serialization)

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(studentPojo);

        System.out.println(jsonData);


    }


    @Test(enabled = true)
    public void testDeserialization() throws JsonProcessingException {
        String jsonData = "{\n" +
                "  \"name\" : \"Maria\",\n" +
                "  \"location\" : \"Germany\",\n" +
                "  \"phone\" : \"123456\",\n" +
                "  \"courses\" : [ \"React\", \"React\" ]\n" +
                "}";

        //converting JSON to Java Object (deserialization)

        ObjectMapper studentObject = new ObjectMapper();
        StudentPojo newStudent = studentObject.readValue(jsonData, StudentPojo.class);

        System.out.println(newStudent.getName());
        System.out.println(newStudent.getLocation());
        System.out.println(Arrays.toString(newStudent.getCourses()));
    }

}
