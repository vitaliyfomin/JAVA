## Сформируйте SQL-запрос

### Дана строка sql-запроса:
```sh
select * from students where "
```
Сформируйте часть **WHERE** этого запроса, используя **StringBuilder**. Данные (параметры) для фильтрации приведены в виде json-строки в примере ниже. Если значение **null**, то параметр не должен попадать в запрос.

Напишите свой код в методе **answer** класса **Answer**. Метод answer принимает на вход два параметра:

**String QUERY** - начало SQL-запроса **String PARAMS** - JSON с параметрами

### Пример: Строка sql-запроса:
```
select * from students where 
```
Параметры для фильтрации:
```
 {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 ```
Результат:
```
select * from students where name='Ivanov' and country='Russia' and city='Moscow'
```