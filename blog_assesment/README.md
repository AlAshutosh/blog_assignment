
<h1>
Blog Application</h1>
This is a blog management application built with Spring Boot and MySQL. It allows users to create, update, delete, and fetch blogs, as well as generate reports based on the most frequently used words in blogs created by the user.

<h2>Features</h2>
Login: Allows users to authenticate.</br>
Create Blog: Allows users to create a new blog.</br>
Fetch Blog: Retrieves blogs associated with a user by userId.</br>
Update Blog: Updates an existing blog.</br>
Delete Blog: Deletes an existing blog by blogId.</br>
Generate Report: Generates a report with the top 5 most frequently used words from all blogs created by the user.</br>
Technologies Used </br>
Spring Boot: A Java-based framework to build and run the application.</br>
MySQL: Used to store user and blog data. </br>
Thymeleaf: Used to render HTML templates for the UI. </br>
<h2>Setup and Installation</h2></br>
Prerequisites</br>
Java 11 or higher</br>
MySQL Database</br>
Maven or Gradle</br>
1. Clone the Repository</br>
bash </br>
Copy </br>
Edit </br>
git clone https://github.com/AlAshutosh/Blog-Application.git</br>
2. Configure MySQL Database</br>
Create a new database in MySQL named blog_app.</br>
Create the necessary tables for User and Blog.</br>
You can refer to the application.properties file for connection details.</br>

3. Setup Application Properties</br>
In the src/main/resources/application.properties file, configure your database connection:</br>

properties
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/blog_app
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
4. Build and Run the Application
To build and run the Spring Boot application, execute the following commands:

bash
Copy
Edit
mvn clean install
mvn spring-boot:run
The application will start on localhost:8080.

API Endpoints
1. Login
URL: /auth/login
Method: POST
Description: Authenticates a user by username and password.
Request Body:

json
Copy
Edit
{
  "username": "your-username",
  "password": "your-password"
}
2. Create a Blog
URL: /blogs/create
Method: POST
Description: Creates a new blog.
Request Body:

json
Copy
Edit
{
  "title": "Your Blog Title",
  "body": "Your Blog Content"
}
3. Fetch a Blog by User
URL: /blogs/user/{userId}
Method: GET
Description: Retrieves all blogs for a specific user by userId.

4. Update a Blog
URL: /blogs/update/{blogId}
Method: PUT
Description: Updates an existing blog.
Request Body:

json
Copy
Edit
{
  "title": "Updated Blog Title",
  "body": "Updated Blog Content"
}
5. Delete a Blog
URL: /blogs/delete/{blogId}
Method: DELETE
Description: Deletes a blog by blogId.

6. Generate Report
URL: /report/{userId}
Method: GET
Description: Generates a report showing the top 5 most frequently used words in blogs for a specific user.

UI
The front-end for interacting with the API can be built using HTML, Thymeleaf, and JavaScript. The following pages are available for user interactions:

Login Page: Allows users to log in and authenticate.
Create Blog Page: Allows users to create new blogs.
View Blog Page: Displays all blogs for the logged-in user.
Update Blog Page: Allows users to update existing blogs.
Delete Blog Page: Allows users to delete existing blogs.
Report Page: Displays the report with the most frequent words used in the blogs.
