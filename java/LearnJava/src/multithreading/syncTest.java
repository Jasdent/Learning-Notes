public class syncTest{
    public static void main(String args[]){
        debitaccount zishen_zhuokun = new debitaccount(500,"zishen","2833160");

        manage_account manager1 = new manage_account("zhuokun",400.00,zishen_zhuokun);
        manage_account manager2 = new manage_account("zishen",200.00,zishen_zhuokun);
        manager1.start();
        manager2.start();


    }

}


class debitaccount extends Thread{
    private double balance;
    private String name;
    private String cardNum;


    public debitaccount(double balance,String name,String cardNum){
        this.balance = balance;
        this.name = name;
        this.cardNum = cardNum;
    }

    public synchronized void withDraw(double amount,String user){
//            try {
//                if (this.balance > amount) {
//                    Thread.sleep(2000);
//                    this.balance -= amount;
//                    System.out.println("Withdraw " + amount + " successful. Remaining balance: " + this.balance + " User: " + user);
//                } else {
//                    System.out.println("Insufficient balance. Balance remaining: " + this.balance);
//                }
//            }catch (InterruptedException e){}
//            ouptut:
//            Thread started.
//            Thread started.
//            Withdraw 200.0 successful. Remaining balance: -100.0 User: zishen
//            Withdraw 400.0 successful. Remaining balance: 100.0 User: zhuokun


//            synchronized (this){
//                try {
//                    if (this.balance > amount) {
//                        Thread.sleep(2000);
//                        this.balance -= amount;
//                        System.out.println("Withdraw " + amount + " successful. Remaining balance: " + this.balance + " User: " + user);
//                    } else {
//                        System.out.println("Insufficient balance. Balance remaining: " + this.balance);
//                    }
//                }catch (InterruptedException e){}

                try {
                    if (this.balance > amount) {
                        Thread.sleep(2000);
                        this.balance -= amount;
                        System.out.println("Withdraw " + amount + " successful. Remaining balance: " + this.balance + " User: " + user);
                    } else {
                        System.out.println("Insufficient balance. Balance remaining: " + this.balance);
                    }
                }catch (InterruptedException e){}

        System.out.println("Testing. "+user);
            }
//        output
//        Thread started.
//        Thread started.
//        Withdraw 400.0 successful. Remaining balance: 100.0 User: zhuokun
//        Insufficient balance. Balance remaining: 100.0




    public void deposite(double amount){
        synchronized (this) {
            this.balance += amount;
            System.out.println("Successful. Remaining balance: " + this.balance);
        }
    }

    public synchronized double getBalance(){

        System.out.println("Remaining balance: "+this.balance);
        return this.balance;
    }



}

class manage_account extends Thread {
    String threadName;
    debitaccount account = null;
    // not conv
    double wthamount;

    public manage_account(String threadName, double wthamount,debitaccount account) {
        this.threadName = threadName;
        this.wthamount = wthamount;
        this.account = account;
    }



    @Override
    public void run() {
        // some predefined actions just for testing

        this.account.withDraw(this.wthamount, this.threadName);



    }
}