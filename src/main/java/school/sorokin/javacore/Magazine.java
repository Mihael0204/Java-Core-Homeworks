package school.sorokin.javacore;

import java.util.Objects;

public class Magazine extends Publication {
    private int issueNumber;

    public Magazine(String title, String author, int year, int issueNumber) {
        super(title, author, year);
        this.issueNumber = issueNumber;
    }

    @Override
    public String getType() {
        return "Журнал";
    }

    public void printDetails() {
        System.out.println(getDetailsString());
    }

    private String getDetailsString() {
        return String.format("Журнал: \"%s\" | Автор: %s | Год: %d | Выпуск №%d\n",
                getTitle(), getAuthor(), getYear(), issueNumber);
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return issueNumber == magazine.issueNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), issueNumber);
    }

    @Override
    public String toString() {
        return getDetailsString();
    }
}
