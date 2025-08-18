package utils;

import org.json.JSONObject;

public class APIPayloadConstant {


    public static String createEmployeePayload(){

        String createEmployee = "{emp_firstname\\\": \\\"veronica\\\",\\n\" +\n" +
                "                        \"  \\\"emp_lastname\\\": \\\"benitez\\\",\\n\" +\n" +
                "                        \"  \\\"emp_middle_name\\\": \\\"queen\\\",\\n\" +\n" +
                "                        \"  \\\"emp_gender\\\": \\\"F\\\",\\n\" +\n" +
                "                        \"  \\\"emp_birthday\\\": \\\"1990-10-13\\\",\\n\" +\n" +
                "                        \"  \\\"emp_status\\\": \\\"employed\\\",\\n\" +\n" +
                "                        \"  \\\"emp_job_title\\\": \\\"Senior QA tester\\\"\\n\" +\n" +
                "                        \"}";
        return createEmployee;
    }

    public static String jsonPayload(){

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "veronica");
        obj.put("emp_lastname", "benitez");
        obj.put("emp_middle_name", "queen");
        obj.put("emp_gender", "F");
        obj.put("emp_birthday", "1990-10-13");
        obj.put("emp_status", "employed");
        obj.put("emp_job_title", "Senior QA tester");

        return obj.toString();
    }

    public static String jsonPayloadMoreDynamic(
            String emp_firstname, String emp_lastname, String emp_middle_name, String emp_gender,
            String emp_birthday, String emp_status, String emp_job_title
    ){

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", emp_firstname);
        obj.put("emp_lastname", emp_lastname);
        obj.put("emp_middle_name", emp_middle_name);
        obj.put("emp_gender", emp_gender);
        obj.put("emp_birthday", emp_birthday);
        obj.put("emp_status", emp_status);
        obj.put("emp_job_title",emp_job_title);

        return obj.toString();
    }



}
