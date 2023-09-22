import controller.PersonController;
import model.Person;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        PersonController pc = new PersonController();
        pc.readPerson(1);
    }
}