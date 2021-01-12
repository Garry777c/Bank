package com.company.services;

import com.company.Customer;

import java.util.ArrayList;

public class RetirementAccountService implements CheckCustomerEligibility{
    private int retirementAge;
    ArrayList<Customer> retirementCustomerList = new ArrayList<>();

    //constructor
    public RetirementAccountService(int retirementAge) {
        this.retirementAge = retirementAge;
    }

    //set of setters & getters
    public int getRetirementAge() {
        return retirementAge;
    }
    public void setRetirementAge(int retirementAge) {
        this.retirementAge = retirementAge;
    }


    //pulling existed customerList and check if each customer matches retirement account specs
    @Override
    public void approvedCustomerList(ArrayList<Customer> customerArrayList) {
        for (Customer customer : customerArrayList) {
            if ((customer.getAge() >= this.retirementAge) && (customer.isCanadianResident()) && (customer.isGoodCreditScore())) {
                customer.setRetirementAccount(true);
                this.retirementCustomerList.add(customer);
            }
        }
    }

    @Override
    public void getServiceAccountCustomers() {

        System.out.println("!-Retirement Account List-!");
        System.out.println("");
        try {
            for (Customer customer : retirementCustomerList) {
                customer.printCustomerInfo();
                System.out.println("Retirement account status: " + (customer.isRetirementAccount() ? "Yes" : "No"));
                System.out.println("_________________________");
                break;
            }
        } catch (NullPointerException e) {
            System.out.println("- List is empty -");
        }
    }
}
