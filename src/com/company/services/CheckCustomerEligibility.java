package com.company.services;

import com.company.Customer;

import java.util.ArrayList;

public interface CheckCustomerEligibility {
    void approvedCustomerList(ArrayList<Customer> customerArrayList);
    void getServiceAccountCustomers();
}


