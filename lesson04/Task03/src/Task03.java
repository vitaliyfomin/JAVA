import java.util.ArrayDeque;
import java.util.Deque;

class Calculator {
    private Deque<Double> results = new ArrayDeque<>();

    public double calculate(char op, double a, double b) {
        double result;
        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
            default:
                result = 0;
        }
        results.addLast(result);
        return result;
    }

    public double undo() {
        if (results.size() >= 2) {
            results.removeLast(); // Удаляем последний результат
            return results.getLast(); // Возвращаем предпоследний результат
        } else {
            return 0; // Если операций было меньше двух, возвращаем 0 или можно выбрасывать исключение
        }
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Task03 {
    public static void main(String[] args) {
        double a, b, c, d;
        char op, op2, undo;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = 3.0;
            op = '+';
            b = 7.0;
            c = 4.0;
            op2 = '+';
            d = 7.0;
            undo = '<';
        } else {
            a = Double.parseDouble(args[0]);
            op = args[1].charAt(0);
            b = Double.parseDouble(args[2]);
            c = Double.parseDouble(args[3]);
            op2 = args[4].charAt(0);
            d = Double.parseDouble(args[5]);
            undo = args[6].charAt(0);
        }

        Calculator calculator = new Calculator();
        double result = calculator.calculate(op, a, b);
        System.out.println(String.format("%.1f", result));
        double result2 = calculator.calculate(op2, c, d);
        System.out.println(String.format("%.1f", result2));
        double prevResult = calculator.undo();
        System.out.println(String.format("%.1f", prevResult));
    }
}
