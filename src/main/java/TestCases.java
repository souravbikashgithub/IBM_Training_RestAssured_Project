import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import io.restassured.response.Response;

public class TestCases {
	
	@Test(priority=1)
	public void UserPostOps() throws IOException {
		
		
		
		FileInputStream fs= new FileInputStream(new File(System.getProperty("user.dir")+"/src/test/java/Data/UserData.json"));
		
		
		Response res=GenericFunctions.GenericFunctionscall(IOUtils.toString(fs),"POST","/user","");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		System.out.println("POST Response >>"+res.asPrettyString());
		
		Assert.assertEquals(res.jsonPath().getInt("code"), 200);
		
	}
	
	
	@Test(priority=2)
	public void UserGetOps() throws IOException {
		
		
		Response res=GenericFunctions.GenericFunctionscall("Sourav","GET","/user","");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		System.out.println("GET Response>>"+res.asPrettyString());
		
	}
	
	@Test(priority=3)
	public void UserPUTOps() throws IOException {
		
		FileInputStream fs= new FileInputStream(new File(System.getProperty("user.dir")+"/src/test/java/Data/UserData_PUTOPS.json"));
		
		Response res=GenericFunctions.GenericFunctionscall(IOUtils.toString(fs),"PUT","/user","Sourav");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		System.out.println("PUT Response >>"+res.asPrettyString());
		Assert.assertEquals(res.jsonPath().getInt("code"), 200);
		
	}
	
	@Test(priority=4)
	public void UserDeleteOps() throws IOException {
		
		Response res=GenericFunctions.GenericFunctionscall("","DELETE","/user","Sourav Bikash");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		System.out.println("Delete Response >>"+res.asPrettyString());
		Assert.assertEquals(res.jsonPath().getInt("code"), 200);
		
	}
	
	@Test(priority=5)
public void UserNegativeOps() throws IOException {
		
		Response res=GenericFunctions.GenericFunctionscall("","DELETE","/user","Kushal");
		
		Assert.assertEquals(res.getStatusCode(), 404);
		
		System.out.println(res.asPrettyString());
		
	}
	
}
