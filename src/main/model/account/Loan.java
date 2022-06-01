package main.model.account;


public class Loan extends Account {

    private static final double DEBT_LIMIT = 10000;
    private static final double INTEREST_RATE = 0.02;


    public Loan(String id, String name, double balance)
    {
        super(id, name, balance);
    }


    public Loan(Loan loan)
    {
        super(loan);
    }


    public static double getDebtLimit()
    {
        return DEBT_LIMIT;
    }


    @Override
    public void deposit(double money)
    {
        this.balance -= money;
    }


    @Override
    public boolean withdraw(double amount)
    {
        if((( amount*1.02) + balance) > DEBT_LIMIT)
        {
            return false;
        }
        else
        {
            this.balance += (amount * INTEREST_RATE );
            this.balance += amount;
            return true;
        }       
    }
    

    @Override
    public Account clone()
    {
        return new Loan(this);
    }

    
}
