import java.util.ArrayList;
import java.util.HashMap;

class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {
        // Получаем запись по имени из телефонной книги
        ArrayList<Integer> phones = phoneBook.getOrDefault(name, new ArrayList<>());
        // Добавляем новый номер телефона
        phones.add(phoneNum);
        // Обновляем запись в телефонной книге
        phoneBook.put(name, phones);
    }

    public ArrayList<Integer> find(String name) {
        // Возвращаем номера телефона для заданного имени
        return phoneBook.getOrDefault(name, new ArrayList<>());
    }

    public static HashMap<String, ArrayList<Integer>> getPhoneBook() {
        // Возвращаем всю телефонную книгу
        return phoneBook;
    }
}

public class Task01 {
    public static void main(String[] args) {
        String name1;
        String name2;
        int phone1;
        int phone2;

        if (args.length == 0) {
            name1 = "Ivanov";
            name2 = "Petrov";
            phone1 = 123456;
            phone2 = 654321;
        } else {
            name1 = args[0];
            name2 = args[1];
            phone1 = Integer.parseInt(args[2]);
            phone2 = Integer.parseInt(args[3]);
        }

        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add(name1, phone1);
        myPhoneBook.add(name1, phone2);
        myPhoneBook.add(name2, phone2);

        System.out.println(myPhoneBook.find(name1));
        System.out.println(PhoneBook.getPhoneBook());
        System.out.println(myPhoneBook.find("Me"));
    }
}
