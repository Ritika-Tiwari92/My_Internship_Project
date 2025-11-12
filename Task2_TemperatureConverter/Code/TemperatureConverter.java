package Saiket_Internship.Task2;

import java.util.Scanner;

public class TemperatureConverter {

    // ANSI Escape Codes for colourful output
    public static final String RESET="\u001B[0m";
    public static final String CYAN="\u001B[36m";
    public static final String YELLOW="\u001B[33m";
    public static final String GREEN="\u001B[32m";
    public static final String RED="\u001B[31m";
    public static final String PURPLE="\u001B[35m";

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in); //Created Scanner obj --> to take user input(from keyboard).

        System.out.println(CYAN + "╔════════════════════════════════════╗");
        System.out.println(      "║     🌡 TEMPERATURE CONVERTER 🌡     ║"); // Print the title of the Program on console
        System.out.println(       "╚════════════════════════════════════╝" + RESET);

        System.out.println(YELLOW + "Choose conversion type"); // Tell the User --> conversion they can perform
        System.out.println("1.Celsius --> Fahrenheit");// all four lines shown to user so that they can choose any of them
        System.out.println("2.Fahrenheit --> Celsius");
        System.out.println("3.Celsius --> Kelvin");
        System.out.println("4.Kelvin --> Celsius");
        System.out.print(PURPLE + "Enter Your choice (1-4) : " + RESET);// Ask user to select one choice
        int choice= sc.nextInt();// use to store the choice(1-4) in choice variable

        System.out.print(YELLOW + "Enter temperature value : " + RESET); // ask user to enter temperature value
        double temp= sc.nextDouble(); // store temp value in the temp variable
        double result=0; // stores the final converted temperature
        String resultText=""; // stores description of conversion

        // perform conversion according to user choice
        switch (choice) {
            case 1:
                result = (temp * 9 / 5) + 32; // C --> F Conversion
                resultText = "celsius --> Fahrenheit"; // stores the conversion's name
                break; // come out from the current case & prevent follow through
            case 2:
                result = (temp - 32) * 5 / 9;
                resultText = "Fahrenheit --> Celsius";
                break;
            case 3:
                result = temp + 273.15;
                resultText = "Celsius --> Kelvin";
                break;
            case 4:
                result = temp - 273.15;
                resultText = "Kelvin --> Celsius";
                break;
            default:
                System.out.println(RED + "❌Invalid Choice " + RESET); // if user input number except from(1-4)
                System.exit(0); // stops the program execution immediately
        }
        System.out.println(GREEN +"\nConversion : "+ "" + resultText); // print conversion's type in green color
        System.out.println("Result : "+ result); // print final result in two decimal places
        System.out.println(CYAN + "\n🌟Thankyou for using Tempertaure converter✨" + RESET);

        sc.close(); // close the scanner obj from prevent memory leak

        }
    }

