# todo-weApp
This is a ToDo-Management application.
It is built using, 
1. SpringBoot-3 as backend.
2. JSP (Bootstrap) as front-end.
3. MySQL-8 as database via docker image.

   
# Steps
1. Import this as "Existing Maven project" in Eclipse.
2. Click Update Maven project.
3. Make sure you have installed Docker in your system, then run this command in CMD.
     [] Command to make a docker image with properties
docker run --detach    // THis will run the Docker.
--env MYSQL_ROOT_PASSWORD=dummypassword  // We will set the password for our image
--env MYSQL_USER=todos-user  // we will create a user with this name
--env MYSQL_PASSWORD=dummytodos  // we will create a password for MySQL within image. (mostly keep both passwords same)
--env MYSQL_DATABASE=todos  // we will make database with this name
--name mysql 
--publish 6603:3306 // use this port
mysql:8-oracle // use this version.

4. Then just hit the URL: localhost:8080
5. User is: Ghost Password is: 123
# Here are screenshots of the project.
![SS1](https://github.com/GhostSanket14/todo-webApp/assets/99405599/ab48e338-81ed-41f3-9fa8-528ecaa18b39)
![SS2](https://github.com/GhostSanket14/todo-webApp/assets/99405599/ad554ad3-221d-4a0c-9275-eefa635622a7)
![SS3](https://github.com/GhostSanket14/todo-webApp/assets/99405599/b905fef0-afb5-407b-a0d6-5ac3545424b4)
![SS4](https://github.com/GhostSanket14/todo-webApp/assets/99405599/0957e71c-449d-48f8-a5a0-2f4de1a99d15)
