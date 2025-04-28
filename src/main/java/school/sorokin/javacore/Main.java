package school.sorokin.javacore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Library library = new Library();

    public static void main(String[] args) throws IOException {
        showContextMenu();
        int inputNumber;

        while ((inputNumber = Integer.parseInt(reader.readLine())) != 6) {
            if (inputNumber < 1 || inputNumber > 6) {
                System.out.println("Некоректно введенные данные.");
                showContextMenu();
            }
            switch (inputNumber) {
                case 1:
                    addNewPublication();
                    break;
                case 2:
                    library.listPublications();
                    showContextMenu();
                    break;
                case 3:
                    searchPublicationByAuthor();
                    break;
                case 4:
                    showPublicationsCount();
                    break;
                case 5:
                    deletePublicationByTitle();
                    break;
            }
        }
    }

    private static void deletePublicationByTitle() throws IOException {
        System.out.println("Введите название публикации для удаления: ");
        String title = reader.readLine();
        library.deletePublication(title);
        showContextMenu();
    }

    private static void addNewPublication() throws IOException {
        showPublicationMenu();
        int inputNumber;
        while((inputNumber = Integer.parseInt(reader.readLine())) != 4) {
            if (inputNumber < 1 || inputNumber > 4) {
                System.out.println("Некоректно введенные данные.");
                showPublicationMenu();
            }
            switch (inputNumber) {
                case 1:
                    addBook();
                    showPublicationMenu();
                    break;
                case 2:
                    addMagazine();
                    showPublicationMenu();
                    break;
                case 3:
                    addNewspaper();
                    showPublicationMenu();
                    break;
            }
        }
        showContextMenu();
    }

    private static void addBook() throws IOException {
        String title, author, ISBN;
        int year;

        System.out.println("Введите название: ");
        title = reader.readLine();

        System.out.println("Введите автора: ");
        author = reader.readLine();

        year = checkValidYear();

        while (true) {
        System.out.println("Введите ISBN(длина - 13 цифр): ");
            ISBN = reader.readLine().trim();

            if (ISBN.matches("\\d{13}")) {
                break;
            } else {
                System.out.println("ISBN должен содержать 13 цифр.");
            }
        }

        Publication book = new Book(title, author, year, ISBN);
        library.addPublication(book);
    }

    private static void addMagazine() throws IOException {
        String title, author;
        int year, issueNumber;

        System.out.println("Введите название: ");
        title = reader.readLine();

        System.out.println("Введите автора: ");
        author = reader.readLine();

        year = checkValidYear();

        while(true) {
            System.out.println("Введите номер выпуска: ");
            try {
                issueNumber = Integer.parseInt(reader.readLine());
                if (issueNumber > 0) {
                    break;
                } else {
                    System.out.println("Ошибка: номер выпуска должен быть больше нуля.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            }
        }

        Publication magazine = new Magazine(title, author, year, issueNumber);
        library.addPublication(magazine);
    }

    private static void addNewspaper() throws IOException {
        String title, author, publicationDay;
        int year;

        System.out.println("Введите название: ");
        title = reader.readLine();

        System.out.println("Введите автора: ");
        author = reader.readLine();

        year = checkValidYear();

        do {
            System.out.println("Введите день публикации: ");
            publicationDay = reader.readLine().trim().toLowerCase();
            if (!DayOfWeek.isValidDay(publicationDay)) {
                System.out.println("Неверный день. Попробуйте еще раз.");
            }
        } while (!DayOfWeek.isValidDay(publicationDay));

        Publication newspaper = new Newspaper(title, author, year, publicationDay);
        library.addPublication(newspaper);
    }

    private static void searchPublicationByAuthor() throws IOException {
        System.out.println("Введите имя автора: ");
        String author = reader.readLine();
        library.searchByAuthor(author);
        showContextMenu();
    }

    private static void showPublicationsCount() {
        System.out.println(Publication.getPublicationCount());
        showContextMenu();
    }

    private static void showContextMenu() {
        System.out.println("1. Добавить новую публикацию.\n"
                + "2. Вывести список всех публикаций.\n"
                + "3. Поиск публикации по автору.\n"
                + "4. Количество публикаций.\n"
                + "5. Удалить публикацию.\n"
                + "6. Выйти.\n"
                + "\nВыберите операцию: \n");
    }

    private static void showPublicationMenu() {
        System.out.println("1. Книга.\n"
            + "2. Журнал.\n"
            + "3. Газета.\n"
            + "4. Назад.\n"
            + " \n");
    }

    private static int checkValidYear() throws IOException {
        int year;
        while(true) {
            System.out.println("Введите год: ");
            try {
                year = Integer.parseInt(reader.readLine());
                if (year < 2026) {
                    return year;
                } else {
                    System.out.println("Ошибка: год не может быть больше текущего.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            }
        }
    }
}
