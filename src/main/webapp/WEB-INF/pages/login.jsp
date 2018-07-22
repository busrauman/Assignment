<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<%@include file="../include/includeCssFiles.jsp"%>
<%@include file="../include/includeJsFiles.jsp"%>

<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #eee;
}

.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>
</head>
<body>
	<div class="container">
		<c:if test="${! empty error }">
			<div class="alert alert-danger" role="alert">
				${error }
			</div>
		</c:if>
		<c:if test="${! empty register }">
			<div class="alert alert-success" role="alert">
				<fmt:message key="register.succsess" />
			</div>
		</c:if>

		<form class="form-signin" action="./j_spring_security_check"
			method="post">
			<h2 class="form-signin-heading">
				<fmt:message key="title.login" />
			</h2>
			<label for="inputEmail" class="sr-only">Email address</label> <input
				type="input" id="inputEmail" class="form-control"
				placeholder="Username" name="username" required> <label
				for="inputPassword" class="sr-only">Password</label> <input
				type="password" id="inputPassword" class="form-control"
				placeholder="Password" name="password" required> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<button class="btn btn-lg btn-primary btn-block" type="submit">
				<fmt:message key="button.login.submit" />
			</button>
			<a href="register" class="btn  btn-default btn-block"><fmt:message
					key="button.register" /></a>

		</form>

	</div>
	<!-- /container -->

</body>
</html>