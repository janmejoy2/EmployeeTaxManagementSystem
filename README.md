# EmployeeTaxManagementSystem
API for calculating the tax

This APi has 4 endpoints:
1. /addEmployee: Getting used to create single employee
   
   Method: POST
   
   Body:
   `{
    "employeeId": "EMP002",
    "firstName": "Alice",
    "lastName": "Smith",
    "email": "alice.smith@example.com",
    "phoneNumbers": ["5551234567"],
    "doj": "2023-02-15",
    "salary": 155000.00
}`
3. /addMultipleEmployees: Getting used for creating multiple employees at a time.
   
    Method: POST
 
    Body:
   `[
   {
    "employeeId": "EMP002",
    "firstName": "Alice",
    "lastName": "Smith",
    "email": "alice.smith@example.com",
    "phoneNumbers": ["5551234567"],
    "doj": "2023-02-15",
    "salary": 55000.00
  },
  {
    "employeeId": "EMP003",
    "firstName": "Michael",
    "lastName": "Johnson",
    "email": "michael.johnson@example.com",
    "phoneNumbers": ["4449876543"],
    "doj": "2023-03-20",
    "salary": 60000.00
  }
]`

3. /employees: Getting used to retrieve all the employees exist in database.

   Method: GET
   
4. /taxDeduction: Getting used to retrieve the tax deduction calcualtion for all added employees.
   
   Method: GET


   Databased Used: H2
   
   External Dependency:
   1. JPA
   2. H2Database
   3. SpringBootStarterWeb
   
