package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class Third {
    @Test
   public void testPUT() {
    	Map<String,Object> map1 = new HashMap<String,Object>();

    	
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
    	.put("/users/2")
    	.then()
    	.statusCode(200).log().all();
    }
    @Test
   public void testPATCH() {
    	Map<String,Object> map1 = new HashMap<String,Object>();

    	
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
    	.patch("/users/2")
    	.then()
    	.statusCode(200).log().all();
    }
    
    @Test
   public void testDELETE() {
    
    	baseURI="https://reqres.in/api";

    	when()
    	.delete("/users/2")
    	.then()
    	.statusCode(204).log().all();
    }
}
