<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>New Video Upload</title>
   </head>

   <body>

      <script>
         function copyFileNameToLink(f) {
           if(f.file.value != "") {
            var path = f.file.value;
             var filename = path.replace(/^.*\\/, "");
             f.link.value = filename;
           }
         }
      </script>


      <h2>New Video Upload</h2>
      <form:form method = "POST" action="${pageContext.request.contextPath}/video" enctype="multipart/form-data" modelAttribute="video">
         Select a file (~12MB):
         <br/>
         <input type="file" name="file" accept="video/mp4,video/x-m4v,video/*,image/*" onchange="copyFileNameToLink(this.form)" required="required"/><br/><br/>
         <table>
            <tr>
               <td><form:label path = "title">Title</form:label></td>
               <td><form:input path = "title" required="required"/></td>
            </tr>
            <form:input type="hidden" name="link" path = "link" />
            
            <tr>
               <td><form:label path = "recruiter">Recruiter</form:label></td>
               <td><form:input path = "recruiter" required="required"/></td>
            </tr>
            <tr>
               <td><form:label path = "candidate">Candidate</form:label></td>
               <td><form:input path = "candidate" required="required"/></td>
            </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>  
      </form:form>
   </body>
</html>
