## Реализация очереди

В классе **MyQueue** реализуйте очередь для типа данных **Integer** с помощью **LinkedList** со следующими методами:

- **enqueue()** - помещает элемент в конец очереди
- **dequeue()** - возвращает первый элемент из очереди и удаляет его
- **first()** - возвращает первый элемент из очереди, не удаляя
- **getElements()** - возвращает все элементы в очереди

**Пример**
```
queue.enqueue(1);
queue.enqueue(10);
queue.enqueue(15);
queue.enqueue(5);
System.out.println(queue.getElements()); 
```
Результат:
```
[1, 10, 15, 5]
queue.dequeue();
queue.dequeue();
System.out.println(queue.getElements());
```
Результат:
```
[15, 5]
System.out.println(queue.first());
```
Результат:
```
15
```