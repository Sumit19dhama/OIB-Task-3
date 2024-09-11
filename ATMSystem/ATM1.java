import java.util.*;

class userauth {
    static void login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name:" + "");
        String Name = sc.nextLine();
        System.out.print("Enter your password:" + "");
        String password = sc.nextLine();

        if(Name==ATM1.userName && password==ATM1.pass){
            ATM1.showMenu();
        } 
        else {
            System.out.println("invalid authentication!Please try again");
            System.out.println("---------------------------");
            System.out.println("Please signup!");
            bankinfo.signup();
        }
    }
}

class bankinfo {
    static  void signup(){

        Scanner sc=new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.print("Enter username :" + "");
        ATM1.userName=sc.nextLine();
        System.out.print("Enter password :" + "");
        ATM1.pass=sc.nextLine();
        System.out.print("Enter your Account number :" + "");
        ATM1.accnumber=sc.nextLine();
        System.out.println("REGISTRATION SUCCESSFULLY!");
        System.out.println("---------------------------");

        ATM1.showMenu();

    }
}

class hist{
    static void showTransactionHistory() {
        if (ATM1.transactionHistory.isEmpty()) {
            System.out.println("No transactions made yet.");
        } else {
            System.out.println("-------------------------------");
            System.out.println("    Transaction History:");
            System.out.println("-------------------------------");

            for (String transaction : ATM1.transactionHistory) {
                System.out.println(transaction);
            }
            System.out.println("-------------------------------");
        }
        ATM1.showMenu();
    }

    
}
class atm2{
    
    // Method to deposit money
    static void deposit(double amount) {
       
        if (amount > 0) {
            ATM1.balance += amount;
            System.out.println("You successfully deposited: $" + amount);
            ATM1.transactionHistory.add("Deposited: " + "     $" + amount);
            checkBalance();
        } else {
            System.out.println("Invalid deposit amount.");
        }
        ATM1.showMenu();
    }

    // Method to withdraw money
    static void withdraw(double amount) {
        if (amount > 0 && amount <= ATM1.balance) {
            ATM1.balance -= amount;
            System.out.println("You successfully withdrew: $" + amount);
            ATM1.transactionHistory.add("Withdrew: " + "    $" +amount);
            checkBalance();
        } else if (amount > ATM1.balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
        ATM1.showMenu();
    }

    // Method to transfer money to another account
    static void transfer(double amount, String recipient) {
        if (amount > 0 && amount <= ATM1.balance) {
            ATM1.balance -= amount;
            System.out.println("You successfully transferred $" + amount + " to " + recipient);
            ATM1.transactionHistory.add("Transferred: " + "     $" +amount + "  "+ " to " +"     " +recipient);
            checkBalance();
        } else if (amount > ATM1.balance) {
            System.out.println("Insufficient balance for transfer.");
        } else {
            System.out.println("Invalid transfer amount.");
        }
        ATM1.showMenu();
    }

    // Method to check balance
    static void checkBalance() {
        System.out.println("Your current balance is: $" + ATM1.balance);
    }

}


public class ATM1 {

    public  static double balance;
    public static ArrayList<String> transactionHistory=new ArrayList();
    public static String userName;
    public static String accnumber;
    public static String pass;

    // public ATM1(String userName,Double balance,String pass) {
    //     this.userName=userName;
    //     this.balance=balance;
    //     this.transactionHistory = new ArrayList<>();
    //     this.pass = pass;
    // }



    public static void homePage(){
    
        System.out.println("\033[H\033[2J");
        Scanner sc=new Scanner(System.in);

        System.out.println("WELCOME TO ATM INTERFACE");
        System.out.println("--------------------------");
        System.out.println("Select option :");
        System.out.println("1. login");
        System.out.println("2. Signup");
        System.out.println("2. Exit");

        System.out.print("Enter choice :");

        int choice =sc.nextInt();
        if(choice==1){
            userauth.login();
        }
        else{

            if (choice==2){
                //System.out.println("ATM1.homepage()");
                bankinfo.signup();
            }
            else{
                if(choice==2){
                    System.exit(0);
                }
                else{
                    System.out.println("Choose a valid value :");
                    homePage();
                }
            }

        }
        if (choice==2){
                //System.out.println("ATM1.homepage()");
                bankinfo.signup();
        }
        else {
            if(choice==2){
                System.exit(0);
            }
            else{
                System.out.println("Choose a valid value :");
                homePage();
            }
        }

    }

    public static void showMenu() {
        System.out.println("\nWelcome, " + userName + "!");
        System.out.println("1: Transaction History");
        System.out.println("2: Deposit");
        System.out.println("3: Withdraw");
        System.out.println("4: Transfer");
        System.out.println("5: Quit");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline after integer input

            switch (option) {
                case 1:
                    hist.showTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm2.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm2.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter the recipient's name: ");
                    String recipient = scanner.nextLine();
                    System.out.print("Enter the amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    atm2.transfer(transferAmount, recipient);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    // running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
            
    }
    public static void main(String[] args) {
        homePage();
    }
}

