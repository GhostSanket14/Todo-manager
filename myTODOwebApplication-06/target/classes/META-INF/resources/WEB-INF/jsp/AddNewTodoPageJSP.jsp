
	<%@ include file="common/header.jspf" %>
	<%@ include file="common/navigation.jspf" %>
		
	<div class="container"> <!-- Now we are using bootstrap classes -->
		<h3>Enter TODO details</h3>
		
		<form:form method="post" modelAttribute="Todo"> <!-- we bind our bean to this form using model attribute -->
		<fieldset class="mb-4">
			<form:label path="description">Description</form:label>
			<form:input type="text" path="description" required="required" /> <!-- TO make input compulsory, make it required -->
			<!-- Above we marked input to variable description in modelAttribute Todo -->					 
			<form:errors path="description" cssClass="text-warning"/> <!-- This is error tag for above input -->		
			<!-- ABOVE 3 belong to description filed ie. path -->
		</fieldset>
		
			<fieldset class="mb-4">
			<form:label path="date">Date</form:label>
			<form:input type="text" path="date" required="required" />			 
			<form:errors path="date" cssClass="text-warning"/> <!-- remember path name must be same as variable name in todo calss/bean -->		
		</fieldset>	<!-- Basically we mapped a field from todo bean to here.  -->
		
			<input type="submit" class="btn btn-success"/>
		
		
			<form:input type="hidden" path="id"/> <!-- We are adding these to get rid or null input error. -->
			<form:input type="hidden" path="doneOrNot"/>
		</form:form>
		
	</div>
	
	<%@include file="common/footer.jspf" %>
	
	<script type="text/javascript"> 	 // Here the date is name of table from above. We attach this frame work to out date field above.
	$('#date').datepicker({
	    format: 'yyyy-mm-dd',
	    startDate: '-3d'
	});
	</script>	
	</body>
</html>