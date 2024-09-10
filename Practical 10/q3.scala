object BankingApp {

  class Account(var balance: Double) {

    def deposit(amount: Double): Unit = {
      if (amount > 0) {
        balance += amount
        println(
          s"Successfully deposited $$${amount}. Current balance: $$${balance}."
        )
      } else {
        println("Deposit amount must be greater than zero.")
      }
    }

    def withdraw(amount: Double): Unit = {
      if (amount > 0 && amount <= balance) {
        balance -= amount
        println(
          s"Successfully withdrew $$${amount}. Current balance: $$${balance}."
        )
      } else if (amount > balance) {
        println(s"Insufficient funds. Your current balance is $$${balance}.")
      } else {
        println("Withdraw amount must be greater than zero.")
      }
    }

    def transfer(toAccount: Account, amount: Double): Unit = {
      if (amount > 0 && amount <= balance) {
        this.withdraw(amount)
        toAccount.deposit(amount)
        println(s"Successfully transferred $$${amount} to the other account.")
      } else {
        println(
          "Transfer failed due to insufficient balance or invalid amount."
        )
      }
    }

    override def toString: String = s"Account balance: $$${balance}"
  }

  def main(args: Array[String]): Unit = {
    val account1 = new Account(1000)
    val account2 = new Account(500)

    account1.deposit(200)
    account1.withdraw(150)
    account1.transfer(
      account2,
      300
    )

    println(account1)
    println(account2)
  }
}
