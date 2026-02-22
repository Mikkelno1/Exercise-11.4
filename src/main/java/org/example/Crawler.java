package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Crawler
{

    static String inputFile;
    static String outputFile;

    /**
     * Creates output file based on prompted output name
     */
    static void writeFile()
    {
        if (inputFile == null)
        {
            return;
        }
        try (PrintWriter pw = new PrintWriter(outputFile))
        {
            pw.print(inputText());

        } catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Find file based on user prompt and reads the file - sends result to writeFile()
     */

    static String inputText() throws FileNotFoundException
    {
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(inputFile)))
        {
            int counter = 1;

            while (scanner.hasNextLine())
            {
                String words = scanner.nextLine();

                sb.append("/* ").append(counter).append(" */ ").append(words).append("\n");
                counter++;
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Input file not found");
        }

        return sb.toString();
    }


    /**
     * Prompts user for input file name and output file name
     */
    static void fileNames()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input filename");
        inputFile = scanner.nextLine();

        System.out.println("Enter output filename");
        outputFile = scanner.nextLine();
        scanner.close();
    }

}
