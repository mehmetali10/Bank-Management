# Bank Management Console Application
This is a Java console application that allows users to manage three types of accounts: Chequing Account, Savings Account, and Loan Account.

## Chequing Account
A chequing account contains an id, name, and balance. It allows users to deposit or withdraw an amount of money. The chequing account charges an overdraft fee of $5.50 if the amount being withdrawn exceeds the account balance. The overdraft limit is $200.00 dollars. A chequing account is taxable. Income that exceeds $3,000 is taxed 15%.

### Functionality
<li>Create a new Chequing Account</li>
<li>Deposit money into a Chequing Account</li>
<li>Withdraw money from a Chequing Account</li>
<li>Apply an overdraft fee of $5.50 if the amount being withdrawn exceeds the account balance and overdraft limit</li>
<li>Deduct taxes from a Chequing Account if income exceeds $3,000</li>
<br />

## Savings Account
A savings account contains an id, name, and balance. It allows users to deposit or withdraw an amount of money. Deposits are free, but the savings account charges a $5.00 fee for every withdrawal.

### Functionality
<li>Create a new Savings Account</li>
<li>Deposit money into a Savings Account</li>
<li>Withdraw money from a Savings Account</li>
<li>Apply a $5.00 fee for every withdrawal from a Savings Account</li>
<br />

## Loan Account
A loan account contains an id, name, and balance. It allows users to deposit or withdraw an amount of money. A withdrawal can't be made if the debt exceeds $10,000. Every withdrawal is charged a fixed interest rate of 2%.

### Functionality
<li>Create a new Loan Account</li>
<li>Deposit money into a Loan Account</li>
<li>Withdraw money from a Loan Account</li>
<li>Apply a fixed interest rate of 2% to every withdrawal from a Loan Account</li>
<li>Prevent a withdrawal if the debt exceeds $10,000</li>
<br />

## Transaction
An account transaction can be: WITHDRAW or DEPOSIT. Every transaction has an id, amount, and timestamp. Transactions must be sorted based on timestamp. A transaction's timestamp must display to the user as a readable date.

### Functionality
<li>Create a new Transaction</li>
<li>Display all Transactions for an Account</li>
<li>Sort Transactions by timestamp</li>
<li>Display a Transaction's timestamp as a readable date</li>
<br />

## Bank
The bank keeps a record of every account created and transaction made. The id of a transaction matches the id of an account. Depending on the account, some transactions may be denied. The bank can deduct taxes from taxable accounts.

### Functionality
<li>Create a new Bank</li>
<li>Add an Account to the Bank</li>
<li>Add a Transaction to an Account in the Bank</li>
<li>Deduct taxes from a Chequing Account in the Bank if income exceeds $3,000</li>
<li>Prevent a withdrawal if the debt of a Loan Account exceeds $10,000</li>
<br />

## Contributions
Contributions are welcome! If you find a bug or have a suggestion for an improvement, please open an issue or submit a pull request.
