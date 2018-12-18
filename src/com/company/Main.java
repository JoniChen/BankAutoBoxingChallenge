package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank();
    public static void main(String[] args) {

        boolean quit = false;
        printInstructions();
        while(!quit) {
            System.out.println("\nEnter action: (0 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;

                case 1:
                    bank.printBranches();
                    break;

                case 2:
                    addBranch();
                    break;
//
                case 3:
                    updateBranch();
                    break;
//
                case 4:
                    removeBranch();
                    break;
//
//                case 5:
//                    queryContact();
//                    break;
//
//                case 6:
//                    printActions();
//                    break;
            }

        }

    }

    private static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To view existing Branches.");
        System.out.println("\t 2 - To add a new Branch ");
        System.out.println("\t 3 - To update Branch details. ");
        System.out.println("\t 4 - To remove a Branch.");
        System.out.println("\t 5 - To view existing customers (per Branch)");
        System.out.println("\t 6 - To add a new customer");
        System.out.println("\t 6 - To add a transaction to an existing customer");
        System.out.println("\t 6 - To update contact details (per Branch)");
        System.out.println("\t 7 - To search contact details (per Branch)");
        System.out.println("\t 8 - To quit the application.");
    }

    private static void addBranch() {

        System.out.print("Please enter new Branch name: ");
        String name = scanner.nextLine();
        Branch branch = Branch.createBranch(name);
        if (bank.addBranch(branch)) {

            System.out.println("New branch name: " + branch.getName() +" added successfully");
        } else {
            System.out.println("Add action failed");
        }
    }

    private static void updateBranch() {

        bank.printBranches();
        System.out.println("Enter branch number to update: ");
        String number = scanner.nextLine();
        Branch existingBranch = bank.queryBranch(Integer.valueOf(number));
        if (existingBranch == null) {

            System.out.println("Invalid input");
            return;
        }
        System.out.print("Please enter new name for branch: ");
        String name1 = scanner.nextLine();
        Branch newBranch = Branch.createBranch(name1);

        if (bank.updateBranch(existingBranch, newBranch)) {

            System.out.println("Branch name updated");
        }
    }

    private static void removeBranch() {

        System.out.print("Please enter branch name to delete: ");
        String name = scanner.nextLine();
        if (bank.removeBranch(name)) {

            System.out.println("Branch " + name + " was deleted");
        } else {
            System.out.println("Delete action failed");
        }
    }
}
