class Answer {
    public void printPrimeNums() {
        for (int i = 2; i <= 1000; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Task02 {
    public static void main(String[] args) {
        Answer ans = new Answer();
        ans.printPrimeNums();
    }
}
