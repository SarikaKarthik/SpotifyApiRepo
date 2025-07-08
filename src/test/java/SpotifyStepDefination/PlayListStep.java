package SpotifyStepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import specBuilder.SpecificationClass;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.Spotify.pojo.Playlist;
import org.hamcrest.Matchers;

import PropertyPackage.DateAndTimeProvider;
import PropertyPackage.PropertyReaderClass;

public class PlayListStep {
	RequestSpecification reqs;
	ResponseSpecification ResponseSpec;
	Response response;
	@Given("required payload and endpoints to create the playlist")
	public void required_payload_and_endpoints_to_create_the_playlist() throws IOException {
	   
	Playlist plist=new Playlist();
	plist.setDescription("New  PlayList July");
	plist.setName("BollywoodHits of 2025 for July Month"+DateAndTimeProvider.getCurrentDateAndTime());
	plist.setPublic(false);
	reqs=given(SpecificationClass.requestSpec())
	
	.body(plist);
	}

	@When("User creates the playlist")
	public void user_creates_the_playlist() throws IOException 
	{
	    response=reqs.when()
	    			 .post("/users/31gmlrq477ksjmwpk5e46zojyt4y/playlists");
	}

	@Then("User should get the status code as {int}")
	public void user_should_get_the_status_code_as(Integer int1)
	{
		
		    	Playlist pl=response.as(Playlist.class);
		    	
			    String idValue=pl.getId();
			    
			    System.out.println("ID value is  :" +idValue);
			    
			    response.then()
			    .spec(SpecificationClass.ResponseSpec())
			    
			    .body("id",Matchers.containsString(idValue))
			    
			    .body("name",Matchers.equalToIgnoringCase(pl.getName()));
		
				response.then().assertThat().statusCode(int1);
				
				response.then().body(matchesJsonSchemaInClasspath("jsonSchema.json"));
				
				System.out.println("Validation Successful");
				
	}

	
	
	
	
}
