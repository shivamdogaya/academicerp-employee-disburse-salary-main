# Academic ERP Employee Disburse Salary

### In this project, I have implemented a small part of the entire academic ERP that is Disburse the salary of a single employee or selection of employees, modify salary details, and add an employee to the database.

In this project, I have used HTML, CSS, Bootstrap, JavaScript for the frontend and We use Hibernate(Java) as the backend and MySql as the database.

To run this project do the following.

* import `academicerp.sql` to your MySql database.

* The source code is inside the `academicerpv1` folder so open this folder in the Intellij IDEA code editor.

* Now we need to specify your MySql database `username` and `password` inside the `hibernate.cfg.xml` file. To do so go to `src->resources->hibernate.cfg.xml`. 
Inside that change following 2 lines. Instead of "bhargav" and "password" write your MySql username and password.
  ``` 
  <property name="connection.username">bhargav</property>
  <property name="connection.password">password</property>
  ```
  Now your database is configuration is done. Now the application will be able to talk to the database and store and retrieve the data from it.

* Final step is to make the run application itself. For that, you need to download `Apache Tomcat` on which we will be running our web application.

After Downloading unzip it and store it in the location of your choice(preferably in the same folder as the application is in). 


