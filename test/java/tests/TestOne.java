package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestOne {

    @Test
    public void test1() {
        Response one = get("https://reqres.in/api/users?page=2");

        System.out.println(one.getStatusCode());
        System.out.println(one.getTime());
        System.out.println(one.getBody().asString());
        System.out.println(one.getHeader("Type"));
        
        int sC = one.getStatusCode();
        int asC = 200;
        Assert.assertEquals(sC, asC);
    }
    @Test
    public void test2() {
    	
    	// give results in one single line
    	baseURI="https://reqres.in/api";
        given()
        	.get("/users?page=2")
        .then()
        	.statusCode(200)
        	.body("data[4].id", equalTo(11))
        	.log().all(); // log to all responses

    }
    @Test
   public void test3() {
 
    	baseURI="https://reqres.in/api";
        given()
        	.get("users/2")
        .then()
        	.statusCode(200)
        	.body("data.id", equalTo(2)); 

    }
    
}
