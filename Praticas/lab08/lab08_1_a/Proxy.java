package lab08_1_a;

public class Proxy implements BankAccount {
    private BankAccountImpl bankAccount;
    
    public Proxy(String bank, double initialDeposit) {
		this.bankAccount =  new BankAccountImpl(bank, initialDeposit);
		}
        
    public String getBank() {
        return this.bankAccount.getBank();
    }
    

    @Override
    public void deposit(double amount) {
        this.bankAccount.deposit(amount);    
    }

    @Override
    public boolean withdraw(double amout) {
        // só o owner da conta é que pode
        if (Company.user == User.OWNER) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public double balance() {
        if (Company.user == User.OWNER) {
            return this.bankAccount.balance();
        }
        else {
            return Double.NaN;
        }
    }
}
