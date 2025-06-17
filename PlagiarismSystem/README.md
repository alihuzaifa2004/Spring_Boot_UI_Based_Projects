
# 🕵️ Plagiarism Detection System (Spring Boot)

This is a **Spring Boot-based Plagiarism Detection System** project that provides a minimal web-based UI and a backend service to detect text similarity. The system follows the MVC architecture and uses RESTful endpoints to perform its operations.

---

## 📁 Project Structure

```
PlagiarismSystem/
├── .mvn/
├── .settings/
├── java/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/plagiarismscheme/
│   │   │       ├── controller/
│   │   │       │   └── PlagiarismController.java
│   │   │       ├── service/
│   │   │       │   └── PlagiarismService.java
│   │   │       └── PlagiarismSystemApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       │   └── index.html
│   │       ├── templates/
│   │       └── application.properties
├── test/
├── target/
├── pom.xml
├── mvnw / mvnw.cmd
├── .classpath / .factorypath / .project
└── .gitignore / .gitattributes
```

---

## 🚀 How It Works

- The **frontend UI** (`index.html`) resides in the `static` folder and provides a simple interface for user input.
- Users can enter two texts and submit them for similarity checking.
- The **backend logic** resides in the `service` layer (`PlagiarismService.java`) and is called via the `controller` (`PlagiarismController.java`).
- The backend returns a plagiarism score or similarity result.

---

## ✅ Features

- Lightweight HTML interface served via Spring Boot
- RESTful API for plagiarism checking
- Java-based service layer for similarity computation
- Clean separation of concerns using Controller-Service architecture
- Easily extendable to use advanced NLP libraries (e.g., cosine similarity, BERT)

---

## 🛠️ Technologies Used

- Java 17+
- Spring Boot
- Maven
- HTML/CSS (for UI)
- Spring Web

---

## ▶️ Getting Started

### Prerequisites
- Java JDK 17 or higher
- Maven

### Run the Application

1. Clone the repository:

   ```bash
   git clone <repository-url>
   ```

2. Navigate to the project directory:

   ```bash
   cd PlagiarismSystem
   ```

3. Run the application:

   ```bash
   ./mvnw spring-boot:run
   ```

4. Open your browser and go to:

   ```
   http://localhost:8080/index.html
   ```

---

## 📌 Notes

- You can enhance the plagiarism checking logic in `PlagiarismService.java`.
- This version works only for plain text comparison. File upload and processing can be added later.
- Templates folder is currently unused but ready for Thymeleaf integration if needed.

---

## 📜 License

This project is intended for educational purposes only. Feel free to modify and build upon it.
