# 📚 Bookshelf Management App Booksy

A simple JavaFX application for managing a personal virtual bookshelf. This project demonstrates core object-oriented programming (OOP) principles in Java, alongside a fully functional JavaFX GUI.

---

## 🚀 Features

- Add and remove books with metadata (Title, Author, Year, ISBN, Genre)
- Search books by:
  - Title
  - Author and Genre
  - Year Range
- Display all stored books
- Sort books alphabetically
- GUI built using **FXML**
- Icon included (`bookshelf.png`)

---

## 🧠 OOP Concepts Used

| Concept | Description |
|--------|-------------|
| **Abstract Class** | `Book` is an abstract base class for all book types |
| **Inheritance** | `FictionBook`, `NonFictionBook`, `Textbook` inherit from `Book` |
| **Method Overloading** | Multiple versions of `addBook()` and `search()` methods |
| **Method Overriding** | Subclasses override methods like `getSummary()` |
| **Polymorphism** | `List<Book>` holds various book types |
| **Further Inheritance** | e.g. `Textbook` extends `NonFictionBook` |
| **for-each Loops** | Used to iterate and display book lists |
| **Multiple Lists** | Separate lists may store all books, search results, etc. |


---

## 🧪 Educational Purpose

This project was created as part of a programming course to demonstrate:

- JavaFX GUI design
- Object-Oriented Programming
- Use of inheritance, abstraction, and polymorphism

---

## 🙋 Author

Created by Sebastian Zelaya — student project for Object-Oriented Concepts at TH Aschaffenburg.



