package main.model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;


public class Transaction implements Comparable<Transaction> {
    public enum Type { WITHDRAW , DEPOSIT };
    private long timestamp;
    private String id;
    private double amount;
    private Type type;

    
    public Transaction(Type t, long timestamp, String id, double amount)
    {
        if(id == null || id.isBlank()) 
            throw new IllegalArgumentException("id cannot be null/blank");
        if(amount < 0)
            throw new IllegalArgumentException("amount cannot be negative");    
        this.type = t;
        this.timestamp = timestamp;
        this.id = id;
        this.amount = amount;
    }

    public Transaction(Transaction source)
    {
        this.type = source.type;
        this.timestamp = source.timestamp;
        this.id = source.id;
        this.amount = source.amount;
    }


    public long getTimestamp()
    {
        return this.timestamp;
    }


    public void setTimestamp(long timestamp)
    {
        this.timestamp = timestamp;
    }


    public String getId()
    {
        return this.id;
    }


    public void setId(String id)
    {
        if(id == null || id.isBlank()) 
            throw new IllegalArgumentException("id cannot be null/blank");
        this.id = id;
    }


    public double getAmount()
    {
        return this.amount;
    }


    public void setAmount(double amount)
    {
        if(amount < 0)
            throw new IllegalArgumentException("amount cannot be negative"); 
        this.amount = amount;
    }


    public void setType(Type type)
    {
        this.type = type;
    }


    public Type getType()
    {
        return type;
    }


    public String returnDate() {
        Date date = new Date(this.timestamp * 1000);
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }


    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof Transaction))
            return false;

        Transaction t = (Transaction) obj;
        return  this.getType().equals(t.getType()) &&
                this.timestamp == t.timestamp &&
                this.id.equals(t.id)&&
                this.amount == t.amount;
    }


    @Override
    public int hashCode() {
        return Objects.hash(type, timestamp, id, amount);
    }


    @Override
    public String toString() {
        return (type) + "    " +
            "\t" + this.returnDate() + "" +
            "\t" + this.id + "" +
            "\t$" + this.amount + "";
    }

    @Override
    public int compareTo(Transaction o) {
        if(!(o instanceof Transaction))
            throw new IllegalArgumentException("param must be instance of Transaction class");
        Transaction t = (Transaction) o;
        return Double.compare(this.getTimestamp(), t.getTimestamp());
    }
    
}
