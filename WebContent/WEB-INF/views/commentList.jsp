<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Comments</title>
 </head>
 <body>
  
    <h3>Comments</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Id</th>
          <th>PostId</th>
          <th>Name</th>
          <th>Email</th>
          <th>Body</th>
       </tr>
       <c:forEach items="${commentList}" var="post" >
          <tr>
            <td>${comment.Id}</td>
            <td>${comment.PostId}</td>
            <td>${comment.Name}</td>
            <td>${comment.Email}</td>
			<td>${comment.Body}</td>
          </tr>
       </c:forEach>
    </table>
 
    <a href="listPost" >Posts</a>

 </body>
</html>