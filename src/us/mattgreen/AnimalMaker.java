package us.mattgreen;

import java.util.ArrayList;
import java.util.Scanner;

public class AnimalMaker {
    private Scanner keyboard = new Scanner(System.in);
    private ArrayList<Talkable> zoo;
    public AnimalMaker(ArrayList<Talkable> zoo) {
        this.zoo = zoo;
    }

    public void AddAnimal() {
        boolean validEntry = false;

        System.out.println("What type of animal would you like to create?");
        DisplayChoices();

        while (!validEntry) {
            String input = keyboard.nextLine();

            if (input.equalsIgnoreCase("cat")) {
                zoo.add(ConstructCat());
                validEntry = true;
            } else if (input.equalsIgnoreCase("dog")) {
                zoo.add(ConstructDog());
                validEntry = true;
            } else if (input.equalsIgnoreCase("teacher")) {
                zoo.add(ConstructTeacher());
                validEntry = true;
            } else {
                System.out.println("Please enter one of the choices.");
                DisplayChoices();
            }
        }
    }

    private void DisplayChoices() {
        System.out.println("Cat");
        System.out.println("Dog");
        System.out.println("Teacher");
    }

    private Cat ConstructCat() {
        boolean validDetail = false;
        String name = PromptForName("cat");

        int mousesKilled = 0;
        System.out.println("How many mouses has " + name + " killed? (positive integers or 0 only)");
        while (!validDetail) {
            String input = keyboard.nextLine();

            try {
                int inputAsInt = Integer.parseInt(input);
                if (inputAsInt < 0) {
                    System.out.println("Cat's can't kill negative amounts of mouses. Please enter a positive integer or 0.");
                } else {
                    mousesKilled = inputAsInt;
                    validDetail = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a positive integer or 0.");
            }
        }

        return new Cat(mousesKilled, name);
    }

    private Dog ConstructDog() {
        boolean validDetail = false;
        String name = PromptForName("dog");

        boolean friendly = false;
        System.out.println("Is " + name + " friendly? (yes or no)");
        while (!validDetail) {
            String input = keyboard.nextLine();

            if (input.equalsIgnoreCase("yes")) {
                friendly = true;
                validDetail = true;
            } else if (input.equalsIgnoreCase("no")) {
                validDetail = true;
            } else {
                System.out.println("This is a yes or no question. Is " + name + " friendly?");
            }
        }

        return new Dog(friendly, name);
    }

    private Teacher ConstructTeacher() {
        boolean validDetail = false;
        String name = PromptForName("teacher");

        int age = 0;
        System.out.println("How old is " + name + "? (positive integers or 0 only)");
        while (!validDetail) {
            String input = keyboard.nextLine();

            try {
                int inputAsInt = Integer.parseInt(input);
                if (inputAsInt < 0) {
                    System.out.println("Time only goes forward. Please enter a positive integer or 0.");
                } else {
                    age = inputAsInt;
                    validDetail = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a positive integer or 0.");
            }
        }

        return new Teacher(age, name);
    }

    private String PromptForName(String animalType) {
        boolean validDetail = false;
        String name = "";
        System.out.println("What is the " + animalType + "'s name? (minimum two characters)");
        while (!validDetail) {
            String input = keyboard.nextLine();

            if (input.length() < 2) {
                System.out.println("Names must be a minimum of two characters. What is the " + animalType + "'s name?");
            } else {
                name = input;
                validDetail = true;
            }
        }
        return name;
    }
}
