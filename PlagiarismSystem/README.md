
# 🕵️ Plagiarism Detection System (Spring Boot)

This is a **Spring Boot-based Plagiarism Detection System** project that provides a minimal web-based UI and a backend service to detect text similarity. The system follows the MVC architecture and uses RESTful endpoints to perform its operations.


---

## 🧠 Features

- 📄 Accepts **PDF** and **DOCX** files for comparison.
- 📊 Calculates **plagiarism percentage** between two documents.
- 🔍 Highlights **plagiarized sections** in the output.
- 🌐 Simple web interface using **Spring Boot with Thymeleaf**.
- 💡 Modular structure with controller, service, and utility layers.

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

## 🧪 How It Works

1. User uploads two documents (PDF or DOCX).
2. The backend reads and extracts text using Apache POI or PDFBox.
3. The text is compared using a **string similarity algorithm** (e.g., cosine similarity, Jaccard, Levenshtein, etc.).
4. The percentage of similarity is calculated.
5. The highlighted plagiarized text is displayed in the UI.

---

## 📦 Dependencies

* Spring Boot Web
* Apache POI (for `.docx`)
* PDFBox (for `.pdf`)
* Thymeleaf (UI)
* Lombok (optional)
* Any text comparison or NLP library

---


## 👨‍🎓 Author

**Ali Huzaifa Nadeem**  
[GitHub Profile](https://github.com/alihuzaifa2004)


## 📜 License

This project is for **educational purposes** only.
