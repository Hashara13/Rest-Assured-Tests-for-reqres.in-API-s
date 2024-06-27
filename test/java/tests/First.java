package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class First {
//    @Test
//   public void test1() {
// 
//    	baseURI="https://reqres.in/api";
//        given()
//        	.get("users/2")
//        .then()
//        	.statusCode(200)
//        	.body("data[4].first_name", equalTo("George"))
//        	.body("data.first_name", hasItems("Byron","George")); 
//
//    }
    
    @Test
   public void testPost() {
    	Map<String,Object> map1 = new HashMap<String,Object>();
//    	map1.put("name","Hashara");
//    	map1.put("Job","SQA");
//    	System.out.println(map1);
    	
    	// view in json format
    	JSONObject obj=new JSONObject(map1);
    	obj.put("name","Hashara");
    	obj.put("Job","SQA");
    	System.out.println(obj);
    	System.out.println(obj.toJSONString());

    	baseURI="https://reqres.in/api";
    	given()
    	.contentType(ContentType.JSON)
    	.accept(ContentType.JSON)
    	.body(obj.toJSONString())
    	.when()
    	.post("/users")
    	.then()
    	.statusCode(201).log().all();
    }
}
