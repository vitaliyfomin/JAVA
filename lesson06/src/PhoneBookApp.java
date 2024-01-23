import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;


public class PhoneBookApp extends JFrame {
    private static final String FILE_NAME = "phonebook.txt";
    private Map<String, List<String>> phoneBook;

    public PhoneBookApp() {
        phoneBook = loadPhoneBookFromFile();

        setTitle("Телефонная книга");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        createUI();

        setVisible(true);
    }

    private void createUI() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));

        JButton showContactsButton = new JButton("Показать контакты");
        showContactsButton.addActionListener(e -> {
            textArea.setText("");
            printSortedPhoneBook(textArea);
        });

        JButton addContactButton = new JButton("Добавить контакт");
        addContactButton.addActionListener(e -> {
            addContactFromInput();
            savePhoneBookToFile();
        });

        JButton deleteContactButton = new JButton("Удалить контакт");
        deleteContactButton.addActionListener(e -> {
            deleteContactFromInput();
            savePhoneBookToFile();
        });

        JButton saveAndExitButton = new JButton("Сохранить и выйти");
        saveAndExitButton.addActionListener(e -> {
            savePhoneBookToFile();
            System.out.println("Данные сохранены. Пока!");
            System.exit(0);
        });

        buttonPanel.add(showContactsButton);
        buttonPanel.add(addContactButton);
        buttonPanel.add(deleteContactButton);
        buttonPanel.add(saveAndExitButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void addContactFromInput() {
        String name = JOptionPane.showInputDialog("Введите имя контакта:");
        String phoneNumber = JOptionPane.showInputDialog("Введите номер телефона:");
        addContact(name, phoneNumber);
        JOptionPane.showMessageDialog(this, "Контакт успешно добавлен!");
    }

    private void deleteContactFromInput() {
        String nameToDelete = JOptionPane.showInputDialog("Введите имя контакта для удаления:");
        if (phoneBook.containsKey(nameToDelete)) {
            phoneBook.remove(nameToDelete);
            JOptionPane.showMessageDialog(this, "Контакт успешно удален!");
        } else {
            JOptionPane.showMessageDialog(this, "Контакт с именем " + nameToDelete + " не найден.");
        }
    }

    private void printSortedPhoneBook(JTextArea textArea) {
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        entries.sort(Comparator.comparing(entry -> entry.getValue().isEmpty() ? "" : entry.getValue().get(0)));

        for (Map.Entry<String, List<String>> entry : entries) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            textArea.append(name + ": " + phoneNumbers + "\n");
        }
    }

    private void savePhoneBookToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
                String name = entry.getKey();
                List<String> phoneNumbers = entry.getValue();
                writer.write(name + ":" + String.join(",", phoneNumbers));
                writer.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Ошибка записи файла: " + e.getMessage());
        }
    }

    private Map<String, List<String>> loadPhoneBookFromFile() {
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
            savePhoneBookToFile();  // Создаем новый файл
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Ошибка чтения файла: " + e.getMessage());
        }

        return phoneBook;
    }

    private void addContact(String name, String phoneNumber) {
        phoneBook.computeIfAbsent(name, key -> new ArrayList<>()).add(phoneNumber);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PhoneBookApp::new);
    }
}
