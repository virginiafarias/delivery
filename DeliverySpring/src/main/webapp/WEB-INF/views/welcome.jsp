<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html lang="en">

<jsp:include page="fragments/headTag.jsp"/>
<link href="<c:url value="/resources/css/npi.css" />" rel="stylesheet" />

<body>
<div class="container">
    <jsp:include page="fragments/bodyHeader.jsp"/>

	<div id="conteudo" style="text-align: center; margin-top: 100px;">
	
		<div id="login" style="width: 300px; margin: 0 auto;">
			
			<form action="" id="login-form" method="POST">
				<div class="form-group">
					<label class="col-sm-2 control-label">Email:</label>
					<input type="text" name="email" class="form-control"/>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">Senha:</label>
					<input type="password" name="senha" class="form-control"/>
				</div>
				
				<button type="button" class="btn btn-info">Entrar</button>
				
			</form>
		</div>
		
	    <div style="margin-top: 100px;">
	    	<jsp:include page="fragments/footer.jsp"/>
	   	</div>
	
	</div>


</div>
</body>

</html>