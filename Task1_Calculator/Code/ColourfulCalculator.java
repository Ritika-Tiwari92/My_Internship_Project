package Saiket_Internship.Task1;

// TASK 1 : Calculator Application

import java.util.Scanner; //Import Scanner class(used to take ussr input) from java's util package

public class ColourfulCalculator {

    //Using ANSI color unique codes to make the console output colourful

    // final means constant value & "\u001B[0m" is ANSI code for RESET
    public static final String RESET="\u001B[0m"; // RESET the console text color to Normal
    public static final String RED="\u001B[31m";
    public static final String GREEN="\u001B[32m";
    public static final String YELLOW="\u001B[33m";
    public static final String BLUE="\u001B[34m";
    public static final String CYAN="\u001B[36m";

    //Main method : Actual execution start point

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in); // creates a Scanner class object sc to take input from user
        int choice; //User input choice: they want to perform which operation(1-5)

        System.out.println(CYAN + "🌟 Welcome to the colourful calculator🌟" + RESET); // prints welcome messsage in CYAN color

        do {
            // this block will keep running until user chooses to EXIT(5)
            System.out.println(YELLOW + "\n=============MENU============" + RESET); // print Menu in Yellow color, \n for new line then print menu
            System.out.println(GREEN + "1.Addition");
            System.out.println("2.Subtraction");
            System.out.println("3.Multiplication");
            System.out.println("4.Division");
            System.out.println("5.EXIT" + RESET);

            // asks the user to enter their choice
            System.out.print(BLUE + "Choose an Operation(1-5) to perform:" + RESET);//used print() for take the input in the same line
            choice = sc.nextInt(); // reads user input choice(1-5) and store in the choice variable

            //EXIT condition
            if (choice == 5) {
                //if user enters choice=5 then it display thank you message & breaks the loop & ends the program
                System.out.println(CYAN + "\n👋 Thank you for using colourful Calculator!" + RESET);
                break;
            }

            System.out.print(BLUE + "Enter first number:" + RESET); //asks user to enter first number
            double num1 = sc.nextDouble(); // reads a decimal value input from the user
            System.out.print(BLUE + "Enter Second number:" + RESET);
            double num2 = sc.nextDouble();

            try {
                // risky code where exception can be occur
                double result = 0;
                // checks and match with user choice(1-4) and run corresponding case(operation)
                switch (choice) {
                    // each case calls a unique method
                    // each result of case is display in green color
                    case 1:
                        result = add(num1, num2); // calls add() with input and store the result
                        System.out.println(GREEN + "✅ Result:" + result + RESET);
                        break; // uses to prevent from fallthrough
                    case 2:
                        result = subtract(num1, num2); // calls the subtract() with input and store the result
                        System.out.println(GREEN + "✅ Result:" + result + RESET);
                        break;
                    case 3:
                        result = multiply(num1, num2); // calls the multiply() with input and store the results
                        System.out.println(GREEN + "✅ Result:" + result + RESET);
                        break;
                    case 4:
                        result = divide(num1, num2); // calls the divide() with input and store the results
                        System.out.println(GREEN + "✅ Result:" + result + RESET);
                        break;
                    default: // if choice is invalid(except from(1-5))
                        System.out.println(RED + "❌ Invalid choice!!, please select between(1-5)" + RESET);
                }

            }
            catch(ArithmeticException e) // use to handle exception if divisio by zero happened
                {
                    System.out.println(RED + "⚠️ Error:" + e.getMessage() + RESET); // display error in red color
                }
            }
            while (true) ;

            sc.close(); // use to close the Scanner object to release system resources after use.
        }

        // Method definitions
        // each method perform unique mathematical operation
        // used static so that it can be called without creating an object

        static double add(double a,double b)
        {
            return a+b; //adds a & b, return the result

        }
        static double subtract(double a,double b)
        {
            return a-b; // sub a & b, return the result
        }
        static double multiply(double a,double b)
        {
            return a*b; // multiply a & b, return the result
        }
        static double divide(double a,double b)
        {
            if(b==0) // if b is 0 it'll throw an exception otherwise divide normally
            {
                throw new ArithmeticException("Division by zero is not allowed!");
            }
            return a/b; // divide a by b, return the result
        }
    }

