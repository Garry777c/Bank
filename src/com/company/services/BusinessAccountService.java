package com.company.services;

import com.company.Customer;

import java.util.ArrayList;

public class BusinessAccountService implements CheckCustomerEligibility{
    //default values
    private int ageMin;
    private int ageMax;

    private ArrayList<Customer> businessAccountCustomerList = new ArrayList<>();

    public BusinessAccountService(int ageMin, int ageMax) {
        this.ageMin = ageMin;
        this.ageMax = ageMax;

        System.out.println("Business accounts specs have been created.");
    }
    //set of setters and getters
    public int getAgeMin() {
        return ageMin;
    }
    public void setAgeMin(int ageMin) {
        this.ageMin = ageMin;
    }

    public int getAgeMax() {
        return ageMax;
    }
    public void setAgeMax(int ageMax) {
        this.ageMax = ageMax;
    }

    //pulling existed customerList and check if each customer matches business account specs
    @Override
    public void approvedCustomerList(ArrayList<Customer> customerArrayList) {
        for (Customer customer : customerArrayList) {
            if ((customer.getAge() >= this.ageMin) && (customer.getAge() <= this.ageMax) &&
                    (customer.isCanadianResident()) && (customer.isGoodCreditScore())) {
                customer.setBusinessAccount(true);
                this.businessAccountCustomerList.add(customer);
            }
        }
    }

     //get users with Business account
        @Override
        public void getServiceAccountCustomers(){

            System.out.println("$-Business Account List-$");
            System.out.println("");
             try {
                         for (Customer customer : businessAccountCustomerList) {
                             customer.printCustomerInfo();
                             System.out.println("Business account status: " + (customer.isBusinessAccount() ? "Yes" : "No"));
                             System.out.println("_________________________");
                             break;
                         }
                 } catch (NullPointerException e) {
                 System.out.println("- List is empty -");
             }
        }



}
