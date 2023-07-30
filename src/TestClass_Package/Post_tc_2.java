package TestClass_Package;

import java.io.IOException;

import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import API_Common_FunctionPackage.API_Common_Function;
import API_Common_FunctionPackage.utility_common_function;
import io.restassured.path.json.JsonPath;
import requestRepositoryPackage.Post_req_repository;
public class Post_tc_2 {
	@Test
public static void execute() throws IOException {
	for (int i=0; i<5; i++) //retry method
	{
		String baseURI=Post_req_repository.Base_URI();
		String resource=Post_req_repository.post_resource();
		String requestBody=Post_req_repository.post_req3();
		int statusCode=API_Common_Function.res_status_code(baseURI, resource, requestBody);
		if (statusCode==201) {
			String responseBody=API_Common_Function.res_responseBody(baseURI, resource, requestBody);
			System.out.println(responseBody);
			Post_tc_2.validator(responseBody, requestBody);
			utility_common_function.EvidenceCreator("Post_tc_2", responseBody, requestBody);
			break;
		}
		else {
			System.out.println("corretc status code not found hence retrying ");
		}}}
public static void validator(String responseBody,String requestBody) 
 {
		// step 5 parse the response body
			JsonPath jspresponse=new JsonPath(responseBody);
			String res_name=jspresponse.getString("name");
			String res_job=jspresponse.getString("job");
			String res_id=jspresponse.getString("id");
			String res_createdAt=jspresponse.getString("createdAt");
			
			JsonPath jsprequest= new JsonPath(requestBody);
			   String req_name = jsprequest.getString("name");
			   String req_job =jsprequest.getString("job");
			   
			// step6 validation
			Assert.assertEquals(res_name, req_name);
			Assert.assertEquals(res_job, req_job);
			Assert.assertNotNull(res_id);
			//date
			String actualdate=res_createdAt.substring(0,10);
			String currentdate=LocalDate.now().toString();
			Assert.assertEquals(actualdate, currentdate);
			   }
	}