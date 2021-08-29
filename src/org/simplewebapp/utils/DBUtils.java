package org.simplewebapp.utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.simplewebapp.beans.Posts;
import org.simplewebapp.beans.Comments;
 
public class DBUtils {
 
    public static List<Posts> queryPost() throws IOException{
    	
		List<Posts> list = new ArrayList<Posts>();
		
	    URL urlForGetRequest = new URL("https://jsonplaceholder.typicode.com/posts");
	    String readLine = null;
	    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
	    conection.setRequestMethod("GET");
	    int responseCode = conection.getResponseCode();

	    if (responseCode == HttpURLConnection.HTTP_OK) {
	        BufferedReader in = new BufferedReader( new InputStreamReader(conection.getInputStream()));
	        StringBuffer response = new StringBuffer();
	        while ((readLine = in .readLine()) != null) {
	            //response.append(readLine);
	            
	        	JSONObject json = new JSONObject(readLine); 
	        	
	        	int id = json.getInt("Id");
	        	int userid = json.getInt("UserId");
	        	String title = json.getString("Title");
	        	String body = json.getString("Body");
	        	
	            Posts post = new Posts();
	            post.setId(id);
	            post.setUserId(userid);
	            post.setTitle(title);
	            post.setBody(body);
	            
	            list.add(post);
	         
	            
	        } in .close();
	        // print result
	        //System.out.println("JSON String Result " + response.toString());
	        //GetAndPost.POSTRequest(response.toString());
	        
	    } else {
	        System.out.println("GET POST - ERROR ");
	    }
		return list;
    }
 
    public static List<Posts> filterPost(int filterPostId) throws IOException{
    	
		List<Posts> list = new ArrayList<Posts>();
	
	    URL urlForGetRequest = new URL("https://jsonplaceholder.typicode.com/posts/"+filterPostId);
	    String readLine = null;
	    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
	    conection.setRequestMethod("GET");
	    int responseCode = conection.getResponseCode();

	    if (responseCode == HttpURLConnection.HTTP_OK) {
	        BufferedReader in = new BufferedReader( new InputStreamReader(conection.getInputStream()));
	        StringBuffer response = new StringBuffer();
	        while ((readLine = in .readLine()) != null) {
	            //response.append(readLine);
	            
	        	JSONObject json = new JSONObject(readLine); 
	        	
	        	int id = json.getInt("Id");
	        	int userid = json.getInt("UserId");
	        	String title = json.getString("Title");
	        	String body = json.getString("Body");
	        	
	            Posts post = new Posts();
	            post.setId(id);
	            post.setUserId(userid);
	            post.setTitle(title);
	            post.setBody(body);
	            
	            list.add(post);
	         
	            
	        } in .close();
	        // print result
	        //System.out.println("JSON String Result " + response.toString());
	        //GetAndPost.POSTRequest(response.toString());
	        
	    } else {
	        System.out.println("GET - ERROR ");
	    }
		return list;
    }
 
    public static List<Posts> filterBody(String bodytxt) throws IOException{
    	
		List<Posts> list = new ArrayList<Posts>();
		
    	if (bodytxt != null) {
    			
	        URL urlForGetRequest = new URL("https://jsonplaceholder.typicode.com/posts");
		    String readLine = null;
		    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
		    conection.setRequestMethod("GET");
		    int responseCode = conection.getResponseCode();
	
		    if (responseCode == HttpURLConnection.HTTP_OK) {
		        BufferedReader in = new BufferedReader( new InputStreamReader(conection.getInputStream()));
		        StringBuffer response = new StringBuffer();
		        while ((readLine = in .readLine()) != null) {
		            //response.append(readLine);
		            
		        	JSONObject json = new JSONObject(readLine); 
		        	
		        	int id = json.getInt("Id");
		        	int userid = json.getInt("UserId");
		        	String title = json.getString("Title");
		        	String body = json.getString("Body");
		        	
		        	if (body.contains(bodytxt)) {
			            Posts post = new Posts();
			            post.setId(id);
			            post.setUserId(userid);
			            post.setTitle(title);
			            post.setBody(body);
			            
			            list.add(post);
		        	}
		            
		        } in .close();
		        // print result
		        //System.out.println("JSON String Result " + response.toString());
		        //GetAndPost.POSTRequest(response.toString());
		        
		    } else {
		        System.out.println("GET - ERROR ");
		    }
    	}

		return list;
    	
    }
    
    public static void insertPost(String userid, String title, String body) throws IOException {
    	
    	final String POST_PARAMS = "{\n" + "\"UserId\": "+userid+",\r\n" +
	        "    \"Title\": \""+title+"\",\r\n" +
	        "    \"Body\": \""+body+"\"\n}";
	    //System.out.println(POST_PARAMS);
	    URL obj = new URL("https://jsonplaceholder.typicode.com/posts");
	    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
	    postConnection.setRequestMethod("POST");
	    //postConnection.setRequestProperty("userId", "a1bcdefgh");
	    postConnection.setRequestProperty("Content-Type", "application/json");

	    postConnection.setDoOutput(true);
	    OutputStream os = postConnection.getOutputStream();
	    os.write(POST_PARAMS.getBytes());
	    os.flush();
	    os.close();

	    int responseCode = postConnection.getResponseCode();
	    //System.out.println("POST Response Code :  " + responseCode);
	    //System.out.println("POST Response Message : " + postConnection.getResponseMessage());

	    if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	            postConnection.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();

	        while ((inputLine = in .readLine()) != null) {
	            response.append(inputLine);
	        } in .close();

	        // print result
	        System.out.println(response.toString());
	    } else {
	        System.out.println("POST - ERROR ");
	    }
    }
 
    public static void deletePost(String id) throws IOException {
    	URL url = new URL("https://jsonplaceholder.typicode.com/posts/"+id);
    	HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
    	httpCon.setDoOutput(true);
    	httpCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded" );
    	httpCon.setRequestMethod("DELETE");
    	httpCon.connect();
    	
    	int responseCode = httpCon.getResponseCode();
    	
	    if (responseCode == HttpURLConnection.HTTP_OK) {
		        // print result
	        //System.out.println("JSON String Result " + response.toString());
	        //GetAndPost.POSTRequest(response.toString());
	        
	    } else {
	        System.out.println("DELETE - ERROR ");
	    }
	    
    }
  
    public static List<Comments> queryComments(String PID) throws IOException{
    	
		List<Comments> list = new ArrayList<Comments>();
		
	    URL urlForGetRequest = new URL("https://jsonplaceholder.typicode.com/posts/"+PID+"/comments");
	    String readLine = null;
	    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
	    conection.setRequestMethod("GET");
	    int responseCode = conection.getResponseCode();

	    if (responseCode == HttpURLConnection.HTTP_OK) {
	        BufferedReader in = new BufferedReader( new InputStreamReader(conection.getInputStream()));
	        StringBuffer response = new StringBuffer();
	        while ((readLine = in .readLine()) != null) {
	            //response.append(readLine);
	            
	        	JSONObject json = new JSONObject(readLine); 
	        	
	        	int id = json.getInt("Id");
	        	int postid = json.getInt("PostId");
	        	String name = json.getString("Name");
	        	String email = json.getString("Email");
	        	String body = json.getString("Body");
	        	
	            Comments comment = new Comments();
	            comment.setId(id);
	            comment.setPostId(postid);
	            comment.setName(name);
	            comment.setEmail(email);
	            comment.setBody(body);
	            
	            list.add(comment);
	            
	        } in .close();
	        // print result
	        //System.out.println("JSON String Result " + response.toString());
	        //GetAndPost.POSTRequest(response.toString());
	        
	    } else {
	        System.out.println("GET - ERROR ");
	    }
		return list;
    }
    
    public static void ExportPostsListToCSV() throws IOException {

	    URL urlForGetRequest = new URL("https://jsonplaceholder.typicode.com/posts");
	    String readLine = null;
	    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
	    conection.setRequestMethod("GET");
	    int responseCode = conection.getResponseCode();

	    if (responseCode == HttpURLConnection.HTTP_OK) {
	        BufferedReader in = new BufferedReader( new InputStreamReader(conection.getInputStream()));
	        StringBuffer response = new StringBuffer();
	        
	        StringBuilder sb = new StringBuilder();
            sb.append("Post ID,");
            sb.append(',');
            sb.append("User ID");
            sb.append(',');
            sb.append("Title");
            sb.append(',');
            sb.append("Body");
            sb.append(',');
            sb.append('\n');
            
	        while ((readLine = in .readLine()) != null) {
	            //response.append(readLine);
	            
	        	JSONObject json = new JSONObject(readLine); 
	        	
	        	int id = json.getInt("Id");
	        	int userid = json.getInt("UserId");
	        	String title = json.getString("Title");
	        	String body = json.getString("Body");
	        		            
	            try (PrintWriter writer = new PrintWriter(new File("ExportPosts.csv"))) {

	                sb.append(id);
	                sb.append(',');
	                sb.append(userid);
	                sb.append(',');
	                sb.append(title);
	                sb.append(',');
	                sb.append(body);
	                sb.append(',');
	                sb.append('\n');

	                writer.write(sb.toString());

	              } catch (FileNotFoundException e) {
	                System.out.println(e.getMessage());
	              }
	
	        } in .close();
	        // print result
	        //System.out.println("JSON String Result " + response.toString());
	        //GetAndPost.POSTRequest(response.toString());
	        
	    } else {
	        System.out.println("GET POST TO EXPORT- ERROR ");
	    }
			
    }
 
}