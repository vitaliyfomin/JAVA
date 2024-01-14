import java.util.ArrayList;
import java.util.Arrays;

class Answer {
    public static ArrayList<Integer> removeEvenNumbers(Integer[] arr) {
        ArrayList<Integer> result = new ArrayList<>();

        for (Integer num : arr) {
            if (num % 2 != 0) {
                result.add(num);
            }
        }

        return result;
    }
}

// Класс для вывода результатов на экран и проверки
public class Task02 {
    public static void main(String[] args) {
        Integer[] arr;

        if (args.length == 0) {
            // При отправке кода на выполнение, вы можете варьировать эти параметры
            arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        } else {
            arr = Arrays.stream(args[0].split(", "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }

        Answer ans = new Answer();
        ArrayList<Integer> result = ans.removeEvenNumbers(arr);

        System.out.println(result);
    }
}
