package Saiket_Internship.Task3; // Defines the package location of the class.

import java.util.ArrayList; // Imports the ArrayList class to store tasks dynamically.
import java.util.Scanner;

public class ToDoList {
    private static ArrayList<String> tasks = new ArrayList<String>(); // Creates a dynamic list named tasks to hold all to-do items
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false; // Declares a flag variable to control program exit.

        // Keeps running the menu until the user chooses to exit.
        while (!exit) {

            // Used to add colors in console output (e.g., Green, Yellow, Cyan, etc.).
            System.out.println("\u001B[36m===== TO-DO LIST MENU =====\u001B[0m");
            System.out.println("\u001B[33m1. Add Task\u001B[0m");
            System.out.println("\u001B[33m2. View Tasks\u001B[0m");
            System.out.println("\u001B[33m3. Remove Task\u001B[0m");
            System.out.println("\u001B[33m4. Exit\u001B[0m");
            System.out.print("\u001B[35mChoose an option: \u001B[0m");

            int choice = sc.nextInt(); // Takes the user's menu choice as input.
            sc.nextLine(); // Consume newline


            // Decision-making block to perform different operations based on user choice.
            switch (choice) {
                case 1:
                    addTask(); // Calls the method to add a new task.
                    break;
                case 2:
                    viewTasks(); // Displays all stored tasks.
                    break;
                case 3:
                    removeTask(); // Removes the task at a specific position.
                    break;
                case 4:
                    exit = true; // Ends the loop when user chooses option 4.
                    System.out.println("\u001B[32mExiting To-Do List... Goodbye!\u001B[0m");
                    break;
                default:
                    System.out.println("\u001B[31mInvalid choice! Please try again.\u001B[0m");
            }
        }
        sc.close(); // Closes the scanner object to free resources.
    }


    //  Takes task input and adds it to the ArrayList.
    private static void addTask() {
        System.out.print("\u001B[36mEnter task: \u001B[0m");
        String task = sc.nextLine();
        tasks.add(task);
        System.out.println("\u001B[32mTask added successfully!\u001B[0m");
    }

    //  Displays all the tasks in a numbered format.
    private static void viewTasks() {
        System.out.println("\u001B[34m==== Your Tasks ====\u001B[0m");

        if (tasks.isEmpty()) {
            System.out.println("\u001B[31mNo tasks found!\u001B[0m");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println("\u001B[33m" + (i + 1) + ". " + tasks.get(i) + "\u001B[0m");
            }
        }
    }


    // Deletes a task based on the user-entered index number.
    private static void removeTask() {
        System.out.print("\u001B[36mEnter task number to remove: \u001B[0m");
        int taskNumber = sc.nextInt();

        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            String removedTask = tasks.remove(taskNumber - 1);
            System.out.println("\u001B[32mTask '" + removedTask + "' removed successfully!\u001B[0m");
        } else {
            System.out.println("\u001B[31mInvalid task number! Try again.\u001B[0m");
        }
    }
}

