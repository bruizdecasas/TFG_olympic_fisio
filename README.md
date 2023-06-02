<img width=100% alt="portadagit" src="https://github.com/bruizdecasas/TFG_olympic_fisio/assets/99440874/12348bfe-78a1-434d-8c5a-06e7b4ef601f">

<h1>Olimpyc Fisio - Physiotherapy Clinic Appointment Booking System</h1>

<h2>Welcome to the Olimpyc Fisio repository!</h2> This project is a Spring Boot application designed to facilitate appointment booking in a physiotherapy clinic called Olimpyc Fisio. With this application, patients can easily and quickly book appointments, while physiotherapists can efficiently manage scheduled appointments.

<h2>Features</h2>
<b>Appointment Booking:</b> Patients can view available time slots and book appointments based on their convenience.</br>
<b>Appointment Management:</b> Physiotherapists can view and manage scheduled appointments, mark them as completed or canceled.</br>
<b>Patient Registration: </b>New patients can register in the application by providing their basic information.</br>
<b>Patient Profiles:</b> Registered patients can access their profile, view their appointment history, and edit their personal information.</br>


<h2>Technologies Used</h2>
Java 11 </br>
Spring Boot </br>
Spring MVC</br>
Spring Data JPA</br>
MySQL (database)</br>
HTML/CSS/JavaScript</br>

<h2>Documentation</h1>
The documentation that you can find in this repository:</br>
<a href="https://github.com/bruizdecasas/TFG_olympic_fisio/blob/main/Grupo06_Memoria_OlympycFisio.pdf">Memorandum</a></br>
<a href="https://github.com/bruizdecasas/TFG_olympic_fisio/blob/main/Manual%20de%20usuario.pptx">Manual</a></br>
<a href="https://github.com/bruizdecasas/TFG_olympic_fisio/blob/main/demoOlympicFisio.mp4"> Instructional video</a></br>
<a href="https://github.com/bruizdecasas/TFG_olympic_fisio/blob/main/OlympicFisioBBDD.sql">BBDD Script</a></br>
<a href="https://github.com/bruizdecasas/TFG_olympic_fisio/blob/main/Grupo06_Memoria_OlympycFisio.pdf">Project Report</a></br>

<h2>Project Setup</h2>

Follow these steps to set up the project in your development environment:
1. Clone the repository to your local machine or download it as a ZIP file.</br>
2. Make sure you have Java 11 and MySQL installed on your system.</br>
3. Create a MySQL database named olimpyc_fisio (or any other name you prefer) on your local server.</br>
4. Configure the database credentials in the application.properties file located in the src/main/resources folder. Update the spring.datasource.url, spring.datasource.username, and spring.datasource.password properties according to your MySQL configuration. </br>
5. Open a terminal and navigate to the root folder of the project. </br>
6. Run the following command to compile and run the application:

./mvnw spring-boot:run

7. Troubleshooting Project Download Issues
If you encounter an error when downloading the project for the first time, you may need to follow these steps to resolve it:

  a. Open the `application.properties` configuration file.</br>
  b. Look for the `spring.jpa.generate-ddl` property and temporarily set it to `true`.</br>
  c. Run the project and allow Spring to automatically generate the database schema.</br>
  d. Once the database is properly configured, remember to revert the `spring.jpa.generate-ddl` property back to `false` or its original value.


8. The application will be available at http://localhost:8088. Open your browser and access that address to see it in action. </br>

<h2>Contribution</h2>
If you wish to contribute to this project, you are welcome to do so! You can make improvements, bug fixes, or add new features. Follow these steps:</br>
1. Fork this repository.</br>
2. Create a branch with a descriptive name for your contribution.</br>
3. Make your changes in that branch.</br>
4. Submit a pull request describing your changes and the improvements they bring.</br>

<h2>License</h2>
This project is distributed under the MIT license. Feel free to use it for your own purposes or modify it as needed.

<h2>Contact</h2>
If you have any questions or inquiries related to this project, feel free to contact us. 
