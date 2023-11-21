<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container" style="background-color: #58b7ed; padding: 100px; border-radius: 5px;"> <!-- Updated styling to match the navigation bar -->
    <h3 style="color: black;">Enter TODO details</h3>

    <form:form method="post" modelAttribute="TodoModAt" class="text-white"> <!-- Updated text color to white -->

        <fieldset class="mb-4">
            <form:label path="description">Description</form:label>
            <form:input type="text" path="description" required="required" class="form-control" />
            <form:errors path="description" cssClass="text-warning" />
        </fieldset>

        <fieldset class="mb-4">
            <form:label path="date">Date</form:label>
            <form:input type="text" path="date" required="required" class="form-control" />
            <form:errors path="date" cssClass="text-warning" />
        </fieldset>

        <input type="submit" class="btn btn-success" />

        <form:input type="hidden" path="id" />
        <form:input type="hidden" path="doneOrNot" />
    </form:form>

</div>

<%@ include file="common/footer.jspf" %>

<script type="text/javascript">
    $('#date').datepicker({
        format: 'yyyy-mm-dd',
        startDate: '-3d'
    });
</script>
</body>
</html>
