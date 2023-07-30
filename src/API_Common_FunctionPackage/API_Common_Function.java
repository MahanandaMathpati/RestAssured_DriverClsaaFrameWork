package API_Common_FunctionPackage;

 import io.restassured.RestAssured;
  import static io.restassured.RestAssured.given;
 public class API_Common_Function {

	public static int res_status_code(String Base_URI,String post_resource,String post_requestBody) {
		RestAssured.baseURI=Base_URI;
		int Status_code=given().header("Content-Type","application/json").body(post_requestBody).when().post(post_resource).then().extract().statusCode();
		
		return Status_code; 
		
		
	}
	public static String res_responseBody(String Base_URI,String post_resource,String post_requestBody) {
		RestAssured.baseURI=Base_URI;
		String responseBody=given().header("Content-Type","application/json").body(post_requestBody).when().post(post_resource).then().extract().asString();
		
		return responseBody;
		
	}
	
	
}