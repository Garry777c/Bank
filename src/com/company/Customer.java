package com.company;

import java.util.ArrayList;

public class Customer extends HumanBeing {

    //customer fields
    private boolean isCanadianResident;
    private boolean goodCreditScore;
    private int lastMonthSpentAmount;
    private boolean BusinessAccount;
    private boolean retirementAccount;

    //List of family members who are not customers of the Bank
    ArrayList<FamilyMember> list;

    //constructor

    public Customer(String name, String lastName, String sex, int age, boolean isCanadianResident, boolean goodCreditScore, int lastMonthSpentAmount) {
        super(name, lastName, sex, age);
        this.isCanadianResident = isCanadianResident;
        this.goodCreditScore = goodCreditScore;
        this.lastMonthSpentAmount = lastMonthSpentAmount;
    }

    //getters

    public boolean isCanadianResident() {
        return isCanadianResident;
    }

    public boolean isGoodCreditScore() {
        return goodCreditScore;
    }

    public int getLastMonthSpentAmount() {
        return lastMonthSpentAmount;
    }

    public boolean isBusinessAccount() {
        return BusinessAccount;
    }

    public boolean isRetirementAccount() {
        return retirementAccount;
    }

    //setters
    public void setCanadianResident(boolean canadianResident) {
        isCanadianResident = canadianResident;
    }

    public void setGoodCreditScore(boolean goodCreditScore) {
        this.goodCreditScore = goodCreditScore;
    }

    public void setLastMonthSpentAmount(int lastMonthSpentAmount) {
        this.lastMonthSpentAmount = lastMonthSpentAmount;
    }

    public void setBusinessAccount(boolean businessAccount) {
        BusinessAccount = businessAccount;
    }

    public void setRetirementAccount(boolean retirementAccount) {
        this.retirementAccount = retirementAccount;
    }

    //promo check
    public boolean checkPromoAvailability (int lastMonthSpentAmount){
        return lastMonthSpentAmount>5000;
    }

    //adding family members
    public void addFamilyMember (FamilyMember newMember){
        this.list.add(newMember);
    }




    //Print customer info
    public void printCustomerInfo(){
        System.out.println("Customer name/lastname: " + getName() + " " + getLastName());
        System.out.println("Customer age/gender: " + getAge() + " years, " + getSex());
        System.out.println("Customer resident status: " + (isCanadianResident()? "Canadian":"nonCanadian"));
        System.out.println("Customer Credit Score status: " + (isGoodCreditScore()? "Good":"Not good"));
        System.out.println("Customer last month amount spent: " + getLastMonthSpentAmount());
        System.out.println("Promo eligible: " + (checkPromoAvailability(getLastMonthSpentAmount())? "Yes":"No"));
    }


}
