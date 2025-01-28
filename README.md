# SOLID-Principles
The **SOLID principles** are five fundamental design principles in object-oriented programming that help developers create scalable, maintainable, and testable software. Each principle tackles common issues encountered in software design.

#### Why SOLID Principles Are Important
- **Maintainability**: Easier to modify code without introducing bugs.
- **Scalability**: Simplifies adding new features.
- **Testability**: Improves the ability to write unit tests.
- **Readability**: Makes the code more understandable for developers
---
### 1. Single Responsibility Principle (SRP)
`A class should have only one reason to change, meaning it should only have one job or responsibility.`

**Why it is important:** When a class has multiple responsibilities, changes to one responsibility can inadvertently impact the other, leading to bugs and harder maintenance.

- [Violates SRP](https://github.com/Shalini-lodhi/SOLID-Principles/blob/main/SingleResponsibilityPrinciple/WithoutSRP.java):
```mermaid
classDiagram
    class Invoice{
        + calculateTotal()
        + printInvoice()
        + saveToDatabase()
    }
    class Main{
        
    }
    Invoice --> Main
```
- [With SRP](https://github.com/Shalini-lodhi/SOLID-Principles/blob/main/SingleResponsibilityPrinciple/WithSRP.java):
```mermaid
classDiagram
    class Invoice{
        + calculateTotal()
    }
    class InvoicePrint{
        + printInvoice()
    }
    class InvoiceRepository {
        + saveToDatabase()
    }
    class Main{
        
    }
    Invoice --> Main
    InvoicePrint --> Main
    InvoiceRepository --> Main
```   
**Why use SRP?**
- Simplifies debugging: When a class has only one responsibility, issues are easier to locate and fix.
- Reduces coupling: Changes in one part of the system won’t affect unrelated parts.
- Enhances readability: Smaller, focused classes are easier to understand.
---
  
### 2. Open/Closed Principle (OCP)
`A class should be open for extension but closed for modification.`

**Why it is important:**
You can add new functionality without altering existing code, minimizing the risk of introducing bugs.

- Without OCP
```mermaid
classDiagram
    class PaymentProcessor{
        + processPayment()
    }
    class Main{
        //instantiate PaymentProcessor
    }
    PaymentProcessor --> Main
```

- With OCP
```mermaid
classDiagram
    direction TB

    class Payment {
        <<interface>>
        +processPayment()
    }

    class CreditCardPayment {
        +processPayment()
    }

    class PayPalPayment {
        +processPayment()
    }

    class PaymentProcessor {
        +processPayment(payment: Payment)
    }
    class Main{

    }

    Payment <|.. CreditCardPayment
    Payment <|.. PayPalPayment
    PaymentProcessor --> Payment
    PaymentProcessor --> Main
```
**Why use OCP?**
- Minimizes risk: Existing code remains untouched when adding new
- features, reducing the chances of introducing bugs.
- Supports scalability: New functionalities can be added without altering stable code.
- Eases testing: Each extension can be tested independently.

---
### 3. Liskov Substitution Principle (LSP)
`Derived classes should be substitutable for their base classes without altering the correctness of the program.`

**Why it is important:**
Ensures polymorphism works correctly, and derived classes don’t break the functionality expected from the base class.

- Without LSP
```mermaid
classDiagram
    direction TB

    class Rectangle {
        -int width
        -int height
        +setWidth(int width)
        +setHeight(int height)
        +getArea() int
    }

    class Square {
        +setWidth(int width)
        +setHeight(int height)
    }

    Rectangle <|-- Square
```
- With LSP
```mermaid
classDiagram
    direction TB

    class Shape {
        <<interface>>
        +getArea() int
    }

    class Rectangle {
        -int width
        -int height
        +Rectangle(int width, int height)
        +getArea() int
    }

    class Square {
        -int side
        +Square(int side)
        +getArea() int
    }

    Shape <|.. Rectangle
    Shape <|.. Square
```
**Why use LSP?**
- **Ensures polymorphism**: Subclasses can replace base classes without breaking the application.
- **Improves reliability**: Derived classes won’t introduce unexpected behavior.
- **Promotes reusability**: Generic code can work with any subclass
---
  
### 4. Interface Segregation Principle (ISP)
`A class should not be forced to implement interfaces it does not use; Split large interfaces into smaller, more specific ones.`

**Why it is important:** Prevents creating large, unwieldy interfaces that force classes to implement unnecessary methods.

- Without ISP
```mermaid
classDiagram
    direction TB

    class Worker {
        <<interface>>
        +work()
        +eat()
    }

    class Robot {
        +work()
        +eat()
    }

    Worker <|.. Robot
```
- With ISP
```mermaid
classDiagram
    direction TB

    class Workable {
        <<interface>>
        +work()
    }

    class Eatable {
        <<interface>>
        +eat()
    }

    class Human {
        +work()
        +eat()
    }

    class Robot {
        +work()
    }

    Workable <|.. Human
    Eatable <|.. Human
    Workable <|.. Robot
```

**Why use ISP?**
- **Prevents unnecessary implementation**: Classes aren’t burdened with methods they don’t need.
- **Improves flexibility**: Smaller interfaces allow more granular control over what is implemented.
- **Reduces code bloat**: Keeps classes lightweight and focused.

---
### 5. Dependency Inversion Principle (DIP)
`High-level modules should not depend on low-level modules. Both should depend on abstractions.`

**Why it is important:**
Reduces coupling and makes code easier to test and modify.

- Without DIP
```mermaid
classDiagram
    direction TB

    class MySQLDatabase {
        +connect()
    }

    class Application {
        -MySQLDatabase database
        +Application()
        +start()
    }

    Application --> MySQLDatabase
```

- With DIP
```mermaid
classDiagram
    direction TB

    class Database {
        <<interface>>
        +connect()
    }

    class MySQLDatabase {
        +connect()
    }

    class MongoDBDatabase {
        +connect()
    }

    class Application {
        -Database database
        +Application(Database database)
        +start()
    }

    Database <|.. MySQLDatabase
    Database <|.. MongoDBDatabase
    Application --> Database
```
**Why use DIP?**
- **Decouples components**: The system becomes modular, allowing independent development and testing.
- **Facilitates testing**: Mock dependencies can be easily injected for unit testing.
- **Enables flexibility**: Changing the implementation (e.g., switching from MySQL to MongoDB) doesn’t require altering high-level logic.
