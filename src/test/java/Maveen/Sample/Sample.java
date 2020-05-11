package Maveen.Sample;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class Sample {
	
	@Test
	public void s1()
	{
		RestAssured.baseURI="http://216.10.245.166";
		Response res=given().queryParam("key","qaclick123").
		body("{"+

    "\"location\":{"+

        "\"lat\" : -38.383494,"+

        "\"lng\" : 33.427362"+

    "},"+

    "\"accuracy\":50,"+

    "\"name\":\"Frontline house\","+

    "\"phone_number\":\"(+91) 983 893 3937\","+

    "\"address\" : \"29, side layout, cohen 09\","+

    "\"types\": [\"shoe park\",\"shop\"],"+

    "\"website\" : \"http://google.com\","+

    "\"language\" : \"French-IN\""+

"}").
		when().
		post("/maps/api/place/add/json").
		then().assertThat().statusCode(200).and().
		contentType(ContentType.JSON).and().
		//body("results[0].geometry.location.lat",equalTo("-33.86882"));
		body("status",equalTo("OK")).extract().response();
		String s=res.asString();
		System.out.println(s);

		
	}
	@Test
	public void new()
	{
		System.out.println("this is the new method");
		
	}
}
