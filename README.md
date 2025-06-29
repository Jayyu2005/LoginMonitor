# 🔐 Java Login and Registration Simulator

This is a **Java Swing GUI application** that simulates a simple login and registration system with a lockout feature after multiple failed login attempts.

---

## 🧩 How It Works

1. **Register an Account**
   - Enter a **username** and **password**
   - Both must be at least **8 characters long**
   - The username and password **cannot be the same**

2. **Log In**
   - After registering, return to the login screen
   - If the entered credentials match, you’ll see a success screen

3. **Failed Login Lockout**
   - After **6 failed login attempts**, the **login button becomes disabled**
   - You’ll be locked out for **10 minutes**
   - A countdown message appears during the lockout

---

## 🖥️ Features

- ✅ Simple user registration and login interface
- ✅ Prevents weak usernames/passwords (under 8 characters or identical)
- ✅ Tracks login attempts
- ✅ Locks out user after too many failed tries
- ✅ Displays countdown timer and error messages in the GUI

---

## 🚀 How to Run

1. Clone or download this repo
2. Open the project in Eclipse, IntelliJ, or another Java IDE
3. Run the `frame.java` file
4. No external dependencies are required

---

## 📂 Files Included

├── frame.java # Login screen and main app
├── Register.java # Handles new user registration
├── Monitor.java # Tracks users and failed attempts
├── Login.java # Displays login success screen

yaml
Copy
Edit

---

## 🧪 Example Usage

1. Click **Register**
2. Enter:
   - Username: `exampleuser`
   - Password: `examplepass1`
3. Click **Register**
4. Go back and log in with those credentials
5. Try entering the wrong password 6 times to see the 10-minute lockout

---

## 📜 License

This project is free for learning and educational use.
