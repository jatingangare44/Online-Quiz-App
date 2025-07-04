# 🧠 Java Online Quiz App (API + Gson)

This is a console-based Java Quiz Application that dynamically fetches 10 questions from the Open Trivia DB API and presents them to the user in an interactive quiz format.

---

## ✅ Features

- ✔️ Loads live questions from `https://opentdb.com/api.php?amount=10`
- ✔️ Uses Gson for parsing JSON
- ✔️ Option shuffling with correct answer mapping
- ✔️ Clean UI with emojis and progress bar
- ✔️ Calculates final score and shows performance feedback

---

## 🧰 Tools & Libraries

- Java 8 or above
- Gson (for JSON parsing)
- Eclipse IDE or any Java IDE

---

## 📦 File Structure

```
project/
├── lib/
│   └── gson-2.10.1.jar
├── src/
│   └── task8/
│       ├── QuizApp.java
│       ├── Question.java
│       └── ApiResponse.java
└── README.md
```

---

## 🔧 Setup Instructions

### 1. Clone or Download Project

If not done already, create the following structure and save the Java files in `task8` package.

### 2. Download Gson

Download `gson-2.10.1.jar` from:  
🔗 https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/

Place it inside a `lib/` folder in your project.

### 3. Add Gson to Build Path (Eclipse)

- Right-click on your project > Build Path > Configure Build Path
- Go to **Libraries** tab > Add External JARs
- Select `gson-2.10.1.jar` from the `lib/` folder
- Click Apply and Close

### 4. Compile and Run

If using terminal:

```bash
javac -cp lib/gson-2.10.1.jar src/task8/*.java
java -cp lib/gson-2.10.1.jar;src task8.QuizApp
```

(*use `:` instead of `;` on macOS/Linux*)

---

## 📸 Sample Output

```
🧠 Welcome to the Java Online Quiz App
Fetching questions from API... ✅
--------------------------------------------------

📋 Question 1 of 10
Progress: [#---------] 1/10

❓ What is the capital of Japan?
  1. Tokyo
  2. Beijing
  3. Seoul
  4. Bangkok

⏳ Your answer (1-4): 1
✅ Correct!

...

🎯 Quiz Completed!
📊 Final Score: 8 / 10
🏆 Percentage: 80%
🎉 Excellent! You're a quiz wizard!
```

---

## 🧑‍💻 Author

**Jatin Gangare**  
_Java Developer Internship Project_

---

## 📜 License

This project is for educational/demo purposes and open to extend.
