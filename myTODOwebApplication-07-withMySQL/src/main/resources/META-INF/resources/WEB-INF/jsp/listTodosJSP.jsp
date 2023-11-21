<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %> <!-- We are now using the same navigation bar -->

<div class="container" style="background-color: #58b7ed; padding: 20px; border-radius: 5px;"> <!-- Updated styling to match the navigation bar -->
    <div><h3 style="color: black;">Your TODO's are</h3></div>

    <table class="table table-hover"> <!-- tables class from BS helps to make the table look a little better -->
        <thead>
            <tr>
                <!-- <th>id</th> (I have commented ID from here) -->
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
                    <!-- <td>${toodoo.id}</td> (I have commented ID from here) -->
                    <td>${toodoo.description}</td>
                    <td>${toodoo.date}</td>
                    <td>${toodoo.doneOrNot}</td>
                    <td> <a href="delete-todo?id=${toodoo.id}" class="btn btn-warning">Delete </a></td>
                    <!-- As this is a loop, I can use id to assign to delete to be deleted. -->
                    <td> <a href="update-todo?id=${toodoo.id}" class="btn btn-primary">Update </a></td>
                </tr>
                <!-- Above see, we can pass values via URL, just like we did from the browser -->
            </c:forEach>
        </tbody>
    </table>
    <a href="add-todo" class="btn btn-success">Add Todo</a> <!-- btn is BS class to make Good looking buttons -->
</div>

<%@ include file="common/footer.jspf" %>
</body>
</html>
