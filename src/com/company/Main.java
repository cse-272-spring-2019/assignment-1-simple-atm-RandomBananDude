package com.company;
import java.awt.FlowLayout;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {


    public static void main(String[] args) {
        // Basically a random variable to keep the while loop running so if the session expires it redirects u to the main menu not terminate program
        int yolfi = 1;
        ArrayList arr = new ArrayList();
        Bank_Account money_modify = new Bank_Account();
        String fn = JOptionPane.showInputDialog("Welcome to Yousef's Bank\n" +
                "Please enter your card number to proceed");
        int num1 = Integer.parseInt(fn);
        User_DB validate = new User_DB(); // card validation number is 5825
         //User validation from existing database using card id number
        if (num1 == validate.account_number) { // Verification number is 5825 :D
            while (yolfi == 1) { // Activates when card number validates, and keeps the program running unless the user hits the prompt for exit
                String sn = JOptionPane.showInputDialog("Please pick an option\n" +
                        "1.Cash withdrawal\n" +
                        "2.Cash Deposit\n" +
                        "3.Balance Inquiry\n" +
                        "4.History\n" +
                        "5.Exit\n"
                        );
                 int num2 = Integer.parseInt(sn);

                ////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (num2 == 1) { // Activates when user inputs 2,taking available balance and modifying it according to user input
                    String wd1 = JOptionPane.showInputDialog("Available balance is:$" + money_modify.available_balance +
                            "\n" + "How much would you like to withdraw");
                    int numwd = Integer.parseInt(wd1);
                    if (numwd > 1000)
                        JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.PLAIN_MESSAGE);
                    if (numwd <= 1000) {
                        money_modify.available_balance = money_modify.available_balance - numwd;
                        JOptionPane.showMessageDialog(null, "Available balance:$ " + money_modify.available_balance + "\n" +
                                "Money cashed:$ " + numwd, "Transaction Successful", JOptionPane.PLAIN_MESSAGE);
                        arr.add(money_modify.available_balance);

                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////////////////////////

                if (num2 == 2) {// Activates when user inputs 2,similar to one but user adds money instead of cashing
                    String dd1 = JOptionPane.showInputDialog("Available balance is:$ " + money_modify.available_balance + "\n" + "How much would you like to deposit?");
                    int numdd = Integer.parseInt(dd1);
                    if (numdd > 1000)
                        JOptionPane.showMessageDialog(null, "Can't deposit more than $1000 per session!", "Error", JOptionPane.PLAIN_MESSAGE);
                    if (numdd <= 1000) {
                        money_modify.available_balance = money_modify.available_balance + numdd;
                        JOptionPane.showMessageDialog(null, "Available balance:$ " + money_modify.available_balance + "\n" + "Money added:$ " + numdd, "Transaction Succesful", JOptionPane.PLAIN_MESSAGE);
                        arr.add(money_modify.available_balance);

                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////////////////////////

                if (num2 == 3) {// Activates when user inputs 3, prompts on screen number set to be the available balance
                    JOptionPane.showMessageDialog(null, "Available balance:$ " + money_modify.available_balance, "Transaction Succesful", JOptionPane.PLAIN_MESSAGE);
                    arr.add(money_modify);
                }
                ////////////////////////////////////////////////////////////////////////////////////////////////////////

                if (num2 == 4){// Activates when user inputs 4, allowing him to navigate through the history of transactions
                    //java.lang.Object foo = arr.get(1);
                    int index = 0;
                    int arr_index = 0;
                    arr_index = arr.size()-1-index;
                    java.lang.Object balance = arr.get(arr_index);
                    boolean looping = true;
                    while (looping) {

                        String h1 =JOptionPane.showInputDialog(null,"transaction number: "+(index+1)+" is "  + balance+"\nPlease enter either:\n 1) Previous\n or\n 2) Next\n or\n 3) To " +
                                        "return  to main menu\nKindly enter your option twice to verify it wasn't a mis-click ","History querying"
                                ,JOptionPane.PLAIN_MESSAGE);
                        int hnv1 = Integer.parseInt(h1);
                        if(hnv1 ==1){
                            if (index > 0) {
                                index -= 1;
                                arr_index = arr.size()-1-index;
                                balance = arr.get(arr_index);
                                JOptionPane.showInputDialog(null, "transaction number: "+(index+1)+" is "  + balance + "\nPlease enter either:\n 1) Previous\n or\n 2) Next\n or\n 3) To " +
                                        "return  to main menu\nKindly enter your option twice to verify it wasn't a mis-click ", "History querying", JOptionPane.PLAIN_MESSAGE);
                            }
                        }
                        if(hnv1 ==2){
                            if (index < 5) {
                                index += 1;
                                arr_index = arr.size()-1-index;
                                balance = arr.get(arr_index);
                                JOptionPane.showInputDialog(null, "transaction number: "+(index+1)+" is " + balance + "\nPlease enter either:\n 1) Previous\n or\n 2) Next\n or\n 3) To " +
                                        "return  to main menu\nKindly enter your option twice to verify it wasn't a mis-click ", "History querying", JOptionPane.PLAIN_MESSAGE);
                            }
                        }
                        if (hnv1 == 3) {
                            looping = false;
                        }

                    }


                }

                if (num2 == 5) {//Activates when user hits 5. Breaks the while loop thus terminating the program
                    JOptionPane.showMessageDialog(null, "Thank you for using Yousef's Bank.\n"+"Please come again :D\nClick 'OK' to exit."
                            , "Sad to see you go", JOptionPane.PLAIN_MESSAGE);

                    break;
                }
                ////////////////////////////////////////////////////////////////////////////////////////////////////////

                if(num2 <= 0)
                    JOptionPane.showMessageDialog(null,"Please try again","Invalid input",JOptionPane.PLAIN_MESSAGE);
                if(num2 >5)
                    JOptionPane.showMessageDialog(null,"Please try again","Invalid input",JOptionPane.PLAIN_MESSAGE);

            }
            ////////////////////////////////////////////////////////////////////////////////////////////////////////
        }
        else {// If user enters wrong card ID number, he is prompted with error
            JOptionPane.showMessageDialog(null, "User not in Database.\n" +
                    "Session expired.", "Error", JOptionPane.PLAIN_MESSAGE);
        }
                ////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

}