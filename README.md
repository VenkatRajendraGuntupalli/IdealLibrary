# IdealLibrary: A Library Management System

**IdealLibrary** is a Spring Boot-based web application designed to manage books, users, and borrowing records efficiently. With role-based access control, secure authentication, and intuitive APIs, it provides a seamless experience for both administrators and users. Built with **MySQL**, **JPA**, and **Spring Security**, this project showcases modern and scalable web application development using **Java**.

---

## Features
- **Role-Based Access Control**: Separate privileges for admins and users.
- **Book Management**: Add, update, delete, and fetch books.
- **User Management**: Manage users with secure authentication.
- **Borrowing Records**: Track issued and returned books.
- **RESTful APIs**: Simplified interaction using Postman or other API clients.

---

## Application Flow
The application's flow is depicted below:

![IMG_5173](https://github.com/user-attachments/assets/42d4ef75-54ad-4b3d-adb2-dad3880c7bd6)



---

## REST API Testing with Postman

### 1. **Get All Available Books**
- **HTTP Method**: `GET`
- **Description**: Fetches all books available in the library.
  
![Get All Available Books](https://github.com/user-attachments/assets/00057d1c-3bfa-4ed2-94a2-ea9715d3657a)

---

### 2. **Add a New Book**
- **HTTP Method**: `POST`
- **Description**: Adds a new book to the library database.
  
![Add a New Book](https://github.com/user-attachments/assets/cd719c9f-247f-4b99-9192-2444654a2cef)

---

### 3. **Delete an Existing Book**
- **HTTP Method**: `DELETE`
- **Description**: Removes a book from the database.

![Delete a Book](https://github.com/user-attachments/assets/4fa3589a-1138-4a69-919c-7a433c94d7a1)

---

### 4. **Update an Existing Record**
- **HTTP Method**: `PUT`
- **Description**: Updates the details of an existing book.

![Update a Book](https://github.com/user-attachments/assets/1938e597-0801-40dc-a5bc-8f6871284c7c)

---

## Technologies Used
- **Spring Boot**: Backend framework.
- **MySQL**: Relational database.
- **Spring Security**: Secure authentication and authorization.
- **JPA**: For database interaction.

---

## Getting Started

### Prerequisites
1. **Java 21**
2. **MySQL**
3. **Maven**
4. **Postman** (optional, for testing APIs)

### Steps to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/IdealLibrary.git
