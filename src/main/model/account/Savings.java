package main.model.account;

public class Savings extends Account {

    private static final double WITHDRAWAL_FEE = 5.00;

    public Savings(String id, String name, double balance)
    {
        super(id, name, balance);
    }


    public Savings(Savings savings)
    {
        super(savings);
    }


    @Override
    public void deposit(double money)
    {
        this.balance += money;
    }


    @Override
    public boolean withdraw(double amount)
    {
        this.balance -= (amount + WITHDRAWAL_FEE);
        return true;
    }

    
    @Override
    public Account clone()
    {
        return new Savings(this);
    }
    
}
