Secret Santa Game (Maven Project)

Project Overview:

This project automates the Secret Santa assignment process for employees while ensuring:
•	No employee assigns themselves.
•	No employee is assigned the same recipient as last year.
•	Each employee is assigned exactly one secret child.
The system reads employee data from a CSV file and generates new Secret Santa pairings, ensuring fairness and uniqueness.
________________________________________
📂 Project Structure
SecretSantaGame/
│── src/main/java/com/secretsanta/
│   ├── controller/SecretSantaController.java
│   ├── service/SecretSantaService.java
│   ├── repository/CSVHandler.java
│   ├── model/Employee.java
│   ├── exception/SantaAssignmentException.java
│   ├── SecretSantaApplication.java
│── src/test/java/com/secretsanta/service/SecretSantaServiceTest.java
│── src/main/resources/employees.csv
│── src/main/resources/last_year.csv
│── pom.xml
│── README.md
________________________________________
🚀 Installation Guide
1️)Prerequisites
•	Java 17+ (Ensure JDK 17 is installed)
•	Maven 3+ (Check with mvn -version)
•	Git (for version control)
2️)Clone the Repository
git clone https://github.com/YOUR_USERNAME/SecretSantaGame.git
cd SecretSantaGame
3️) Build the Project
Run the following command in the root directory:
mvn clean install
This will download dependencies and compile the project.
________________________________________
▶️ Running the Application
Run using Maven
mvn spring-boot:run
Run as a JAR File
java -jar target/SecretSantaGame-1.0-SNAPSHOT.jar
________________________________________
🛠 How It Works
1.	Reads employee data from employees.csv.
2.	Reads last year's assignments from last_year.csv to avoid repetition.
3.	Assigns Secret Santa pairs following the given constraints.
4.	Generates a new CSV file (secret_santa_output.csv) with the assignments.
API Endpoint (Optional)
The application exposes an endpoint:
GET /secretsanta/assign
This triggers the Secret Santa assignment and generates the output file.
________________________________________

🧪 Running Tests
Execute the test cases using:
mvn test
This will run JUnit tests to verify the correctness of the assignments.
________________________________________
📜 Output Format (secret_santa_output.csv)
Employee_Name	Employee_EmailID	Secret_Child_Name	Secret_Child_EmailID
John Doe	john@acme.com
Jane Smith	jane@acme.com

Jane Smith	jane@acme.com
Bob Williams	bob@acme.com

________________________________________

