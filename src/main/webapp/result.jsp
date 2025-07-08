<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		header{
			width: 100%;
			background: #D8E3AB;
			height: 70px;
		}
    </style>
</head>
<body>
	<h2>Результат:</h2>
    <div id="result">
        <% 
		    if(request.getAttribute("result") != null) {
		        Object resultObj = request.getAttribute("result");
		        if(resultObj instanceof java.util.List) {
		            java.util.List<Integer[]> result = (java.util.List<Integer[]>) resultObj;
		            for(int i = 0; i < result.size(); i++) {
		                out.print(java.util.Arrays.toString(result.get(i)));
		                if(i != result.size() - 1) {
		                	out.print(", ");
		                }
		            }
		        }
		    }
		%>
    </div>
    
    <form action="/algo-p-k/algo-servletf" method="post">
    	<input type="submit" value="Вернуться на главную">
    </form>
</body>
</html>