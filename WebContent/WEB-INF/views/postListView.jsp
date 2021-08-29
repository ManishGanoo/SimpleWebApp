<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Posts</title>
 </head>
 <body>
  
    <h3>Posts</h3>
 
    <p style="color: red;">${errorString}</p>
 	
 	<input type="text" name=userid value="${post.userid}" />
    <a href="filterId" >Filter by Id</a>
 	<input type="text" name="body" value="${post.body}" />
 	<a href="filterBody" >Filter by Body</a>
 	
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Id</th>
          <th>UserId</th>
          <th>Title</th>
          <th>Body</th>
          <th></th>
          <th></th>
       </tr>
       <c:forEach items="${postList}" var="post" >
          <tr>
             <td>${post.id}</td>
             <td>${post.userud}</td>
             <td>${post.title}</td>
             <td>${post.body}</td>
             <td>
                <a href="queryComments?code=${post.id}">Comments</a>
             </td>
             <td>
                <a href="deletePost?code=${post.id}">Delete</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
    <a href="createPost" >Create Post</a>
 	<a href="ExportPostsListToCSV" >Create Post</a>
 </body>
</html>