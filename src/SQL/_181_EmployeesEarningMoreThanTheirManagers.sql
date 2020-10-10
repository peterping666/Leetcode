select E1.Name AS Employee
from Employee as E1, Employee as E2
where E1.ManagerId = E2.Id AND E1.Salary > E2.Salary
