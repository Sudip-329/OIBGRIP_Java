//Name : Sudip Chakrabarty

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;
import java.util.*;

class Registration{
    static void register(){
        try (Scanner getdata = new Scanner(System.in)) {
            System.out.println("<--><--><--><--><--><--><-->");
            System.out.println("Enter your name : ");
            IBATM.name=getdata.nextLine();  //Name input for IBATM class
            System.out.println("Enter password (Use strong password(4 Character or long)) : ");
            String password=getdata.nextLine();
            System.out.println("Enter your account number : ");
            String accnumber=getdata.nextLine();
            System.out.println("Registration successfull.");
            System.out.println("<--> <--> <--> <--> <--> <-->");
            IBATM.prompt();
        }
    }
    static void display(String name){}
}

class Display{
    static void checkbalance(){   //To show total money.
        System.out.print("The available balance is : Rs.");
        IBATM.show();
        System.out.println("/-");
        System.out.println("<--> <--> <--> <--> <--> <--> <-->");
        IBATM.prompt();  //Again user can choose to withdraw,deposit,transfer...
    }
}

class transaction{
    static void withdraw(){  //withdraw function
        Scanner getdata=new Scanner(System.in);
        System.out.println("<--><--><--><--><--><--><-->");
        System.out.println("Enter amount to withdraw : ");
        int wdm=getdata.nextInt();
        if(wdm<=IBATM.balance){    //wdm --> withdrawal money
            IBATM.balance=IBATM.balance - wdm;  //Subtracting withdrawl balance.
            IBATM.history.add(Integer.toString(wdm));
            IBATM.history.add("Withdrawed.");
            System.out.println("Amount of Rs."+wdm+"/-withdrawed successfully!");
            System.out.println("<--> <--> <--> <--> <--> <--> <-->");
        }
        else{
            System.out.println("Insufficient balance to withdraw.");
            System.out.println("<--> <--> <--> <--> <--> <--> <-->");
        }
        IBATM.prompt();
    }

    static void deposit(){  //deposit function
        Scanner getdata=new Scanner(System.in);
        System.out.print("Enter amount to deposit :");
        int d_amount=getdata.nextInt();
        IBATM.updatebalance(d_amount);  //updating total money
        IBATM.history.add(Integer.toString(d_amount));
        IBATM.history.add("Deposited.");
        System.out.println("Amount Rs."+d_amount+"/- deposited successfully!");
        System.out.println("<--> <--> <--> <--> <--> <--> <-->");
        IBATM.prompt();
    }

    static void transfer(){
        Scanner getdata=new Scanner(System.in);
        System.out.println("Enter the receiver name : ");
        String receiver_name=getdata.nextLine();
        System.out.println("Enter the account number of receiver : ");
        int receiver_accno=getdata.nextInt();
        System.out.println("Enter the amount to be transferred :");
        int tamount=getdata.nextInt();
        if(tamount<=IBATM.balance){ //transfer only possible if enough money is present.
            IBATM.balance=IBATM.balance-tamount;//Updating as money transfered.
            //IBATM.history.add("Transfered");
            IBATM.history.add(Integer.toString(tamount));
            IBATM.history.add("Transfered.");
            System.out.println("Amount Rs."+tamount+"/- transferred successfully.");
            System.out.println("<--> <--> <--> <--> <--> <--> <-->");
        }
        else{//If enough balance not present.
            System.out.println("Insufficient balance. Transfer failed.");
            System.out.println("<--> <--> <--> <--> <--> <--> <--> <-->");
        }
    }

}


class his{
    static void transactionhistory(){
        System.out.println("<--><--><--><--><--><--><-->");
        System.out.println("Transaction History :");
        int k=0;
        if(IBATM.balance>0)
        {
            for(int i=0; i<(IBATM.history.size()/2); i++)
            {
                System.out.print("Rs.");
                for(int j=0;j<2;j++)
                {
                    System.out.print(IBATM.history.get(k)+" ");
                    k++;
                }
                System.out.println("\n<--><--><--><--><--><--><-->");
            }            
        }
        else{
            System.out.println("Your account is empty.No Transaction has been done.");
        }
        IBATM.prompt();
    }
}


public class IBATM {
    public static String name;
    public static int balance=0;
    public static String accnumber;
    public static ArrayList<String> history=new ArrayList<String>();
    
    static void updatebalance(int d_amount){
        balance = balance+d_amount;
    }
    static void show(){   //to show balance
        System.out.print(balance);
    }

    public static void homepage(){  //when starting it will show
        Scanner getdata = new Scanner(System.in);
        System.out.println("$ WELCOME TO INDIAN BANK ATM $ ");
        System.out.println("><--> <--> <--> <--> <--> <--><");
        System.out.println("Select option from below : ");
        System.out.println("1. Register to bank");
        System.out.println("2. Exit");
        System.out.println("Enter your choice : ");
        int choice = getdata.nextInt();
        if(choice == 1)
        {
            Registration.register(); //calling the register function.
        }
        else{
            if(choice==2)
            {
                System.exit(0);

            }
            else{
                System.out.println("Invalid Input");
                homepage();  // Rerun the homepage function.
            }
        }
    }

    static void prompt(){
        Scanner getdata=new Scanner(System.in);
        System.out.println("Welcome "+IBATM.name+" to the INDIAN BANK ATM");
        System.out.println("<--> <--> <--> <--> <--> <--> <-->");
        System.out.println("Select option : ");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Transfer");
        System.out.println("4. Check Balance");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
        System.out.println("Enter your choice : ");
        int choice = getdata.nextInt();
        switch(choice){
            case 1:
                transaction.withdraw();
            case 2:
                transaction.deposit();
            case 3:
                transaction.transfer();
            case 4:
                Display.checkbalance();
            case 5:
                his.transactionhistory();
            case 6:
                System.exit(0);
        }

    }
    public static void main(String[] args) {
        homepage();
    }

}