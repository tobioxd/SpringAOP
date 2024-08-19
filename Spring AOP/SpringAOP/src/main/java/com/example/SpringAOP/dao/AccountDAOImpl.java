package com.example.SpringAOP.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.SpringAOP.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;
    private String serviceCode;

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");

    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {
        
        return findAccounts(false);

    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        // simulate an exception
        if (tripWire) {
            throw new RuntimeException("No soup for you!!!");
        }
        
        List<Account> result = new ArrayList<>();

        // create sample accounts

        Account temp1 = new Account("tedomi", "Silver");
        Account temp2 = new Account("tobioxd", "Platinum");
        Account temp3 = new Account("zommy", "Gold");

        // add them to our accounts list
        result.add(temp1);
        result.add(temp2);
        result.add(temp3);

        return result;

    }

}
