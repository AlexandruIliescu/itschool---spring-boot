Single Responsibility Principle (SRP):
Problem: Design a class that handles both user authentication and sending notification emails. 
Refactor the class to adhere to the SRP by separating these responsibilities into two distinct classes.

Open-Closed Principle (OCP):
Problem: Create a pricing system for an e-commerce platform. 
However, the requirements state that new types of discounts and pricing strategies should be easily added without 
modifying existing code. 
Design the system following the OCP to accommodate future extensions.

Liskov Substitution Principle (LSP):
Problem: Implement a class hierarchy representing different types of vehicles (car, bicycle, motorcycle). 
Ensure that all derived classes can be substituted for the base class without causing any unexpected behavior or 
violating the assumptions of the calling code.

Interface Segregation Principle (ISP):
Problem: Design an interface for a reporting module. 
Avoid creating a single monolithic interface that includes all possible reporting methods. Instead, create smaller, 
focused interfaces that cater to specific reporting needs (e.g., PDF reporting, CSV reporting, chart generation).

Dependency Inversion Principle (DIP):
Problem: Develop a file processing module that interacts with different storage systems, such as a local file system or 
a cloud storage service. Apply the DIP by creating an abstraction that allows the module to depend on the storage 
abstraction, making it easy to switch between different storage implementations without modifying the module itself.