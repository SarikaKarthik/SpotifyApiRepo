package specBuilder;

import java.io.IOException;
import java.util.HashMap;

import PropertyPackage.PropertyReaderClass;
import PropertyPackage.TokenGenerator;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecificationClass {
	
	
	
	@Step
	public static RequestSpecification requestSpec() throws IOException
	
	{
		HashMap<String,String> header=new HashMap<>();
		header.put("Content-Type","application/vnd.api+json");
		header.put("Authorization", "Bearer "+TokenGenerator.getAccessToken());
		RequestSpecification reqSpec=new RequestSpecBuilder()
		
		.setBaseUri(PropertyReaderClass.getBaseUri("baseUri"))
		.setBasePath(PropertyReaderClass.getBasePath("basePath"))

		.addHeaders(header)
		.addFilter(new AllureRestAssured())
		.log(LogDetail.BODY)
		.build();
		 return reqSpec;
	} 
		 
		/* public RequestSpecification RequesSpec1()
		 {
		 	HashMap<String,String> header1=new HashMap<>();
			header1.put("Content-Type","application/vnd.api+json");
			header1.put("Authorization", "Bearer "+token);
			RequestSpecBuilder requestSpec=new RequestSpecBuilder();
			
			requestSpec.setBaseUri("https://api.spotify.com")
			.setBasePath("v1")
			.addHeaders(header1)
			.log(LogDetail.ALL);
			RequestSpecification reqSpec1=requestSpec.build();
			 return reqSpec1; 
		 }  */
		 
		 @Step
		 public static ResponseSpecification ResponseSpec()
		 {
		    return new ResponseSpecBuilder()
			.expectContentType(ContentType.JSON)
			.log(LogDetail.ALL)
			// .expectStatusCode(201)
			
			 .build();
		    
			 
		 }
		 
	}
	

