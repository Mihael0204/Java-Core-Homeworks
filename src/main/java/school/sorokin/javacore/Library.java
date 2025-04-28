package school.sorokin.javacore;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Publication> publications;

    public void addPublication(Publication pub) {
        publications.add(pub);
    }

    public Library() {
        publications = new ArrayList<>();
    }

    public void listPublications() {
        if (publications.isEmpty()) {
            System.out.println("Библиотека пуста.");
        } else {
            for (Publication pub : publications) {
                System.out.println(pub.toString());
            }
        }
    }

    public void searchByAuthor(String author) {
        boolean found = false;
        for (Publication pub : publications) {
            if (pub.getAuthor().equalsIgnoreCase(author)) {
                pub.printDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Публикации автора '" + author + "' не найдены.");
        }
    }

    public void deletePublication(String title) {
        boolean removed = publications.removeIf(pub -> pub.getTitle().equalsIgnoreCase(title));
        if (removed) {
            Publication.decrementPublicationCount();
            System.out.println("Публикация \"" + title + "\" удалена.");
        } else {
            System.out.println("Публикация \"" + title + "\" не найдена.");
        }
    }
}
