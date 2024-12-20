[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/vp7WYENx)
### 课程项目描述：图书管理系统

**项目名称**
BookLibrary

**项目概述**
图书管理系统是一个基于控制台的应用程序，旨在提供一个简单易用的界面来管理图书信息。系统采用面向对象的设计思想，实现了用户注册、登录、图书的增删查改等功能。

**系统设计**
系统主要分为三个层次：表示层、业务逻辑层和数据访问层。
表示层：负责与用户交互，接收用户输入，展示系统输出。
业务逻辑层：处理应用程序的核心功能，如用户验证、图书管理等。
数据访问层：负责与数据库交互，执行数据的增删查改操作。

**类的结构图**
BookManagementSystem
│
├── org.example.entity
│   ├── Book.java
│   └── User.java
│
├── org.example.service
│   ├── BookService.java
│   ├── UserService.java
│   └── BackupThread.java
│
└── org.example
└── Main.java
提示用户输入对应数字选择操作，并通过循环保持菜单的持续交互性。

### 类描述
Book：表示图书的实体类，包含图书的基本信息。
User：表示用户的实体类，包含用户的基本信息和角色。
BookService：提供图书管理的业务逻辑，如添加、删除、搜索图书。
UserService：提供用户管理的业务逻辑，如注册、登录用户。
BackupThread：负责定期备份图书数据到文件。
Main：程序的入口点，负责启动应用程序并提供用户界面。


**运行方式**
启动应用程序，系统将显示主菜单。
用户可以通过输入相应的数字来选择操作，如注册、登录、查看图书、搜索图书、添加图书（仅限管理员）、删除图书（仅限管理员）、注销和退出。
系统将根据用户的选择执行相应的操作，并在控制台上显示结果。

### 功能描述
**用户功能**
注册：新用户可以注册账户。
登录：用户可以登录系统。
注销：用户可以注销账户。

**图书功能**
查看图书：用户可以查看所有图书的列表。
搜索图书：用户可以根据书名或ISBN搜索图书。
添加图书：管理员可以添加新图书到系统。
删除图书：管理员可以从系统中删除图书。

**系统功能**
数据备份：系统定期将图书数据备份到文件，以防止数据丢失。
技术栈
编程语言：Java
数据库：MySQL
开发工具：IntelliJ IDEA, Navicat
