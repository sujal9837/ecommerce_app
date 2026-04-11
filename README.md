# 🛒 Ecommerce Application (React + Spring Boot Fullstack)

A modern fullstack Ecommerce web application that allows users to browse products, manage carts, and securely place orders.

The application is built with a scalable React frontend and a secure Spring Boot backend.

---

## 🌐 Live Demo

Frontend is hosted at:
👉 [https://shopcherry.netlify.app/](https://shopcherry.netlify.app/)

---

## 🚀 Features

* 🔐 User Authentication

  * Register using email & password
  * OAuth2 login (Google)
  * JWT-based authentication

* 🛍️ Product Management

  * Browse products
  * View product details
  * Search & filter products

* 🛒 Cart System

  * Add/remove items
  * Update quantities

* 💳 Order Management

  * Secure checkout flow
  * Place and track orders

* 📱 Responsive UI

  * Works across devices

---

## 🧰 Tech Stack

### 🎨 Frontend

* TypeScript
* React
* Redux
* Tailwind CSS
* Material UI
* Bootstrap

### ⚙️ Backend

* Java 21
* Spring Boot 3.2.2
* Spring Web (REST API)
* Spring Data & Validation
* Spring Security (OAuth2, JWT, Cookies, CORS)
* MongoDB

### 🧪 DevOps & Testing

* Docker
* Testcontainers
* JUnit & Mockito

---

## 📁 Project Structure

```
├── frontend/        # React + TypeScript application
├── backend/         # Spring Boot backend
├── docker/          # Docker configuration
└── README.md
```

---

## ⚙️ Setup & Installation

### Prerequisites

* Node.js (v18+)
* Java 21
* MongoDB
* Docker (optional)

### ▶️ Frontend Setup

```bash
cd frontend
npm install
npm run dev
```

### ▶️ Backend Setup

```bash
cd backend
./mvnw spring-boot:run
```

---

## 🐳 Run with Docker

```bash
docker-compose up --build
```

---

## 🔐 Authentication & Security

* OAuth2 (Google Login)
* JWT Authentication
* Secure Cookies
* CORS Configuration

---

## 🧪 Testing

### Backend Testing

```bash
./mvnw test
```

* Unit Testing → JUnit & Mockito
* Integration Testing → Testcontainers

---

## 📌 API Overview

| Method | Endpoint       | Description       |
| ------ | -------------- | ----------------- |
| POST   | /auth/register | Register user     |
| POST   | /auth/login    | Login user        |
| GET    | /products      | Get all products  |
| GET    | /products/{id} | Get product by ID |
| POST   | /orders        | Create order      |

---

## 🌟 Future Enhancements

* Payment gateway integration
* Wishlist functionality
* Product reviews & ratings
* Admin dashboard

---

## 🤝 Contributing

Contributions are welcome! Feel free to fork and submit a pull request.

---

## 📄 License

This project is licensed under the MIT License.

---

## 👨‍💻 Author

Developed with ❤️ by Sujal verma
