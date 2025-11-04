# BlogAPI
Blogging Platform API
DESCRIPTION: This is a RESTful API for a blogging platform that allows users to create, read, update, and delete blog posts. The API is built using Spring Boot and Java, with MySQL as the database and JPA/Hibernate for database access.
PROJECT TYPE: RESTFUL API
PROJECT GITHUB: https://github.com/banksolo2/BlogAPI
PROJECT URL:  https://roadmap.sh/projects/blogging-platform-api
FRAMEWORK: SPRING BOOT
LANGUAGE: JAVA
DATABASE: MYSQL
DATABASE NAME: blog_db
DATABASE ACCESS: JPA / HIBERNATE
BUILD TOOL: MAVEN
AUTHOR: Oluwaseun Joseph Olotu
VERSION: 1.0.0
AUTHOR EMAIL: seunolo2@gmail.com
AUTHOR GITHUB: https://github.com/banksolo2
AUTHOR WEBSITE: https://seun-olo2.web.app/

END_POINTS:

1.Create Blog Post
GET /posts
INPUT:
    {
    "title": "My First Blog Post",
    "content": "This is the content of my first blog post.",
    "category": "Technology",
    "tags": ["Tech", "Programming"]
    }
output:
   {
   "id": 1,
   "title": "My First Blog Post",
   "content": "This is the content of my first blog post.",
   "category": "Technology",
   "tags": ["Tech", "Programming"],
   "createdAt": "2021-09-01T12:00:00Z",
   "updatedAt": "2021-09-01T12:00:00Z"
   }
status: 201 created, 400 bad request

2.Update Blog Post
PUT /posts/{id}
INPUT:
    {
    "title": "My Updated Blog Post",
    "content": "This is the updated content of my first blog post.",
    "category": "Technology",
    "tags": ["Tech", "Programming"]
    }
OUTPUT:
   {
   "id": 1,
   "title": "My Updated Blog Post",
   "content": "This is the updated content of my first blog post.",
   "category": "Technology",
   "tags": ["Tech", "Programming"],
   "createdAt": "2021-09-01T12:00:00Z",
   "updatedAt": "2021-09-02T15:30:00Z"
   }
status: 200 ok, 400 bad request, 404 not found

3.Delete Blog Post
DELETE /posts/{id}
STATUS: 204 no content, 404 not found

4.Get Blog Post
GET /posts/{id}
OUTPUT:
    {
    "id": 1,
    "title": "My First Blog Post",
    "content": "This is the content of my first blog post.",
    "category": "Technology",
    "tags": ["Tech", "Programming"],
    "createdAt": "2021-09-01T12:00:00Z",
    "updatedAt": "2021-09-01T12:00:00Z"
    }
STATUS: 200 ok, 404 not found

5.Get All Blog Posts
GET /posts
OUTPUT:
    [
        {
        "id": 1,
        "title": "My First Blog Post",
        "content": "This is the content of my first blog post.",
        "category": "Technology",
        "tags": ["Tech", "Programming"],
        "createdAt": "2021-09-01T12:00:00Z",
        "updatedAt": "2021-09-01T12:00:00Z"
        },
        {
        "id": 2,
        "title": "My Second Blog Post",
        "content": "This is the content of my second blog post.",
        "category": "Technology",
        "tags": ["Tech", "Programming"],
        "createdAt": "2021-09-01T12:30:00Z",
        "updatedAt": "2021-09-01T12:30:00Z"
        }
    ]
STATUS: 200 ok

6.Get Blog Posts by title, content, or category
GET /posts/filter?term=tech
OUTPUT:
    [
        {
        "id": 1,
        "title": "My First Blog Post",
        "content": "This is the content of my first blog post.",
        "category": "Technology",
        "tags": ["Tech", "Programming"],
        "createdAt": "2021-09-01T12:00:00Z",
        "updatedAt": "2021-09-01T12:00:00Z"
        },
        {
        "id": 2,
        "title": "My Second Blog Post",
        "content": "This is the content of my second blog post.",
        "category": "Technology",
        "tags": ["Tech", "Programming"],
        "createdAt": "2021-09-01T12:30:00Z",
        "updatedAt": "2021-09-01T12:30:00Z"
        }
    ]
STATUS: 200 ok
