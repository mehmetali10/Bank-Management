package main.model.account;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public abstract class Account {

    protected String id;
    protected String name;
    protected double balance;


    public Account(String id, String name, double balance)
    {
        checkParam(id);
        checkParam(name);
        this.id = id;
        this.name = name;
        this.balance = balance;
    }


    public Account(Account account) 
    {
        this.id = account.id;
        this.name = account.name;
        this.balance = account.balance;
    }


    public abstract void deposit(double amount);
    public abstract boolean withdraw(double amount);
    public abstract Account clone();

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public double getBalance()
    {
        return round(balance);
    }

    public void setId(String id)
    {
        checkParam(id);
        this.id = id;
    }

    public void setName(String name)
    {
        checkParam(name);
        this.name = name;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public void checkParam(String param)
    {
        if(param.equals(null) || param.isBlank()) 
            throw new IllegalArgumentException(param + " cannot be null/blank");
    }

    protected double round(double amount) 
    {
        DecimalFormat formatter = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.ENGLISH));
        return Double.parseDouble(formatter.format(amount));
    }

    @Override
    public String toString()
    {
        return (this.getClass().getSimpleName()) + "    " +
            "\t" + this.id + "" +
            "\t" + this.name + "" +
            "\t$" + this.balance + "";
    }
}
