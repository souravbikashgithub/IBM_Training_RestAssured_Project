import org.apache.commons.io.IOUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GenericFunctions {

	
	public static Response GenericFunctionscall(String data,String Method,String endpoint_string,String params) {
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		
		Response res = null;
		
		if(Method.contentEquals("POST")) {
			
			
			res=RestAssured.given().header("content-type","application/json").body(data).when().post(endpoint_string);
			
			return res;
		}
		else if(Method.contentEquals("GET")) {
			
			res=RestAssured.given().header("content-type","application/json").when().get(endpoint_string+"/"+data);
			return res;
			
		}
		else if(Method.contentEquals("PUT")){
			
			res=RestAssured.given().header("content-type","application/json").body(data).when().put(endpoint_string+"/"+params);
			
		}
		else if(Method.contentEquals("DELETE")) {
			res=RestAssured.given().header("content-type","application/json").when().delete(endpoint_string+"/"+params);
			
		}
		else {
			
			System.out.println("INVALID Input!!!!");
		}
	
		return res;
	}
}
