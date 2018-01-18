/*
1)	평균 연봉(salary)이 가장 높은 나라는?
 */
select rownum,
       o.country_name
from (select country_name, 
             avg(salary)
      from employees em, departments de, 
           locations lo, countries co
      where em.department_id = de.department_id
      and de.location_id = lo.location_id
      and lo.country_id = co.country_id
      group by country_name
      order by avg(salary) desc)o
where rownum = 1;
/*
2)	평균 연봉(salary)이 가장 높은 지역은?
*/

select rownum,
       o.region_name
from (select region_name, 
             avg(salary)
      from employees em, departments de, 
           locations lo, countries co, regions re
      where em.department_id = de.department_id
      and de.location_id = lo.location_id
      and lo.country_id = co.country_id
      and co.region_id = re.region_id
      group by region_name
      order by avg(salary) desc)o
where rownum = 1;   

/*
3)	가장 많은 직원이 있는 부서는 어떤 부서인가요?
*/

select rownum, 
      department_name
from (select department_name,
            count(employee_id)
      from employees em, departments de
      where em.department_id = de.department_id
      group by department_name
      order by count(employee_id) desc)
where rownum = 1;
