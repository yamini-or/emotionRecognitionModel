<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
      <title> Pie Chart</title>
      <script src="https://cdn.anychart.com/js/8.0.1/anychart-core.min.js"></script>
      <script src="https://cdn.anychart.com/js/8.0.1/anychart-pie.min.js"></script>
  </head>

<body>
	<h1>Analysis done</h1>
	<h2>Emotion List : </h2>
	 

	<div id="container" style="float:left; width: 80%; height: 80%"></div>
	<script>
		anychart.onDocumentReady(function() {

		  // set the data
		  var data = [
		      {x: "Neutral", value: ${emotionList[0]}},
		      {x: "Anger", value: ${emotionList[1]}},
		      {x: "Disgust", value: ${emotionList[2]}},
		      {x: "Happy", value: ${emotionList[3]}},
		      {x: "Surprise", value: ${emotionList[4]}}
		      
		  ];

		  // create the chart
		  var chart = anychart.pie();

		  // set the chart title
		  chart.title("Emotion Count Analysis");

		  // add the data
		  chart.data(data);

		  // display the chart in the container
		  chart.container('container');
		  chart.draw();

		});
	</script>
	<div style="float:right;"></div>
	<form method="POST" action="${pageContext.request.contextPath}/saveComments" >
		<input type="text" name="video" value="${video}" readonly />
		<br/><br/>
		Comments:
		<input type="text" name="comments" id="comments" />
		<br/>
		<input type="submit" value="save" />

	</form>
</body>
</html>
