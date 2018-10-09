<html>
<body>
<h1>Upload Status</h1>
<h2>Message : ${message}</h2>
<form method="POST" action="${pageContext.request.contextPath}/startAnalysis" >
    <input type="text" name="video" value="${video}" readonly/>
    <input type="submit" name="submit" value="View Analysis" />
</form>


<script>
function myFunction() {
    document.getElementById("demo").value = "${video}";
     
}
</script>
</body>
</html>
