SELECT MAX(Salary) AS SecondHighestSalary
FROM Employee
where Salary < (SELECT MAX(Salary) FROM Employee)
