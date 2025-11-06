# Blogging Platform API

## Project Overview
The Blogging Platform App is an implementation project based on Roadmap.sh designed as a portfolio challenge using Java Spring Boot.
The goal of this project is to allow users to **Create, Retrieve, Update, and Delete** blog posts through a RESTful API.

## Tech Stack & Tools
- Java 17
-	Spring Boot Framework
-	MySQL Database
-	Maven
-	Lombok
-	Postman
-	IntelliJ IDEA

## Features
### a. Implemented
-	Create a new blog post
-	Update an existing blog post by ID
-	Delete an existing blog post by ID
-	Retrieve all blog posts or a single blog post
-	Retrieve blog posts filtered by keyword

### b. Planned (Feature Expansion)
- User system and authentication
- Advanced features: comments, likes, image uploads, etc

## API Documentation
All REST API endpoints can be accessed at the base URL:
  [http://localhost:8080/api/blog](http://localhost:8080/api/blog)

### 1. Create Blog Post
Description: Create a new blog post using the `POST` method.

**Request**
```http
POST /api/blog
Content-Type: application/json
```
```json
{
  "title": "My First Blog Post",
  "content": "This is the content of my first blog post.",
  "category": "Technology",
  "tags": ["Tech", "Programming"]
}
```

**Response**
```json
{
    "id": 1,
    "title": "My First Blog Post",
    "content": "This is the content of my first blog post.",
    "category": "Technology",
    "tags": [
        "Tech",
        "Programming"
    ],
    "createdAt": "2025-11-06T13:50:51.0042425",
    "updatedAt": "2025-11-06T13:50:51.0042425"
}
```

**Status Code**
- SUCCESS : `201 CREATED`
- ERROR	: `400 BAD REQUEST`

### 2. Update Blog Post
Description: Update an existing blog post by ID using the `PUT` method.

**Request**
```http
PUT /api/blog/1
Content-Type: application/json
```

```json
{
    "title": "My 9th Blog Post",
    "content": "Hay five",
    "category": "Fun",
    "tags": [
        "Funny",
        "Group"
    ]
}
```

**Response**
```json
{
    "id": 1,
    "title": "My 9th Blog Post",
    "content": "Hay five",
    "category": "Fun",
    "tags": [
        "Funny",
        "Group"
    ],
    "createdAt": "2025-11-06T13:50:51.004243",
    "updatedAt": "2025-11-06T13:50:51.004243"
}
```

**Status Code**
- SUCCESS : `200 OK`
- ERROR	: `400 BAD REQUEST` and `404 NOT FOUND`

### 3. Delete Blog Post
Description: Delete an existing blog post using the `DELETE` method.

**Request**
```http
DELETE /api/blog/1
Content-Type: application/json
```

**Status Code**
- SUCCESS : `204 NO CONTENT`
- ERROR	: `404 NOT FOUND`

### 4. Get Blog Post
Description: Retrieve a single blog post by ID using the  `GET` method.

**Request**
```http
GET /api/blog/1
Content-Type: application/json
```

**Response**
```json
{
    "id": 1,
    "title": "My First Blog Post",
    "content": "This is the content of my first blog post.",
    "category": "Technology",
    "tags": [
        "Tech",
        "Programming"
    ],
    "createdAt": "2025-11-04T00:20:59.712522",
    "updatedAt": "2025-11-04T00:20:59.712522"
}
```

**Status Code**
- SUCCESS : `200 OK`
- ERROR	: `404 NOT FOUND`

### 5. Get All Blog Posts
Description: Retrieve all blog posts using the `GET` method.

**Request**
```http
GET /api/blog
Content-Type: application/json
```

**Response**
```json
[
    {
        "id": 1,
        "title": "My First Blog Post",
        "content": "This is the content of my first blog post.",
        "category": "Technology",
        "tags": [
            "Tech",
            "Programming"
        ],
        "createdAt": "2025-11-04T00:20:59.712522",
        "updatedAt": "2025-11-04T00:20:59.712522"
    },
    {
        "id": 2,
        "title": "My Second Blog Post",
        "content": "This is my second blog post, can u see it?",
        "category": "Literature",
        "tags": [
            "Write",
            "Literature",
            "śāstra"
        ],
        "createdAt": "2025-11-04T00:23:57.340167",
        "updatedAt": "2025-11-04T00:23:57.340167"
    }
]
```

**Status Code**
SUCCESS : `200 OK`

### 6. Get Blog Post by Keyword
Description: Retrieve blog posts filtered by a keyword using the `GET` method.

**Request**
```http
GET /api/blog/filter?keyword=
Content-Type: application/json
```

**Response**
```json
[
    {
        "id": 1,
        "title": "My First Blog Post",
        "content": "This is the content of my first blog post.",
        "category": "Technology",
        "tags": [
            "Tech",
            "Programming"
        ],
        "createdAt": "2025-11-04T00:20:59.712522",
        "updatedAt": "2025-11-04T00:20:59.712522"
    }
]
```

**Status Code**
SUCCESS :  `200 OK`

## Setup & Installation
-	Clone this repository
-	Install dependencies using Maven
-	Configure your MySQL database
-	Run the application: `mvn spring-boot:run`
-	Test API endpoints using Postman













