<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Create Post</title>
   </head>
   <body>
    
    <h3>Create Post</h3>
     
    <p style="color: red;">${errorString}</p>
     
    <form method="POST" action="/createPost">
 
      <table border="0">
          <tr>
             <td>UserId</td>
             <td><input type="text" name=userid value="${post.userid}" /></td>
          </tr>
          <tr>
             <td>Title</td>
             <td><input type="text" name="title" value="${post.title}" required/></td>
          </tr>
          <tr>
             <td>Body</td>
             <td><input type="text" name="body" value="${post.body}" /></td>
          </tr>
          <tr>
             <td colspan="2">                   
                 <input type="submit" value="Submit" />
                 <a href="postList">Cancel</a>
             </td>
          </tr>
       </table>
       
     </form> 
       

   </body>
</html>