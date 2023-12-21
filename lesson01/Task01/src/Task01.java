class Answer {
  public int countNTriangle(int n) {
    if (n < 1) {
      return -1; // Если число n < 1 (ненатуральное), возвращаем -1
    }

    // Используем формулу для вычисления треугольных чисел: Tn = n * (n + 1) / 2
    return n * (n + 1) / 2;
  }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Task01 {
  public static void main(String[] args) {
    int n = 0;

    if (args.length == 0) {
      // При отправке кода на Выполнение, вы можете варьировать эти параметры
      n = 4;
    } else {
      n = Integer.parseInt(args[0]);
    }

    // Вывод результата на экран
    Answer ans = new Answer();
    int result = ans.countNTriangle(n);
    System.out.println(result);
  }
}
