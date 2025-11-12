package Saiket_Internship.Task5;

import java.io.BufferedReader; // imports BufferedReader class used to read text from files efficiently (line by line).
import java.io.FileReader;    // imports FileReader class that reads characters from a file.
import java.io.IOException;   // imports IOException class which handles input/output (I/O) related runtime-errors like “file not found”.

public class TextFileAnalyzer {

    static String path = "C:\\Users\\hp\\OneDrive\\Desktop\\fileanaly.txt";

    // ANSI color eescape codes for colorful console output
    public static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String CYAN = "\u001B[36m";
    public static final String RED = "\u001B[31m";
    public static final String PURPLE = "\u001B[35m";

    public static void main(String[] args) {

        int charCount = 0; // count total number of char excluding spaces
        int wordCount = 0; // total number of words present in file
        int lineCount = 0; // total number of lines

        System.out.println(CYAN + "📂 Analyzing file: " + path + RESET);
        System.out.println(YELLOW + "--------------------------------------" + RESET);

        // FilReader(path) -> opens the file
        //BufferedReader ->  wraps the FileReader to read file faster and efficiently.
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String currLine; // Declares a variable to store each line read from the file temporarily.

            System.out.println(PURPLE + "\n📜 File Content:\n" + RESET);
            System.out.println(YELLOW + "--------------------------------------" + RESET);

            //reader.readline() - reads one line at a time.
            // != null -> keeps reading the file until no more lines present.
            while ((currLine = reader.readLine()) != null) {

                // Increments the total number of lines read.
                lineCount++;

                // Display currentline text of file content
                System.out.println(currLine);

                // split("\s+") → splits the line wherever one or more spaces (\s) appear.
                // Stores words in a String array.

                String[] words = currLine.trim().split("\\s+");

                // trim() → removes extra spaces at the beginning or end of the line.
                // if condition → skips blank lines.
                // words.length → counts how many words in the line.
                // for-each loop → goes through every word and adds its length to charCount.
                if (!currLine.trim().isEmpty()) {
                    wordCount += words.length;

                    // enhanced for loop also known as FOR-EACH LOOP
                    for (String word : words) {
                        charCount += word.length();
                    }
                }
            }

            // Displays all the result in colorful console

            System.out.println(YELLOW + "--------------------------------------" + RESET);
            System.out.println(GREEN + "✅ Analysis Complete!" + RESET);
            System.out.println(YELLOW + "--------------------------------------" + RESET);
            System.out.println(BLUE + "📄 Total Lines: " + RESET + lineCount);
            System.out.println(BLUE + "📝 Total Words: " + RESET + wordCount);
            System.out.println(BLUE + "🔠 Total Characters: " + RESET + charCount);
            System.out.println(YELLOW + "--------------------------------------" + RESET);

        }

        // handles exception occured in try blcok
        catch (IOException e)
        {
            System.out.println(RED + "❌ Error reading file: " + e.getMessage() + RESET);
        }

        System.out.println(CYAN + "🎉 Program Finished Successfully!" + RESET);
    }
}