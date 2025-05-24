# Write your MySQL query statement below
select name, bonus
from employee e  left join bonus b
on e.empId = b.empId
where Coalesce(bonus,0) < 1000