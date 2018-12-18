package com.company;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    private Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public static Branch createBranch(String name) {

        return new Branch(name);
    }


    public boolean addCustomer(String name , Double initialDeposit) {

        if (findCustomer(name) >= 0){

            System.out.println("Customer already exists");
            return false;
        }
        Customer newCustomer = Customer.createContact(name);
        this.customers.add(newCustomer);
        newCustomer.addTransaction(initialDeposit);
        return true;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public String getName() {
        return name;
    }

    private int findCustomer(Customer customer) {

        return this.customers.indexOf(customer);
    }

    private int findCustomer(String name) {

        for (int i =0; i < this.customers.size(); i++) {

            if (this.customers.get(i).getName().equals(name)) {

                return i;
            }
        }
        return -1;
    }



}
