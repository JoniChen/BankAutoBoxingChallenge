package com.company;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public boolean addCustomer(String name , Double initialDeposit) {

        if (findCustomer(name)){

            Customer newCustomer = new Customer(name);
            this.customers.add(newCustomer);
            newCustomer.addTransaction(initialDeposit);
        }
        return false;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public String getName() {
        return name;
    }

    private boolean findCustomer(String name) {

        for (int i =0; i < this.customers.size(); i++) {

            if (this.customers.get(i).getName().equals(name)) {

                return true;
            }
        }
        return false;
    }
}
