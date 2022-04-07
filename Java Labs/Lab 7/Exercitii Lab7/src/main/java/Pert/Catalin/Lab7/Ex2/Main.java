package Pert.Catalin.Lab7.Ex2;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        System.out.println("Choose the character you want to search :" + '\n');
        String ch = sc.nextLine();
        try (BufferedReader in = new BufferedReader(new FileReader("src/main/java/Pert/Catalin/Lab7/Ex2/Secret.txt"))) {
            String s;
            while ((s = in.readLine()) != null) {
                for (String letter : s.split("")) {
                    if (letter.equals(ch))
                        count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The letter " + ch + " was found " + count + " times");
    }
}
