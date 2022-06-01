package main.model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import main.model.account.Account;
import main.model.account.Chequing;
import main.model.account.impl.Taxable;

public class Bank {
    public ArrayList<Account> accounts;
    public ArrayList<Transaction> transactions;


    public Bank()
    {
        this.accounts = new ArrayList<Account>();
        this.transactions = new ArrayList<Transaction>();
    }


    public void addAccount(Account account)
    {
        this.accounts.add(account.clone());
    }


    private void addTransaction(Transaction transaction)
    {
        this.transactions.add(new Transaction(transaction));
    }


    public Transaction[] getTransactions(String accoundId)
    {
        List<Transaction> list =  this.transactions.stream()
            .filter((transaction) -> transaction.getId().equals(accoundId))
            .collect(Collectors.toList());
        
        return list.toArray(new Transaction[list.size()]);
    }


    public Account getAccount(String transactionId)
    {
        return accounts.stream()
        .filter((account) -> account.getId().equals(transactionId))
        .findFirst()
        .orElse(null);
    }

    private void withdrawTransaction(Transaction t)
    {
        if(getAccount(t.getId()).withdraw(t.getAmount()))
            addTransaction(t);
    }

    private void depositTransaction(Transaction t)
    {
        getAccount(t.getId()).deposit(t.getAmount());
        addTransaction(t);
    }

    public void executeTransaction(Transaction transaction)
    {
        if(transaction.getType().toString().equals(transaction.getType().toString()))
            withdrawTransaction(transaction);
        else
            depositTransaction(transaction);    
    }


    private double getIncome(Taxable account)
    {
        Transaction[] transactions = getTransactions(((Chequing)account).getId());
        return Arrays.stream(transactions)
        .mapToDouble((transaction) -> {
            switch(transaction.getType())
            {
                case WITHDRAW: return - transaction.getAmount(); 
                case DEPOSIT: return transaction.getAmount();
                default: return 0;
            }
        })
        .sum();       
    }  


    public void deductTaxes()
    {
        for (Account account : accounts) {
            if(Taxable.class.isAssignableFrom(account.getClass())) {
                Taxable taxable = (Taxable)account;
                taxable.tax(getIncome(taxable));
            }
        }
    }

    
}
