import java.util.LinkedList;

class LLTasks {
    public static LinkedList<Object> revert(LinkedList<Object> ll) {
        // Создаем новый связанный список для хранения развернутых элементов
        LinkedList<Object> reversedList = new LinkedList<>();

        // Итерируемся по исходному списку в обратном порядке и добавляем элементы в новый список
        for (int i = ll.size() - 1; i >= 0; i--) {
            reversedList.add(ll.get(i));
        }

        // Возвращаем развернутый список
        return reversedList;
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Task01 {
    public static void main(String[] args) {
        LinkedList<Object> ll = new LinkedList<>();

        if (args.length == 0 || args.length != 4) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            ll.add(1);
            ll.add("One");
            ll.add(2);
            ll.add("Two");
        } else {
            ll.add(Integer.parseInt(args[0]));
            ll.add(args[1]);
            ll.add(Integer.parseInt(args[2]));
            ll.add(args[3]);
        }

        LLTasks answer = new LLTasks();
        System.out.println(ll);
        LinkedList<Object> reversedList = answer.revert(ll);
        System.out.println(reversedList);
    }
}
