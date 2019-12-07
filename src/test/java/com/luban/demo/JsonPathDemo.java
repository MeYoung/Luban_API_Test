package com.luban.demo;

import io.restassured.path.json.JsonPath;
import lombok.Data;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author shijin.huang
 * @date 2019-10-29
 * @content
 */
public class JsonPathDemo {

    String strJson = "{\n" +
            "  \"students\": [\n" +
            "    {\n" +
            "      \"name\": \"name1\",\n" +
            "      \"age\": \"12\",\n" +
            "      \"height\": 120\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"name2\",\n" +
            "      \"age\": 20,\n" +
            "      \"height\": 180\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    @Test
    public void test1() {
        JsonPath jsonPath = new JsonPath(strJson);
        Students students = jsonPath.getObject("students[0]", Students.class);
        System.out.println(students.getName());
        System.out.println(students.getAge());
        System.out.println(students.getHeight());

        System.out.println("==================");
        List<Students> studentsList = jsonPath.getList("students", Students.class);
        for (Students s : studentsList) {
            System.out.println(s.getName());
            System.out.println(s.getAge());
            System.out.println(s.getHeight());
        }
    }

}


@Data
class Students {
    private String name;
    private Integer age;
    private Integer height;
}
