import java.util.LinkedList;

class MyQueue<T> {
    private LinkedList<T> elements = new LinkedList<>();

    public void enqueue(T element) {
        elements.addLast(element);
    }

    public T dequeue() {
        if (elements.isEmpty()) {
            return null; // Можно также выбрасывать исключение или предпринимать другие действия по вашему усмотрению
        }
        return elements.removeFirst();
    }

    public T first() {
        if (elements.isEmpty()) {
            return null;
        }
        return elements.getFirst();
    }

    public LinkedList<T> getElements() {
        return new LinkedList<>(elements);
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Task03 {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            queue.enqueue(1);
            queue.enqueue(10);
            queue.enqueue(15);
            queue.enqueue(5);
        } else {
            queue.enqueue(Integer.parseInt(args[0]));
            queue.enqueue(Integer.parseInt(args[1]));
            queue.enqueue(Integer.parseInt(args[2]));
            queue.enqueue(Integer.parseInt(args[3]));
        }

        System.out.println(queue.getElements());

        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.getElements());

        System.out.println(queue.first());
    }
}
