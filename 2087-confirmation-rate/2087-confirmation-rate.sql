# Write your MySQL query statement below
select s.user_id, round(coalesce((select count(user_id) from confirmations where user_id = s.user_id and action = 'confirmed')/(select count(user_id) from confirmations where user_id = s.user_id),0), 2) as confirmation_rate
from signups s left join confirmations c
on s.user_id = c.user_id
group by (s.user_id)