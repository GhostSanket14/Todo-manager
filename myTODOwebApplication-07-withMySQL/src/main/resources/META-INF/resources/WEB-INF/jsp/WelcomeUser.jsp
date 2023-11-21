	<%@ include file="common/header.jspf" %>
	<%@ include file="common/navigation.jspf" %>
<div class="container" style="max-width: 600px; margin: 50px auto; background-color: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);">
    <h2 style="color: #333; text-align: center;">Welcome to HOME .... !</h2>
    <div class="username" style="font-weight: bold; color: #555; margin-bottom: 10px;">User Name : ${User_Name}</div>
    <div class="userpass" style="font-weight: bold; color: #555; margin-bottom: 10px;">User Pass : ${User_Pass}</div>
    <a href="list-todo" style="display: block; padding: 10px; text-align: center; background-color: #007bff; color: #fff; text-decoration: none; border-radius: 4px; transition: background-color 0.3s ease;" onmouseover="this.style.backgroundColor='#0056b3'" onmouseout="this.style.backgroundColor='#007bff'">Go to TODO</a>
</div>

	<%@ include file="common/footer.jspf" %>
	</body>
</html>