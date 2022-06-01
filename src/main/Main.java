package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import main.model.account.Account;
import main.model.Bank;
import main.model.Transaction;

public class Main {

   static String ACCOUNTS_FILE = "src/main/data/accounts.txt";            
   static String TRANSACTIONS_FILE = "src/main/data/transactions.txt";
   static Bank bank = new Bank();

    public static void main(String[] args) {
        try {
            ArrayList<Account> accounts = returnAccounts();
            loadAccounts(accounts);

            ArrayList<Transaction> transactions = returnTransactions();
            runTransactions(transactions);
            bank.deductTaxes();
            for (Account account : accounts) {
                System.out.println("\n\t\t\t\t\t ACCOUNT\n\n\t"+account+"\n\n");
                transactionHistory(account.getId());
            }
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
        
  
    public static Account createObject(String[] values)
    {
        try{
            return (Account) Class.forName("main.model.account." + values[0])
            .getConstructor(String.class, String.class, double.class)
            .newInstance(values[1], values[2], Double.parseDouble(values[3]));  
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    
    public static ArrayList<Account> returnAccounts() throws Exception
    {
        ArrayList<Account> accounts = new ArrayList<>(); 
        FileInputStream fis = new FileInputStream(ACCOUNTS_FILE);
        Scanner scan  = new Scanner(fis);
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] arr = line.split(",");
            accounts.add(createObject(arr)); 
        }
        scan.close();
        return accounts;
    }


    public static void loadAccounts(ArrayList<Account> accountsList)
    {
        for (Account account : accountsList)
        {
            bank.addAccount(account);
        }
    }


    public static ArrayList<Transaction> returnTransactions() throws FileNotFoundException
    {
        ArrayList<Transaction> t = new ArrayList<>();
        FileInputStream fis = new FileInputStream(TRANSACTIONS_FILE);
        Scanner scan = new Scanner(fis);
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] arr = line.split(",");
            t.add(new Transaction(Transaction.Type.valueOf(arr[1]),Long.parseLong(arr[0]), arr[2], Double.parseDouble(arr[3])));
        }
        scan.close();
        Collections.sort(t);
        return t;
    }


    public static void runTransactions(ArrayList<Transaction> tranactionsList)
    {
        tranactionsList.stream()
        .forEach((transaction) -> bank.executeTransaction(transaction));
    } 


    public static void transactionHistory(String id)
    {
        System.out.println("\t\t\t\t   TRANSACTION HISTORY\n\t");
        Transaction[] arr = bank.getTransactions(id);
        Arrays.stream(arr).forEach((transaction) -> {
            System.out.println("\t"+transaction+"\n");
            wait(300);
        });
        System.out.println("\n\t\t\t\t\tAFTER TAX\n");
        System.out.println("\t" + bank.getAccount(id) +"\n\n\n\n");
    }


    public static void wait(int milliseconds)
    {
        try {
           TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    

}