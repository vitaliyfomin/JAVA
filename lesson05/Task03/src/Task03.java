import java.util.Arrays;

class HeapSort {
    public static void buildTree(int[] tree, int sortLength) {
        // Строим сортирующее дерево
        for (int i = sortLength / 2 - 1; i >= 0; i--) {
            heapify(tree, sortLength, i);
        }
    }

    public static void heapSort(int[] sortArray, int sortLength) {
        // Строим сортирующее дерево
        buildTree(sortArray, sortLength);

        // Постепенно извлекаем элементы из кучи
        for (int i = sortLength - 1; i >= 0; i--) {
            // Обмениваем корень кучи с последним элементом
            int temp = sortArray[0];
            sortArray[0] = sortArray[i];
            sortArray[i] = temp;

            // Вызываем heapify на уменьшенной куче
            heapify(sortArray, i, 0);
        }
    }

    private static void heapify(int[] tree, int sortLength, int root) {
        int largest = root;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;

        // Если левый потомок больше корня
        if (leftChild < sortLength && tree[leftChild] > tree[largest]) {
            largest = leftChild;
        }

        // Если правый потомок больше текущего наибольшего элемента
        if (rightChild < sortLength && tree[rightChild] > tree[largest]) {
            largest = rightChild;
        }

        // Если наибольший элемент не корень
        if (largest != root) {
            // Обмениваем корень с наибольшим элементом
            int swap = tree[root];
            tree[root] = tree[largest];
            tree[largest] = swap;

            // Рекурсивно вызываем heapify для поддерева
            heapify(tree, sortLength, largest);
        }
    }
}

// Не удаляйте и не меняйте метод Main! 
public class Task03 {
    public static void main(String[] args) {
        int[] initArray;

        if (args.length == 0) {
            initArray = new int[]{17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1};
        } else {
            initArray = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println("Initial array:");
        System.out.println(Arrays.toString(initArray));
        HeapSort.heapSort(initArray, initArray.length);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));
    }
}
