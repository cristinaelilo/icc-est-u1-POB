package controllers;

import models.Person;

public class SortingMethods {

    public void sortByNameWithBubble(Person[] persons) {
        for (int i = 0; i < persons.length - 1; i++) {
            for (int j = 0; j < persons.length - i - 1; j++) {
                if (persons[j].getName().compareTo(persons[j + 1].getName()) > 0) {
                    Person temp = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = temp;
                }
            }
        }
    }

    public void sortByNameWithSelectionDes(Person[] persons) {
        for (int i = 0; i < persons.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < persons.length; j++) {
                if (persons[j].getName().compareTo(persons[maxIndex].getName()) > 0) {
                    maxIndex = j;
                }
            }
            Person temp = persons[maxIndex];
            persons[maxIndex] = persons[i];
            persons[i] = temp;
        }
    }

    public void sortByAgeWithInsertion(Person[] persons) {
        for (int i = 1; i < persons.length; i++) {
            Person key = persons[i];
            int j = i - 1;
            while (j >= 0 && persons[j].getAge() > key.getAge()) {
                persons[j + 1] = persons[j];
                j--;
            }
            persons[j + 1] = key;
        }
    }

    public void sortByNameWithInsertion(Person[] persons) {
        for (int i = 1; i < persons.length; i++) {
            Person key = persons[i];
            int j = i - 1;
            while (j >= 0 && persons[j].getName().compareTo(key.getName()) > 0) {
                persons[j + 1] = persons[j];
                j--;
            }
            persons[j + 1] = key;
        }
    }
}
