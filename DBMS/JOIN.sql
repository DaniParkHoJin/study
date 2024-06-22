-- 카디션 곱 , Cross Join
SELECT *
FROM EMPLOYEES, DEPARTMENTS;

-- Equi Join
-- 두 테이블에서 공통적으로 존재하는 칼럼의 값이 일치되는 행을 연결하여 결과를 생성하는 조인 방법
SELECT  EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID
FROM EMPLOYEES;

SELECT DEPARTMENT_ID, DEPARTMENT_NAME
FROM DEPARTMENTS;

SELECT FIRST_NAME, DEPARTMENT_NAME
FROM EMPLOYEES, DEPARTMENTS
WHERE EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID;

--Equi Join 에 AND 연산하기
SELECT E.FIRST_NAME, D.DEPARTMENT_NAME
FROM EMPLOYEES E , DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID AND E.FIRST_NAME = 'Susan';
-- Non-Equi Join
-- 조인할 테이블 사이에 칼럼의 값이 직접적으로 일치하지 않을 시 사용하는 조인으로 '='을 제외한 연산자를 사용한다.

-- 예제를 위해 급여 등급 테이블(SALARYGRADE)을 생성하여 레코드를 입력한다.
CREATE TABLE SALARYGRADE(
    GRADE NUMBER,
    MINSALARY NUMBER,
    MAXSALARY NUMBER);
INSERT INTO SALARYGRADE (GRADE, MINSALARY, MAXSALARY)  VALUES (1, 2000, 3000);
INSERT INTO SALARYGRADE (GRADE, MINSALARY, MAXSALARY)  VALUES (2, 3001, 4500);
INSERT INTO SALARYGRADE (GRADE, MINSALARY, MAXSALARY)  VALUES (3, 4501, 6000);
INSERT INTO SALARYGRADE (GRADE, MINSALARY, MAXSALARY)  VALUES (4, 6001, 8000);
INSERT INTO SALARYGRADE (GRADE, MINSALARY, MAXSALARY)  VALUES (5, 8001, 10000);
INSERT INTO SALARYGRADE (GRADE, MINSALARY, MAXSALARY)  VALUES (6, 10001, 13000);
INSERT INTO SALARYGRADE (GRADE, MINSALARY, MAXSALARY)  VALUES (7, 13001, 20000);
INSERT INTO SALARYGRADE (GRADE, MINSALARY, MAXSALARY)  VALUES (8, 20001, 30000);

COMMIT;
-- 생성 후 왁인
SELECT *
FROM SALARYGRADE;
-- 급여 등급을 8개로 나눠 놓은 SALARYGRADE 테이블에서 정보를 어어 와서 각 사원의 급여 등급을 지정한다.
-- 이를 위해서는 EMPLOYEES 테이블과 SALARYGRADE 테이블을 조인해야 한다.
SELECT E.FIRST_NAME, E.SALARY, S.GRADE
    FROM EMPLOYEES E, SALARYGRADE S
WHERE E.SALARY BETWEEN S.MINSALARY AND S.MAXSALARY;
-- 또는
SELECT E.FIRST_NAME, E.SALARY, S.GRADE
    FROM EMPLOYEES E, SALARYGRADE S
WHERE E.SALARY >= S.MINSALARY AND E.SALARY <= S.MAXSALARY;

-- Outer Join
-- 행이 조인 조건에 만족하지 않을 경우 그 행은 결과에 나타나지 않게 된다.

-- 사원 테이블과  부서 테이블을 조인하여 사원 이름과 부서번호와 부서명을 출력한다.
SELECT E.FIRST_NAME, D.DEPARTMENT_ID, D.DEPARTMENT_NAME
    FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
ORDER BY D.DEPARTMENT_ID;
-- 110번 이상 부서가 있는데 나오지 않는다. 이럴 때 (+)로 정보가 부족한 컬럼 명 뒤에 붙인다. WHERE 에
SELECT E.FIRST_NAME, D.DEPARTMENT_ID, D.DEPARTMENT_NAME
    FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID(+) = D.DEPARTMENT_ID
ORDER BY D.DEPARTMENT_ID;

--2007년 상반기에 입사한 사원을 구하라
SELECT  EMPLOYEE_ID, FIRST_NAME, HIRE_DATE, DEPARTMENT_ID
    FROM EMPLOYEES
WHERE HIRE_DATE >= '2007/01/01' AND HIRE_DATE < '2007/07/01';
-- 여기서 2007년 상반이게 입사한 사원에 부서명 까지 더 보고 싶다면?
SELECT  EMPLOYEE_ID, FIRST_NAME, HIRE_DATE, D.DEPARTMENT_NAME
    FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
    AND HIRE_DATE >= '2007/01/01' AND HIRE_DATE < '2007/07/01';
-- 그런데 한 명이 누락되어 있다. 그 사람을 보고 싶다면?
SELECT  EMPLOYEE_ID, FIRST_NAME, HIRE_DATE, D.DEPARTMENT_NAME
    FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID(+)
    AND HIRE_DATE >= '2007/01/01' AND HIRE_DATE < '2007/07/01';

-- Self Join
-- 특정 사원을 담당하는 매너저 사원의 이름을 출력하자.
SELECT EMPLOYEE_ID, FIRST_NAME, MANAGER_ID
    FROM EMPLOYEES;
-- EMPLOYEES 테이블에 별칭을 사용하여 하나의 테이블을 두 개의 테이블인 것처럼 사용하려면
-- WORK(사원 테이블)과 MANAGER(메니저 테이블)로 별칭을 부여한다.
SELECT WORK.FIRST_NAME 사원명, MANAGER.FIRST_NAME 매니저명
    FROM EMPLOYEES WORK, EMPLOYEES MANAGER
WHERE WORK.MANAGER_ID = MANAGER.EMPLOYEE_ID;

-- 사원의 이름과 그의 매니저 이름을 출력하는 쿼리문
SELECT RPAD(WORK.FIRST_NAME, 11,'') ||'의 매니저는 ' ||MANAGER.FIRST_NAME|| '이다.' AS "그 사원의 매니저"
    FROM EMPLOYEES WORK, EMPLOYEES MANAGER
WHERE WORK.MANAGER_ID = MANAGER.EMPLOYEE_ID;

-- ANSI(미국표준연구소) Join
-- 다른 DBMS와의 호환성을 위해서는 ANSI 조인을 사용하는 것이 좋다.

-- ANSI Croos Join - 카디션 콥과 같다.
SELECT *
    FROM EMPLOYEES CROSS JOIN DEPARTMENTS;
-- 아래와 동일하다.
SELECT *
    FROM EMPLOYEES , DEPARTMENTS;

-- ANSI Inner Join - Equi Join 과 같다.
SELECT FIRST_NAME, DEPARTMENT_NAME
    FROM EMPLOYEES INNER JOIN  DEPARTMENTS
ON EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID;
-- 아래와 동일하다.
SELECT FIRST_NAME, DEPARTMENT_NAME
FROM EMPLOYEES, DEPARTMENTS
WHERE EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID;

-- 더 특정하는 방법은 WHERE
SELECT FIRST_NAME, DEPARTMENT_NAME
    FROM EMPLOYEES INNER JOIN  DEPARTMENTS
ON EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID
WHERE FIRST_NAME = 'Susan';
-- 아래와 동일하다.
SELECT E.FIRST_NAME, D.DEPARTMENT_NAME
FROM EMPLOYEES E , DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID AND E.FIRST_NAME = 'Susan';

-- USING을 이용한 조인 고건 지정
-- 테이블 간의 조인 조건에 사용되는 칼럼이 같다면 ON 대신에 USING을 사용할 수 있다.
SELECT EMPLOYEES.FIRST_NAME, DEPARTMENTS.DEPARTMENT_NAME
    FROM EMPLOYEES INNER JOIN DEPARTMENTS
USING (DEPARTMENT_ID)
WHERE FIRST_NAME= 'Susan';

-- ANSI Outer Join
-- 기존에 (+)를 붙이던 것을 말로 표현한다. 더 나아가 FULL까지 지원한다.
SELECT E.FIRST_NAME, D.DEPARTMENT_ID, D.DEPARTMENT_NAME
    FROM EMPLOYEES E RIGHT OUTER JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID;
-- 아래와 같다.
SELECT E.FIRST_NAME, D.DEPARTMENT_ID, D.DEPARTMENT_NAME
    FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID(+) = D.DEPARTMENT_ID
ORDER BY D.DEPARTMENT_ID;


SELECT  EMPLOYEE_ID, FIRST_NAME, HIRE_DATE
    FROM EMPLOYEES E LEFT OUTER JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
WHERE HIRE_DATE >= '2007/01/01' AND HIRE_DATE < '2007/07/01';
-- 아래와 동일하다.
SELECT  EMPLOYEE_ID, FIRST_NAME, HIRE_DATE, D.DEPARTMENT_NAME
    FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID(+)
    AND HIRE_DATE >= '2007/01/01' AND HIRE_DATE < '2007/07/01';

-- 문제
-- 1. Sales 부서 소속 사원의 이름과 입사일을 출력하라.
SELECT E.FIRST_NAME, E.HIRE_DATE
    FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID AND D.DEPARTMENT_NAME = 'Sales';
-- 2. 커미션을 받는 사원의 이름과 그가 속한 부서명을 출력하라.
SELECT E.FIRST_NAME, D.DEPARTMENT_NAME
    FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
    AND COMMISSION_PCT IS NOT NULL;
-- 또는
SELECT E.FIRST_NAME, D.DEPARTMENT_NAME
    FROM EMPLOYEES E INNER JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
    WHERE COMMISSION_PCT IS NOT NULL;
-- 3. Guy와 동일한 부서에서 근무하는 사원의 이름을 출력하라.
SELECT E1.FIRST_NAME
    FROM EMPLOYEES E1 , HR.EMPLOYEES E2
WHERE E1.DEPARTMENT_ID = E2.DEPARTMENT_ID
AND E2.FIRST_NAME = 'Guy' AND E1.FIRST_NAME <> 'Guy';