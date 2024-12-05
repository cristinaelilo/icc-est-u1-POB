package views;

import java.util.Scanner;
import models.Person;

public class View {
    private Scanner scanner = new Scanner(System.in);

    public int showMenu() {
        System.out.println("1. Agregar Persona");
        System.out.println("2. Ordenar Personas");
        System.out.println("3. Buscar Persona");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public Person inputPerson() {
        System.out.print("Ingrese el nombre: ");
        String name = scanner.next();
        System.out.print("Ingrese la edad: ");
        int age = scanner.nextInt();
        return new Person(name, age);
    }

    public int selectSortingMethod() {
        System.out.println("Seleccione el método de ordenamiento:");
        System.out.println("1. Ordenamiento de Burbuja por Nombre");
        System.out.println("2. Ordenamiento por Selección (Descendente) por Nombre");
        System.out.println("3. Ordenamiento por Inserción por Edad");
        System.out.println("4. Ordenamiento por Inserción por Nombre");
        System.out.print("Seleccione por favor: ");
        return scanner.nextInt();
    }

    public int selectSearchCriterion() {
        System.out.println("Seleccione el criterio de búsqueda:");
        System.out.println("1. Búsqueda Binaria por Edad");
        System.out.println("2. Búsqueda Binaria por Nombre");
        System.out.print("Seleccione por favor: ");
        return scanner.nextInt();
    }

    public void displayPersons(Person[] persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    public void displaySearchResult(Person person) {
        if (person != null) {
            System.out.println("Persona encontrada: " + person);
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    public int inputAge() {
        System.out.print("Ingrese la edad para buscar: ");
        return scanner.nextInt();
    }

    public String inputName() {
        System.out.print("Ingrese el nombre para buscar: ");
        return scanner.next();
    }
}
