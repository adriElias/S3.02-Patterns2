# Observer Stock Market Notifications
**Description**: This package implements the Observer pattern in a stock market notification system where one observable entity informs multiple broker agencies when share values go up or down.

## 📌 Exercise Statement

Implement the **Observer pattern** for a stock market use case.

The pattern defines a **one-to-many dependency** between objects so that when the observable changes state, all subscribed observers are notified automatically.

In this exercise, a stock agent publishes market events (UP/DOWN), and subscribed broker agencies receive notifications with the updated value.

## ✨ Features

- Observable with dynamic subscription management (`addObserver`, `removeObserver`).
- Automatic notifications when market value changes (`stockMarketUp`, `stockMarketDown`).
- Observer contract through interface (`StockBrokerageObserver`).
- Concrete observers that render notification messages (`StockBrokerage`).
- Unit tests for subscriptions, notifications, event propagation, and current value updates.

## 🧱 Class Overview

- `App`: console entry point that wires the observable and observers, then simulates market UP/DOWN events.
- `StockbrokerObservable`: the observable/publisher that stores subscribers, updates market value, and triggers notifications.
- `StockBrokerageObserver`: observer contract that defines how subscribers receive updates.
- `StockBrokerage`: concrete observer representing a brokerage agency that builds and prints notification messages.

## 🗂 Project Structure

```text
S3.03-Patterns2/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── Observer/
│   │           ├── App.java
│   │           ├── README.md
│   │           ├── StockBrokerage.java
│   │           ├── StockBrokerageObserver.java
│   │           └── StockbrokerObservable.java
│   └── test/
│       └── java/
│           └── Observer/
│               ├── StockBrokerageTest.java
│               └── StockbrokerObservableTest.java
└── README.md
```

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
java -cp target/classes Observer.App
```

4. Run tests:

```zsh
mvn -q -f "/Applications/XAMPP/xamppfiles/htdocs/proyectos/sprint3/S3.03-Patterns2/pom.xml" test
```

Run only Observer tests:

```zsh
mvn -q -f "/Applications/XAMPP/xamppfiles/htdocs/proyectos/sprint3/S3.03-Patterns2/pom.xml" -Dtest=Observer.StockBrokerageTest,Observer.StockbrokerObservableTest test
```

## 📸 Demo

- Live demo: N/A (local Java console application).
- Example flow:
  - Register agencies: `Alpha Brokers`, `Zenith Investments`.
  - Trigger market up event with `150.75`.
  - Trigger market down event with `145.50`.
  - Both observers receive notification messages.

## 🧩 Diagrams and Technical Decision Rationale

- **Pattern roles mapping**:
  - Observable: `StockbrokerObservable`
  - Observer interface: `StockBrokerageObserver`
  - Concrete observer: `StockBrokerage`
- **Runtime decoupling**: observers are managed by interface, so concrete subscribers can be added without changing observable logic.
- **Dynamic behavior**: subscriptions are added/removed at runtime depending on context.
- **SOLID alignment**:
  - `S`: each class has a focused role (publisher, contract, subscriber).
  - `O`: new observers can be introduced without modifying the observable class.
  - `L`: all observers comply with the same notification contract.
  - `I`: small observer interface with a single notification method.
  - `D`: observable depends on abstraction (`StockBrokerageObserver`), not concrete classes.

Optional improvements:

- Include the event token (`UP`/`DOWN`) explicitly in `StockBrokerage` printed message.
- Add integration test for `Observer.App` console output.
- Add UML class and sequence diagrams for the notification flow.
