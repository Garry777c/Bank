package com.company;
import com.company.services.BusinessAccountService;
import com.company.services.CheckCustomerEligibility;
import com.company.services.RetirementAccountService;


import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Banking {

    public static void main(String[] args) throws Exception {


        String name, lastname, sex;
        boolean isCanadianResident, goodCreditScore;
        int age, lastMonthSpentAmount;

        //creating customer
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Customer> customerList = new ArrayList<>();

        do {
            System.out.println("Enter name:");
            name = reader.readLine();

            System.out.println("Enter lastname:");
            lastname = reader.readLine();

            System.out.println("Enter gender:");
            sex = reader.readLine();

            //enter & check age is integer
            while (true) {
                System.out.println("Enter age:");
                age = 0;
                try {
                    age = Integer.parseInt(reader.readLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter number...");
                }
            }

            System.out.println("Canadian resident? \"yes\" or \"no\"");
            isCanadianResident = answerCheck(reader.readLine());

            System.out.println("Good credit score? \"yes\" or \"no\"...");
            goodCreditScore = answerCheck(reader.readLine());

            //enter & check lastMonthSpentAmount is integer
            while (true) {
                System.out.println("How much spent last month?");
                lastMonthSpentAmount = 0;
                try {
                    lastMonthSpentAmount = Integer.parseInt(reader.readLine());
                    break;
                } catch (NumberFormatException e){
                    System.out.println("Please enter number...");
                }
            }
            //finishing entering
            System.out.println("Hit \"Enter\" when you done...");
            System.out.println("Or hit \"Space\" & \"Enter\" if you want to add another customer...");

            //adding new user into customerList
            customerList.add(new Customer(name, lastname, sex, age, isCanadianResident, goodCreditScore, lastMonthSpentAmount));

        } while (!reader.readLine().isEmpty());

        //print customer's info from the customerList
        for (Customer user : customerList) {
            user.printCustomerInfo();
            System.out.println("___________________________");
        }

        //creating business accounts list and print it
        BusinessAccountService business = new BusinessAccountService(18, 70);
        business.approvedCustomerList(customerList);
        business.getServiceAccountCustomers();

        //creating retirement account list and print it
        RetirementAccountService retirement = new RetirementAccountService(75);
        retirement.approvedCustomerList(customerList);
        retirement.getServiceAccountCustomers();



    }


        //check Yes/No answer
        public static boolean answerCheck (String answer) {
            return "yes".equalsIgnoreCase(answer);
        }




}
