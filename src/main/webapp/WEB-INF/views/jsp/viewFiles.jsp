<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<html>

<body>
<h1>Video Files : </h1>


<form method="POST" action="${pageContext.request.contextPath}/viewFiles" >
	<input list="video" name="video"  autocomplete="off">
  	<datalist id="video">
    
    <c:forTokens items="${files}" delims="," var="f">
  		<option value="${f}"/>
	</c:forTokens>
  </datalist>
	
    <input type="submit" value="Submit" />
</form>

</body>
</html>