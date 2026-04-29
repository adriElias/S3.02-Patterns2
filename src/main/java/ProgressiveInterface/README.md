# ProgressiveInterface Restaurant Menus
**Description**: This package implements the Builder pattern using a Fluent API and progressive interfaces to build restaurant menus in a safe and guided order.

## 📌 Exercise Statement

Design and implement a menu-building system that:

- Uses **Builder + Fluent Builder**.
- Applies **SOLID principles**.
- Uses **progressive interfaces** to enforce valid construction order.
- Prevents invalid flows (for example, adding dessert before main course).
- Restricts incompatible options through interface design (dessert vs coffee in the same branch).

The project includes menu variants such as `FullMenu`, `HalfMenu`, and `KidsMenu`.

## ✨ Features

- Step-by-step fluent API for menu creation.
- Progressive interface contracts per step to restrict available operations.
- Dish-level attributes (`setIsVegan()`, `setIsGlutenFree()`) without boolean constructor params.
- Optional garnish support on main course flows.
- Unit tests for menu builders and edge cases (blank dish names, valid sequence checks).

## 🗂 Project Structure

```text
S3.03-Patterns2/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── ProgressiveInterface/
│   │           ├── App.java
│   │           ├── Dish.java
│   │           ├── README.md
│   │           ├── FullMenu/
│   │           │   ├── FullMenu.java
│   │           │   ├── FullMenuBuilder.java
│   │           │   └── Interface/
│   │           │       ├── FullStarterStep.java
│   │           │       ├── FullStarterOptionsStep.java
│   │           │       ├── FullMainCourseOptionsStep.java
│   │           │       ├── FullDrinkOptionsStep.java
│   │           │       ├── FullDessertOptionsStep.java
│   │           │       └── FullCoffeeOptionsStep.java
│   │           ├── HalfMenu/
│   │           │   ├── HalfMenu.java
│   │           │   ├── HalfMenuBuilder.java
│   │           │   └── Interface/
│   │           │       ├── HalfMenuMainCourseStep.java
│   │           │       ├── HalfMenuMainCourseOptionsStep.java
│   │           │       └── HalfMenuDrinkOptionsStep.java
│   │           └── KidsMenu/
│   │               ├── KidsMenu.java
│   │               ├── KidsMenuBuilder.java
│   │               └── Interface/
│   │                   ├── KidsMenuMainCourseStep.java
│   │                   ├── KidsMenuMainCourseOptionsStep.java
│   │                   ├── KidsMenuDrinkOptionsStep.java
│   │                   └── KidsMenuDessertOptionsStep.java
│   └── test/
│       └── java/
│           └── ProgressiveInterface/
│               ├── FullMenuTest.java
│               ├── HalfMenuTest.java
│               └── KidsMenuTest.java
└── README.md
```

## 🧾 Class Overview

- `App`: entry point that demonstrates menu creation flows from the console.
- `Dish`: menu item entity (type, name, vegan/gluten-free flags) with input validation.

### FullMenu
- `FullMenu`: aggregate that stores dishes selected for a full menu flow.
- `FullMenuBuilder`: progressive fluent builder that enforces valid full-menu order and builds `FullMenu`.
- `FullStarterStep`: first contract; starts the flow by requiring a starter.
- `FullStarterOptionsStep`: allows starter flags and transition to main course.
- `FullMainCourseOptionsStep`: configures main course and enables optional branches (drink/dessert/coffee/garnish/build).
- `FullDrinkOptionsStep`: branch after choosing drink, with valid next actions only.
- `FullDessertOptionsStep`: branch after choosing dessert, with valid next actions only.
- `FullCoffeeOptionsStep`: branch after choosing coffee, with valid next actions only.

### HalfMenu
- `HalfMenu`: aggregate that stores dishes selected for a half menu flow.
- `HalfMenuBuilder`: progressive fluent builder for the half-menu sequence.
- `HalfMenuMainCourseStep`: first contract; requires main course to start.
- `HalfMenuMainCourseOptionsStep`: configures main course options and transitions.
- `HalfMenuDrinkOptionsStep`: controls valid actions after selecting drink.

### KidsMenu
- `KidsMenu`: aggregate that stores dishes selected for a kids menu flow.
- `KidsMenuBuilder`: progressive fluent builder for kids-menu constraints and order.
- `KidsMenuMainCourseStep`: first contract; starts with main course.
- `KidsMenuMainCourseOptionsStep`: configures main course options and next steps.
- `KidsMenuDrinkOptionsStep`: defines valid actions after choosing drink.
- `KidsMenuDessertOptionsStep`: defines valid actions after choosing dessert.

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
java -cp target/classes ProgressiveInterface.App
```

4. Run tests:

```zsh
mvn -q -f "/Applications/XAMPP/xamppfiles/htdocs/proyectos/sprint3/S3.03-Patterns2/pom.xml" test
```

Run a single suite:

```zsh
mvn -q -f "/Applications/XAMPP/xamppfiles/htdocs/proyectos/sprint3/S3.03-Patterns2/pom.xml" -Dtest=FullMenuTest test
```

## 📸 Demo

- Live demo: N/A (local Java console application).
- Suggested: add screenshots or terminal output samples for `FullMenu`, `HalfMenu`, and `KidsMenu` creation flows.

## 🧩 Diagrams and Technical Decision Rationale

- **Progressive Interfaces**: each step exposes only the next valid actions.
- **Fluent API**: chainable methods improve readability and domain expressiveness.
- **SOLID alignment**:
  - `S`: each builder is focused on one menu type.
  - `O`: new menu types can be added through new interfaces/builders.
  - `L`: consumers rely on interface contracts per step.
  - `I`: small, focused interfaces for each stage.
  - `D`: flow depends on abstractions (interfaces), not only concrete classes.
- **Validation at entity level**: `Dish` rejects blank names to prevent invalid state.

Optional improvements:

- Add UML/class diagrams for each menu flow.
- Standardize naming (`withX` vs `setX`) if strict alignment with statement examples is required.
- Add integration tests for `App` input/output behavior.
