package com.company;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public Bank() {

        this.branches = new ArrayList<>();
    }


    public boolean addBranch(Branch branch) {

        if (findBranch(branch.getName().toLowerCase()) >= 0) {

            System.out.println("Branch name already on file");
            return false;
        }

        this.branches.add(branch);
        return true;
    }

    private int findBranch(Branch branch) {

        return this.branches.indexOf(branch);
    }

    private Branch findBranch(int index) {

        return this.branches.get(index);
    }

    private int findBranch(String name) {

        for (int i =0; i < this.branches.size(); i++) {

            if (this.branches.get(i).getName().toLowerCase().equals(name)) {

                return i;
            }
        }
        return -1;
    }

    public boolean removeBranch(String name) {

        int position = findBranch(name.toLowerCase());

        if (position >=0 ){

            this.branches.remove(position);
            return true;
        }
        System.out.println("Cannot find branch name: "+ name);
        return false;
    }

    public boolean updateBranch(Branch oldName , Branch newName) {

        int position = findBranch(oldName);

        if (position < 0){

            return false;
        } else if (findBranch(oldName) != -1) {

            System.out.println("New name already exists. update failed");
            return false;
        }

        this.branches.set(position,newName);
        return true;
    }

    public Branch queryBranch(Branch branch) {

        int position = findBranch(branch);

        if (findBranch(branch) >= 0 ) {

            return this.branches.get(position);
        }

        return null;
    }

    public Branch queryBranch(int index) {

        Branch branch = this.branches.get(index);

        if (branch == null) {

            return null;
        }

        return null;
    }

    public void printBranches() {

        System.out.println("Found " + this.branches.size()+ " branches in list");

        for (int i=0; i< this.branches.size(); i++) {

            System.out.println((i+1) + ". " + this.branches.get(i).getName());
        }
    }
}
