package PropertyPackage;


import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.HashMap;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TokenGenerator {
	public static void main(String []args) throws IOException
	{
		String refresh_token=getAccessToken();
		System.out.println("Access token generated :"+refresh_token);
	}
	public static String getAccessToken() throws IOException
	{
	baseURI="https://accounts.spotify.com";
	HashMap<String,String> formdata=new HashMap<>();
	formdata.put("grant_type","refresh_token");
	formdata.put("refresh_token",PropertyReaderClass.getRefreshToken("refresh_token"));
	formdata.put("client_id",PropertyReaderClass.getClientId("client_id"));
	formdata.put("client_secret",PropertyReaderClass.getClientSecrete("client_secrete"));
	
	Response response=given()

	.header("Content-Type","application/x-www-form-urlencoded")
	.formParams(formdata)
	.when()
	.post("api/token").then().extract().response()
	//String str=response.asPrettyString();
	//System.out.println(str);
	//return str;
	.then().extract().response();
	JsonPath js =response.jsonPath();
	String access_token=js.getString("access_token");
	System.out.println("Access token generated :"+access_token);

	if(response.statusCode() !=200)
	{
		throw new RuntimeException("Failed to generate the access token");
	}
	return access_token;
	}
}
	
	
	

