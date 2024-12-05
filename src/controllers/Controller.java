package controllers;

import java.util.ArrayList;
import java.util.List;
import models.Person;
import views.View;

public class Controller {
    private View view;
    private List<Person> persons;
    private SortingMethods sortingMethods;
    private SearchMethods searchMethods;

    public Controller(View view, SortingMethods sortingMethods, SearchMethods searchMethods) {
        this.view = view;
        this.persons = new ArrayList<>();
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods;
    }

    public void start() {
        boolean running = true;
        while (running) {
            int choice = view.showMenu();
            switch (choice) {
                case 1 -> inputPersons();
                case 2 -> sortPersons();
                case 3 -> searchPerson();
                case 4 -> running = false;
                default -> System.out.println("Opción no válida. Intentar otra vez.");
            }
        }
    }

    public void inputPersons() {
        Person person = view.inputPerson();
        persons.add(person);
    }

    public void sortPersons() {
        if (persons.isEmpty()) {
            System.out.println("No hay personas para clasificar.");
            return;
        }
        int method = view.selectSortingMethod();
        Person[] personArray = persons.toArray(new Person[0]);
        switch (method) {
            case 1 -> sortingMethods.sortByNameWithBubble(personArray);
            case 2 -> sortingMethods.sortByNameWithSelectionDes(personArray);
            case 3 -> sortingMethods.sortByAgeWithInsertion(personArray);
            case 4 -> sortingMethods.sortByNameWithInsertion(personArray);
            default -> System.out.println("Método de clasificación no válido.");
        }
        persons.clear();
        for (Person person : personArray) {
            persons.add(person);
        }
        view.displayPersons(personArray);
    }

    public void searchPerson() {
        if (persons.isEmpty()) {
            System.out.println("No hay personas para buscar.");
            return;
        }
        int criterion = view.selectSearchCriterion();
        Person[] personArray = persons.toArray(new Person[0]);
        Person result = null;
        switch (criterion) {
            case 1 -> {
                if (!searchMethods.isSortedByAge(personArray)) {
                    System.out.println("La matriz no está ordenada por edad.");
                    sortingMethods.sortByAgeWithInsertion(personArray);
                }
                int age = view.inputAge();
                result = searchMethods.binarySearchByAge(personArray, age);
            }
            case 2 -> {
                if (!searchMethods.isSortedByName(personArray)) {
                    System.out.println("La matriz no está ordenada por nombre.");
                    sortingMethods.sortByNameWithBubble(personArray);
                }
                String name = view.inputName();
                result = searchMethods.binarySearchByName(personArray, name);
            }
            default -> System.out.println("Criterio de búsqueda no válido.");
        }
        view.displaySearchResult(result);
    }
}
