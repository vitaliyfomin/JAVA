import java.util.Arrays;

class MergeSort {
    public static int[] mergeSort(int[] a) {
        if (a.length <= 1) {
            return a;
        }

        // Разделение массива на две части
        int middle = a.length / 2;
        int[] left = Arrays.copyOfRange(a, 0, middle);
        int[] right = Arrays.copyOfRange(a, middle, a.length);

        // Рекурсивная сортировка обеих частей
        left = mergeSort(left);
        right = mergeSort(right);

        // Объединение отсортированных частей
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        // Слияние двух отсортированных массивов
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // Добавление оставшихся элементов из левого массива
        while (i < left.length) {
            result[k++] = left[i++];
        }

        // Добавление оставшихся элементов из правого массива
        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }
}

// Класс для вывода результатов на экран и проверки
public class Task01 {
    public static void main(String[] args) {
        int[] a;

        if (args.length == 0) {
            // При отправке кода на выполнение, вы можете варьировать эти параметры
            a = new int[]{5, 1, 6, 2, 3, 4};
        } else {
            a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        MergeSort answer = new MergeSort();
        String itresume_res = Arrays.toString(answer.mergeSort(a));
        System.out.println(itresume_res);
    }
}
