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

<script type="text/javascript">
$(document).ready(function() {
});
</script>
</head>
<body>
	<div class="container">
		<h4 class="well"><fmt:message key="label.profile"/></h4>
		<div class="col-lg-12 well">
		<div class="pull-right"> <a href="logout" > Logout</a></div>
			<div class="row">
				<h6>Your Username :${user.username }</h6>
				<p>Your Email :${user.email }</p>
			</div>
		</div>
	</div>
</body>
</html>