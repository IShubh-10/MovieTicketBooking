<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
        function validate(element) {
                
                if(element.value == "" && element.name == "MovieName") {
                    element.nextSibling.innerHTML=" This field is mandatory";
                    return false;
                }
                else if(element.value == "" && element.name == "director") {
                    element.nextSibling.innerHTML=" This field is mandatory";
                    return false;
                }
                else if(element.value == "" && element.name == "producer") {
                    element.nextSibling.innerHTML=" This field is mandatory";
                    return false;
                }
                else if(element.value == "" && element.name == "cast") {
                    element.nextSibling.innerHTML=" This field is mandatory";
                    return false;
                }
                else if(element.value == "" && element.name == "lang") {
                    element.nextSibling.innerHTML=" This field is mandatory";
                    return false;
                }
                else if(element.value == "" && element.name == "releaseDate") {
                    element.nextSibling.innerHTML=" This field is mandatory";
                    return false;
                }
                else{
                    element.nextSibling.innerHTML="*";
                }
            }
        
        function validateAll() {
            var a = document.getElementsByClassName("validateMe");
            var flag = true;
            
            for(var i=0; i<a.length; i++) {
                var element = a[i];
                flag = validate(element);
                if(flag==false)
                    break;
        }
        return flag;
    }
    </script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<!-- main Content if any -->
	<section class="py-5">
	<div class="container bg-white">
		<div class="moviecontainer">
		<div class="container">
		<jsp:include page="Message.jsp"></jsp:include>
		
		<form action="MovieServlet" method="post">
		<input type="hidden" name="process" value="addMovie">
		
		<table style="text-align: center;" class="table table-success">
		<tr>
		<th>Enter movie name </th>
		<td><input type="text" name="movieName" onblur="validate(this)" class="validateMe"><span style="color: red;"> *</span></td>
		</tr>
		
		<tr>
		<th>Enter director name </th>
		<td><input type="text" name="director" onblur="validate(this)" class="validateMe"><span style="color: red;"> *</span></td>
		</tr>
		
		<tr>
		<th>Enter producer name </th>
		<td><input type="text" name="producer" onblur="validate(this)" class="validateMe"><span style="color: red;"> *</span></td>
		</tr>
		
		<tr>
		<th>Enter cast name </th>
		<td><input type="text" name="cast" onblur="validate(this)" class="validateMe"><span style="color: red;"> *</span></td>
		</tr>
		
		<tr>
		<th>Enter movie language </th>
		<td><input type="text" name="lang" onblur="validate(this)" class="validateMe"><span style="color: red;"> *</span></td>
		</tr>
		
		<tr>
		<th>Enter release date</th>
		<td><input type="date" name="releaseDate" onblur="validate(this)" class="validateMe"><span style="color: red;"> *</span></td>
		</tr>
		
		<tr>
		<td><input type="reset" value="Clear" class="btn btn-outline-warning"></td>
		<td><input type="submit" value="Add" onclick="return validateAll()" class="btn btn-outline-success"></td>
		</tr>
		</table>
		</form>
		
		</div>
		</div>
		</div>
		</section>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>