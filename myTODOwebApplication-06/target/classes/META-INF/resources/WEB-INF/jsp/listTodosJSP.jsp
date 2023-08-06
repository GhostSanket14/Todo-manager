
	<%@ include file="common/header.jspf" %>
	<%@ include file="common/navigation.jspf" %> <!-- We are now using same navigation bar -->
	
	<div class="container"> <!-- Now we are using bootstrap classes -->
		<div><h3>Your TODO's are</h3></div>
			
		<table class="table table-hover"> 	<!-- tables class from BS help to make table look a little better -->
		<thead>
			<tr>
	<!-- 		<th>id</th>  (I have commented ID from here)  -->
 				<th>Description</th>
				<th>Date</th>
				<th>Done or Not</th>
				<th>Delete todo</th>
				<th>Update todo</th>	
				<th></th>
			</tr>
		</thead>
			<tbody>
				<c:forEach items="${Todos}" var="toodoo">
				<tr>
	<!--		<td>${toodoo.id}</td> (I have commented ID from here)  -->
					<td>${toodoo.description}</td>
					<td>${toodoo.date}</td>
					<td>${toodoo.doneOrNot}</td>
					<td> <a href="delete-todo?id=${toodoo.id}" class="btn btn-warning">Delete </a></td> <!-- As this is loop i can use id to assign to delete to be deleted. -->
					<td> <a href="update-todo?id=${toodoo.id}" class="btn btn-primary">Update </a></td>
				</tr>		<!-- Above see, we can pass values vis URL, just like we did from browser -->
				</c:forEach>
			</tbody>
		</table>
		<a href="add-todo" class="btn btn-success">Add Todo</a> <!-- btn is BS class to make Good looking buttons -->
	</div>
	<%@include file="common/footer.jspf" %>
</body>
</html>