import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

class Answer {
    public static void analyzeNumbers(Integer[] arr) {
        // Создание списка ArrayList и заполнение его числами из исходного массива
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));

        // Сортировка списка по возрастанию
        Collections.sort(list);

        // Вывод отсортированного списка
        System.out.println(list);

        // Нахождение минимального и максимального значений в списке
        int min = Collections.min(list);
        int max = Collections.max(list);

        // Вывод минимального и максимального значений
        System.out.println("Minimum is " + min);
        System.out.println("Maximum is " + max);

        // Нахождение среднего арифметического значений в списке
        double average = list.stream()
                             .mapToDouble(Integer::doubleValue)
                             .average()
                             .orElse(Double.NaN);

        // Вывод среднего арифметического
        System.out.println("Average is = " + average);
    }
}

// Класс для вывода результатов на экран и проверки
public class Task03 {
    public static void main(String[] args) {
        Integer[] arr;

        if (args.length == 0) {
            // При отправке кода на выполнение, вы можете варьировать эти параметры
            arr = new Integer[]{4, 2, 7, 5, 1, 3, 8, 6, 9};
        } else {
            arr = Arrays.stream(args[0].split(", "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }

        Answer ans = new Answer();
        ans.analyzeNumbers(arr);
    }
}
