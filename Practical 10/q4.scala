class Account(var balance: Double) {

  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
    }
  }

  def transfer(toAccount: Account, amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      this.withdraw(amount)
      toAccount.deposit(amount)
    }
  }

  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05
    } else if (balance < 0) {
      balance += balance * 0.1
    }
  }

  override def toString: String = s"Account balance: $$${balance}"
}

class Bank(val accounts: List[Account]) {

  def negativeBalanceAccounts: List[Account] = {
    accounts.filter(account => account.balance < 0)
  }

  def totalBalance: Double = {
    accounts.map(_.balance).sum
  }

  def applyInterestToAll(): Unit = {
    accounts.foreach(_.applyInterest())
  }

  def printAllBalances(): Unit = {
    accounts.foreach(account => println(account))
  }
}

object BankApp {
  def main(args: Array[String]): Unit = {
    // Creating a few accounts with different balances
    val acc1 = new Account(1000) // Positive balance
    val acc2 = new Account(-200) // Negative balance
    val acc3 = new Account(300) // Positive balance
    val acc4 = new Account(-50) // Negative balance

    val bank = new Bank(List(acc1, acc2, acc3, acc4))

    println("Accounts with negative balances:")
    bank.negativeBalanceAccounts.foreach(account => println(account))

    val finalbalance = bank.totalBalance
    println(s"\nTotal balance of all accounts: $finalbalance")

    bank.applyInterestToAll()
    println("\nFinal account balances after applying interest:")
    bank.printAllBalances()
  }
}
