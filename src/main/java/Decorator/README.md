# Decorator Bubble Tea Customization
**Description**: This package implements the Decorator pattern to build customizable Bubble Tea drinks by dynamically adding ingredients and accumulating cost/description without creating a subclass per combination.

## 📌 Exercise Statement

Implement a Bubble Tea customization system using the **Decorator pattern**.

The goal is to start from a base drink and add ingredients (ice, sugar, tapioca, flavors) at runtime. Each decorator must update both:

- the final description of the drink
- the final price

This design allows flexible composition and avoids class explosion from all possible drink combinations.

## ✨ Features

- `BubbleTea` contract with `getDescription()` and `getCost()`.
- Base drinks with fixed starting cost:
  - `LatteBase` -> `3.50`
  - `MatchaBase` -> `3.20`
  - `TeaBase` -> `3.00`
- Concrete decorators with additive cost:
  - `IceDecorator` -> `+0.25`
  - `SugarDecorator` -> `+0.30`
  - `TapiocaDecorator` -> `+0.50`
  - `FlavorDecorator` -> `+0.60` per flavor
- Dynamic composition support (including multiple stacked flavors).
- Unit tests for bases, individual decorators, and combined scenarios.

## 🗂 Project Structure

```text
S3.03-Patterns2/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── Decorator/
│   │           ├── App.java
│   │           ├── BubbleTeaDecorator.java
│   │           ├── README.md
│   │           ├── Interface/
│   │           │   └── BubbleTea.java
│   │           ├── Bases/
│   │           │   ├── LatteBase.java
│   │           │   ├── MatchaBase.java
│   │           │   └── TeaBase.java
│   │           └── Decorators/
│   │               ├── IceDecorator.java
│   │               ├── SugarDecorator.java
│   │               ├── TapiocaDecorator.java
│   │               └── FlavorDecorator.java
│   └── test/
│       └── java/
│           └── Decorator/
│               ├── BubbleTeaBasesTest.java
│               └── BubbleTeaDecoratorsTest.java
└── README.md
```

## 🧾 Class Overview

- `App`: console entry point showing a full composition example.
- `BubbleTea`: common interface for all base drinks and decorators.
- `BubbleTeaDecorator`: abstract wrapper-like base class that delegates to a wrapped `BubbleTea`.
- `LatteBase`, `MatchaBase`, `TeaBase`: concrete base drinks with initial description and cost.
- `IceDecorator`, `SugarDecorator`, `TapiocaDecorator`, `FlavorDecorator`: concrete decorators that append text and add price.

## 🛠 Technologies

- Frontend: N/A
- Backend: Java 17, Maven, JUnit 5
- Database: N/A

## 🚀 Installation and Run

1. Clone the repository:

```zsh
git clone <repository-url>
```

2. Environment variables:

- No `.env` is required for this package.

3. Run the application (console app):

```zsh
mvn -q -f "/Applications/XAMPP/xamppfiles/htdocs/proyectos/sprint3/S3.03-Patterns2/pom.xml" -DskipTests compile
cd "/Applications/XAMPP/xamppfiles/htdocs/proyectos/sprint3/S3.03-Patterns2"
java -cp target/classes Decorator.App
```

4. Run tests:

```zsh
mvn -q -f "/Applications/XAMPP/xamppfiles/htdocs/proyectos/sprint3/S3.03-Patterns2/pom.xml" test
```

Run only Decorator tests:

```zsh
mvn -q -f "/Applications/XAMPP/xamppfiles/htdocs/proyectos/sprint3/S3.03-Patterns2/pom.xml" -Dtest=Decorator.BubbleTeaBasesTest,Decorator.BubbleTeaDecoratorsTest test
```

## 📸 Demo

- Live demo: N/A (local Java console application).
- Example composition:
  - `LatteBase` + `TapiocaDecorator` + `SugarDecorator` + `FlavorDecorator("Maduixa")` + `FlavorDecorator("Mango")`
  - Expected total: `3.50 + 0.50 + 0.30 + 0.60 + 0.60 = 5.50`

## 🧩 Diagrams and Technical Decision Rationale

- **Decorator composition**: each ingredient wraps an existing `BubbleTea` and extends behavior.
- **Open/Closed alignment**: new ingredients can be added as new decorators without changing existing ones.
- **Single responsibility**: each decorator is responsible for one extra ingredient.
- **Runtime flexibility**: ingredients can be combined dynamically and repeatedly.
- **Testability**: each base and decorator can be verified independently and in chained compositions.

Optional improvements:

- Use `BigDecimal` for currency-safe arithmetic in costs.
- Add UML class and sequence diagrams for decoration flow.
- Add snapshot-like tests for full description strings in long combinations.

