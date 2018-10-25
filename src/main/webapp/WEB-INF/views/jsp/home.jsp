<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Emotion Recognition Model</title>
        <h1>Emotion Recognition Model</h1>
    </head>
    <body>
    	<div align="left">
	        <h2>Video List</h2>
	        
	        <table border="1">
	        	<th>Id</th>
	        	<th>Title</th>
	        	<th>Link</th>
	        	<th>Recruiter Name</th>
	        	<th>Candidate Name</th>
	        	<th>FaceCount</th>
	        	<th>Neutral</th>
	        	<th>Anger</th>
	        	<th>Disgust</th>
	        	<th>Happy</th>
	        	<th>Surprise</th>
	        	<th>Comments</th>
	        	
				<c:forEach var="video" items="${listVideo}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${video.title}</td>
					<td>${video.link}</td>
					<td>${video.recruiter}</td>
					<td>${video.candidate}</td>
					<td>${video.faceCount}</td>
					<td>${video.neutral}</td>
					<td>${video.anger}</td>
					<td>${video.disgust}</td>
					<td>${video.happy}</td>
					<td>${video.surprise}</td>
					<td>${video.comments}</td>

	        	</tr>
				</c:forEach>	        	
			</table>
    	</div>
    	<br><br><br>
    	<form method="POST" action="${pageContext.request.contextPath}/homePage" enctype="multipart/form-data">
     <input type="submit" name = "act1" value="View Files" />
     <input type="submit" name = "act2" value="Upload new file" />
</form>

    </body>
</html>
