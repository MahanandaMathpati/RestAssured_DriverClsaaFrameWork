package requestRepositoryPackage;

import java.io.IOException;
import java.util.ArrayList;

import API_Common_FunctionPackage.utility_common_function;
public class Post_req_repository {
public static String Base_URI() {
		String Base_URI="https://reqres.in/";
		return Base_URI;
	}
	
	public static String post_resource() {
		String post_resource="/api/users";
		return post_resource;
	}
	
	public static String post_req1() throws IOException {
		
	ArrayList<String> data=utility_common_function.readdataexcel("Post_Test_Data", "Post_tc_1");
	
	
	String  req_name=data.get(1);
	String req_job=data.get(2);
	String post_requestBody="{\r\n"
			+ "    \"name\": \""+req_name+"\",\r\n"
			+ "    \"job\": \""+req_job+"\"\r\n"
			+ "}";
	return post_requestBody;
}
	
	public static String post_req2() throws IOException {
		
	ArrayList<String> data=utility_common_function.readdataexcel("Post_Test_Data", "Post_tc_2");
	
	
	String  req_name=data.get(1);
	String req_job=data.get(2);
	String post_requestBody="{\r\n"
			+ "    \"name\": \""+req_name+"\",\r\n"
			+ "    \"job\": \""+req_job+"\"\r\n"
			+ "}";
	return post_requestBody;

}
public static String post_req3() throws IOException {
		
		ArrayList<String> data=utility_common_function.readdataexcel("Post_Test_Data", "Post_tc_3");
		String  req_name=data.get(1);
		String req_job=data.get(2);
		String post_requestBody="{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		return post_requestBody;
	}}