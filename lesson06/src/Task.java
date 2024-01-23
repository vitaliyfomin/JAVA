import java.io.*;
import java.util.*;

public class Task {
    private static final String FILE_NAME = "phonebook.txt";

    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = loadPhoneBookFromFile();

        try (Scanner input = new Scanner(System.in)) {
            int menuNumber;

            do {
                System.out.println("""
                        Меню:
                         1 - Показать контакты
                         2 - Добавить контакт
                         3 - Удалить контакт
                         4 - Сохранить и выйти
                        """);

                // Проверяем наличие следующего элемента во входных данных
                if (input.hasNextInt()) {
                    menuNumber = input.nextInt();

                    switch (menuNumber) {
                        case 1:
                            printSortedPhoneBook(phoneBook);
                            break;
                        case 2:
                            addContactFromInput(phoneBook);
                            savePhoneBookToFile(phoneBook);  // Добавим сохранение в файл после добавления контакта
                            break;
                        case 3:
                            deleteContactFromInput(phoneBook);
                            savePhoneBookToFile(phoneBook);  // Добавим сохранение в файл после удаления контакта
                            break;
                        case 4:
                            savePhoneBookToFile(phoneBook);
                            System.out.println("Данные сохранены. Пока!");
                            break;
                        default:
                            System.out.println("Вы ввели неверный номер пункта!");
                            break;
                    }
                } else {
                    // Если введено нечисловое значение, выходим из цикла
                    System.out.println("Введите числовое значение. Выход из программы.");
                    break;
                }

            } while (menuNumber != 4);
        }
    }

    private static void addContact(Map<String, List<String>> phoneBook, String name, String phoneNumber) {
        phoneBook.computeIfAbsent(name, key -> new ArrayList<>()).add(phoneNumber);
    }

    private static void addContactFromInput(Map<String, List<String>> phoneBook) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите имя контакта: ");
            String name = scanner.nextLine().trim();

            System.out.print("Введите номер телефона: ");
            String phoneNumber = scanner.nextLine().trim();

            addContact(phoneBook, name, phoneNumber);
            System.out.println("Контакт успешно добавлен!");
        }
    }

    private static void deleteContactFromInput(Map<String, List<String>> phoneBook) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите имя контакта для удаления: ");
            String nameToDelete = scanner.nextLine().trim();

            if (phoneBook.containsKey(nameToDelete)) {
                phoneBook.remove(nameToDelete);
                System.out.println("Контакт успешно удален!");
            } else {
                System.out.println("Контакт с именем " + nameToDelete + " не найден.");
            }
        }
    }

    private static void printSortedPhoneBook(Map<String, List<String>> phoneBook) {
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        entries.sort(Comparator.comparing(entry -> entry.getValue().isEmpty() ? "" : entry.getValue().get(0)));

        for (Map.Entry<String, List<String>> entry : entries) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers);
        }
    }

    private static Map<String, List<String>> loadPhoneBookFromFile() {
        Map<String, List<String>> phoneBook = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String name = parts[0].trim();
                String[] phoneNumbers = parts[1].split(",");
                phoneBook.computeIfAbsent(name, key -> new ArrayList<>()).addAll(Arrays.asList(phoneNumbers));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден. Создаем новый файл: " + FILE_NAME);
            savePhoneBookToFile(phoneBook);  // Создаем новый файл
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }

        return phoneBook;
    }

    private static void savePhoneBookToFile(Map<String, List<String>> phoneBook) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
                String name = entry.getKey();
                List<String> phoneNumbers = entry.getValue();
                writer.write(name + ":" + String.join(",", phoneNumbers));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи файла: " + e.getMessage());
        }
    }
}
