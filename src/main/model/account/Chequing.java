package main.model.account;

import main.model.account.impl.Taxable;

public class Chequing extends Account implements Taxable{ 
    
    private static final double OVERDRAFT_LIMIT = 200.00;
    private static final double OVERDRAFT_FEE = 5.50;
    private static final double TAXABLE_INCOME = 3000;
    private static final double TAX_RATE = 0.15;

    public Chequing(String id, String name, double balance) 
    {
        super(id, name, balance);
    }

    public Chequing(Chequing c) 
    {
        super(c);
    }


    @Override
    public void deposit(double amount)
    {
        super.setBalance(super.round(super.getBalance() + amount));
    }


    @Override
    public boolean withdraw(double amount) {
        if((amount - balance) > OVERDRAFT_LIMIT)
        {
            return false;
        }
        else
        {
            if(amount > balance)
            {
                setBalance(round(getBalance()-amount-OVERDRAFT_FEE));
                return true;
            }
            else 
            {
                setBalance(getBalance() -amount);
                this.balance -= amount;
                return true;
            }
        }    
    }


    @Override
    public void tax(double income)
    {
        double tax = Math.max(0, income-TAXABLE_INCOME) * TAX_RATE; 
        super.setBalance(super.round(super.getBalance() - tax));   
    }


    @Override
    public Account clone()
    {
        return new Chequing(this);
    }

}