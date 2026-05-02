# 🛒 E-Commerce Platform

<div align="center">

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2.x-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-6.x-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white)
![React](https://img.shields.io/badge/React-18.x-61DAFB?style=for-the-badge&logo=react&logoColor=black)
![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-Auth-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

A full-stack **E-Commerce Platform** built with **Spring Boot** (REST API + JWT Auth) and **React** (Frontend), featuring product listings, cart management, order processing, and an admin dashboard.

**[🚀 Live Demo](https://shopcherry.netlify.app/)** &nbsp;|&nbsp; **[📂 Backend Repo](https://github.com/yourusername/ecommerce-backend)** &nbsp;|&nbsp; **[📂 Frontend Repo](https://github.com/yourusername/ecommerce-frontend)**

![App Screenshot](https://via.placeholder.com/900x450.png?text=E-Commerce+Platform+Screenshot)

</div>

---

## 📋 Table of Contents

- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [System Architecture](#-system-architecture)
- [Project Structure](#-project-structure)
- [Getting Started](#-getting-started)
  - [Prerequisites](#prerequisites)
  - [Backend Setup](#backend-setup)
  - [Frontend Setup](#frontend-setup)
- [API Endpoints](#-api-endpoints)
- [Environment Variables](#-environment-variables)
- [Screenshots](#-screenshots)
- [Contributing](#-contributing)
- [License](#-license)

---

## ✨ Features

### 🛍️ Customer Features
- 🔐 **User Registration & Login** with JWT-based authentication
- 🏠 **Homepage** with featured products and categories
- 🔍 **Search & Filter** products by name, category, price range
- 📦 **Product Detail Page** with images, description, reviews & ratings
- 🛒 **Shopping Cart** — add, update quantity, remove items
- 💳 **Checkout Flow** with address and payment selection
- 📬 **Order Tracking** — view order history and status
- ❤️ **Wishlist** — save products for later

### 🛠️ Admin Features
- 📊 **Admin Dashboard** with sales analytics and stats
- 📋 **Product Management** — add, edit, delete products with image upload
- 📂 **Category Management** — create and manage product categories
- 👥 **User Management** — view and manage registered users
- 📦 **Order Management** — update order status (Pending → Shipped → Delivered)
- 📈 **Sales Reports** — revenue charts and best-selling products

### ⚙️ Technical Features
- 🔒 **JWT Authentication** with role-based access (ADMIN / USER)
- 📸 **Image Upload** for product photos (stored locally or via cloud)
- 🌐 **CORS configured** for frontend-backend communication
- ✅ **Input Validation** using Bean Validation (JSR-380)
- ⚠️ **Global Exception Handling** with proper HTTP error responses
- 📄 **Pagination & Sorting** on product listings and orders

---

## 🛠 Tech Stack

### Backend
| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 17 | Core language |
| Spring Boot | 3.2.x | Application framework |
| Spring Security | 6.x | Authentication & authorization |
| Spring Data JPA | 3.2.x | ORM & database abstraction |
| Spring Web | 3.2.x | REST API |
| JSON Web Token (JWT) | 0.11.x | Stateless auth tokens |
| MySQL | 8.0 | Relational database |
| Lombok | Latest | Boilerplate reduction |
| ModelMapper | 3.x | DTO ↔ Entity mapping |
| Maven | 3.9+ | Dependency management |

### Frontend
| Technology | Version | Purpose |
|------------|---------|---------|
| React | 18.x | UI library |
| React Router DOM | 6.x | Client-side routing |
| Redux Toolkit | 1.x | Global state management (cart, auth) |
| Axios | 1.x | HTTP client with interceptors |
| Bootstrap / Tailwind CSS | 5.x / 3.x | Styling & layout |
| React Toastify | Latest | Notifications |
| React Hook Form | 7.x | Form management & validation |

---

## 🏗 System Architecture

```
┌─────────────────────────────────────────────────────────┐
│                      React Frontend                     │
│         (Vite + React 18 + Redux + Axios)               │
└──────────────────────────┬──────────────────────────────┘
                           │  HTTP / REST (JSON)
                           │  Authorization: Bearer <JWT>
┌──────────────────────────▼──────────────────────────────┐
│                  Spring Boot Backend                    │
│  ┌────────────┐  ┌──────────────┐  ┌─────────────────┐ │
│  │ Controller │→ │   Service    │→ │   Repository    │ │
│  │  (REST)    │  │ (Business)   │  │  (Spring JPA)   │ │
│  └────────────┘  └──────────────┘  └────────┬────────┘ │
│  ┌──────────────────────────────┐            │          │
│  │  Spring Security + JWT Filter│            │          │
│  └──────────────────────────────┘            │          │
└──────────────────────────────────────────────┼──────────┘
                                               │
                              ┌────────────────▼──────────┐
                              │        MySQL Database      │
                              │  users | products | orders │
                              │  categories | cart | reviews│
                              └───────────────────────────┘
```

---

## 📁 Project Structure

```
ecommerce-springboot-react/
│
├── ecommerce-backend/                        # Spring Boot Backend
│   ├── src/main/java/com/ecommerce/
│   │   ├── controller/
│   │   │   ├── AuthController.java           # Register / Login
│   │   │   ├── ProductController.java        # Product CRUD
│   │   │   ├── CategoryController.java       # Category CRUD
│   │   │   ├── CartController.java           # Cart operations
│   │   │   ├── OrderController.java          # Order processing
│   │   │   ├── ReviewController.java         # Product reviews
│   │   │   └── AdminController.java          # Admin dashboard APIs
│   │   ├── service/
│   │   │   ├── AuthService.java
│   │   │   ├── ProductService.java
│   │   │   ├── CartService.java
│   │   │   ├── OrderService.java
│   │   │   └── impl/                         # Service implementations
│   │   ├── repository/
│   │   │   ├── UserRepository.java
│   │   │   ├── ProductRepository.java
│   │   │   ├── OrderRepository.java
│   │   │   └── CartRepository.java
│   │   ├── model/
│   │   │   ├── User.java
│   │   │   ├── Product.java
│   │   │   ├── Category.java
│   │   │   ├── Cart.java
│   │   │   ├── CartItem.java
│   │   │   ├── Order.java
│   │   │   ├── OrderItem.java
│   │   │   └── Review.java
│   │   ├── dto/
│   │   │   ├── request/
│   │   │   │   ├── LoginRequest.java
│   │   │   │   ├── RegisterRequest.java
│   │   │   │   └── ProductRequest.java
│   │   │   └── response/
│   │   │       ├── JwtResponse.java
│   │   │       ├── ProductResponse.java
│   │   │       └── OrderResponse.java
│   │   ├── security/
│   │   │   ├── JwtTokenProvider.java
│   │   │   ├── JwtAuthFilter.java
│   │   │   └── SecurityConfig.java
│   │   ├── exception/
│   │   │   ├── ResourceNotFoundException.java
│   │   │   ├── UnauthorizedException.java
│   │   │   └── GlobalExceptionHandler.java
│   │   └── EcommerceApplication.java
│   └── src/main/resources/
│       └── application.properties
│
└── ecommerce-frontend/                       # React Frontend
    ├── public/
    └── src/
        ├── components/
        │   ├── Navbar.jsx
        │   ├── Footer.jsx
        │   ├── ProductCard.jsx
        │   ├── CartItem.jsx
        │   └── ProtectedRoute.jsx
        ├── pages/
        │   ├── Home.jsx
        │   ├── ProductList.jsx
        │   ├── ProductDetail.jsx
        │   ├── Cart.jsx
        │   ├── Checkout.jsx
        │   ├── OrderHistory.jsx
        │   ├── Login.jsx
        │   ├── Register.jsx
        │   └── admin/
        │       ├── Dashboard.jsx
        │       ├── ManageProducts.jsx
        │       ├── ManageOrders.jsx
        │       └── ManageUsers.jsx
        ├── redux/
        │   ├── store.js
        │   ├── authSlice.js
        │   └── cartSlice.js
        ├── services/
        │   ├── api.js                        # Axios instance with JWT interceptor
        │   ├── authService.js
        │   ├── productService.js
        │   └── orderService.js
        ├── App.jsx
        └── main.jsx
```

---

## 🚀 Getting Started

### Prerequisites

Ensure the following are installed:

- [Java 17+](https://adoptium.net/)
- [Maven 3.9+](https://maven.apache.org/)
- [Node.js 18+](https://nodejs.org/)
- [MySQL 8.0+](https://www.mysql.com/)
- [Git](https://git-scm.com/)

---

### Backend Setup

**1. Clone the repository**

```bash
git clone https://github.com/yourusername/ecommerce-springboot-react.git
cd ecommerce-springboot-react/ecommerce-backend
```

**2. Create the MySQL database**

```sql
CREATE DATABASE ecommerce_db;
```

**3. Configure `application.properties`**

```properties
# Database
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

# JWT
app.jwt.secret=your_super_secret_jwt_key_min_32_characters
app.jwt.expiration-ms=86400000

# File Upload
spring.servlet.multipart.max-file-size=5MB
spring.servlet.multipart.max-request-size=10MB
file.upload-dir=uploads/

# Server
server.port=8080
```

**4. Build and run**

```bash
mvn clean install
mvn spring-boot:run
```

Backend runs at: `http://localhost:8080`

---

### Frontend Setup

**1. Navigate to frontend directory**

```bash
cd ../ecommerce-frontend
```

**2. Install dependencies**

```bash
npm install
```

**3. Create `.env` file**

```env
VITE_API_BASE_URL=http://localhost:8080/api
```

**4. Start the development server**

```bash
npm run dev
```

Frontend runs at: `http://localhost:5173`

---

## 📡 API Endpoints

Base URL: `http://localhost:8080/api`

### 🔐 Auth
| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| `POST` | `/auth/register` | Register new user | Public |
| `POST` | `/auth/login` | Login and get JWT token | Public |

### 📦 Products
| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| `GET` | `/products` | Get all products (paginated) | Public |
| `GET` | `/products/{id}` | Get product by ID | Public |
| `GET` | `/products/search?q=keyword` | Search products | Public |
| `GET` | `/products/category/{id}` | Products by category | Public |
| `POST` | `/products` | Create product | Admin |
| `PUT` | `/products/{id}` | Update product | Admin |
| `DELETE` | `/products/{id}` | Delete product | Admin |

### 🛒 Cart
| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| `GET` | `/cart` | Get current user's cart | User |
| `POST` | `/cart/add` | Add item to cart | User |
| `PUT` | `/cart/update/{itemId}` | Update item quantity | User |
| `DELETE` | `/cart/remove/{itemId}` | Remove item from cart | User |

### 📬 Orders
| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| `POST` | `/orders` | Place a new order | User |
| `GET` | `/orders/my-orders` | Get logged-in user's orders | User |
| `GET` | `/orders/{id}` | Get order details | User |
| `GET` | `/orders` | Get all orders | Admin |
| `PUT` | `/orders/{id}/status` | Update order status | Admin |

### ⭐ Reviews
| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| `GET` | `/reviews/product/{id}` | Get reviews for a product | Public |
| `POST` | `/reviews` | Submit a review | User |
| `DELETE` | `/reviews/{id}` | Delete a review | Admin |

---

### Sample Request — Login

```http
POST /api/auth/login
Content-Type: application/json

{
  "email": "user@example.com",
  "password": "password123"
}
```

### Sample Response

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "type": "Bearer",
  "id": 1,
  "email": "user@example.com",
  "roles": ["ROLE_USER"]
}
```

---

## 🔑 Environment Variables

| Variable | Description | Default |
|----------|-------------|---------|
| `spring.datasource.url` | MySQL connection URL | `jdbc:mysql://localhost:3306/ecommerce_db` |
| `spring.datasource.username` | MySQL username | — |
| `spring.datasource.password` | MySQL password | — |
| `app.jwt.secret` | JWT signing secret (32+ chars) | — |
| `app.jwt.expiration-ms` | JWT expiry in milliseconds | `86400000` (1 day) |
| `VITE_API_BASE_URL` | Frontend API base URL | `http://localhost:8080/api` |

---

## 🖼 Screenshots

| Page | Preview |
|------|---------|
| 🏠 Home / Product Listing | ![Home](https://via.placeholder.com/700x350.png?text=Home+Page) |
| 📦 Product Detail | ![Detail](https://via.placeholder.com/700x350.png?text=Product+Detail+Page) |
| 🛒 Shopping Cart | ![Cart](https://via.placeholder.com/700x350.png?text=Shopping+Cart) |
| 💳 Checkout | ![Checkout](https://via.placeholder.com/700x350.png?text=Checkout+Page) |
| 📊 Admin Dashboard | ![Admin](https://via.placeholder.com/700x350.png?text=Admin+Dashboard) |
| 🔐 Login / Register | ![Auth](https://via.placeholder.com/700x350.png?text=Login+Page) |

---

## 🤝 Contributing

Contributions are welcome! Here's how:

1. **Fork** the repository
2. **Create** your branch: `git checkout -b feature/your-feature`
3. **Commit** your changes: `git commit -m 'feat: add some feature'`
4. **Push** to your branch: `git push origin feature/your-feature`
5. **Open** a Pull Request

Please make sure to write clean code and add tests where applicable.

---

## 📄 License

This project is licensed under the **MIT License** — see the [LICENSE](LICENSE) file for details.

---

<div align="center">

Made with ❤️ using Spring Boot & React

⭐ **Star this repo if you found it helpful!**

</div>
