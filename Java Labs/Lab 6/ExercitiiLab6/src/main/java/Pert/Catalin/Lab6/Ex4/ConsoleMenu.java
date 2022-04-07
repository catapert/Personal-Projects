package Pert.Catalin.Lab6.Ex4;
import java.util.Scanner;

public class ConsoleMenu {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        boolean continua = true;
        dictionary.addWord(new Word("Word no. 1"), new Definition("Definition for Word no. 1"));
        dictionary.addWord(new Word("Word no. 2"), new Definition("Definition for Word no. 2"));
        dictionary.addWord(new Word("Word no. 3"), new Definition("Definition for Word no. 3"));
        dictionary.addWord(new Word("Word no. 4"), new Definition("Definition for Word no. 4"));
        int choice;
        Scanner keyboard = new Scanner(System.in);
        while (continua) {
            System.out.println(" 1.Add word; \n 2.Get description; \n 3.Get all words; \n 4.Get all definitions; \n 5.Quit.");
            choice = keyboard.nextInt();
            switch (choice) {
                case 1: {
                    keyboard.nextLine();
                    System.out.println("Word : ");
                    String thisWord = keyboard.nextLine();
                    System.out.println("Description : ");
                    String thisDescription = keyboard.nextLine();
                    Definition definition = new Definition(thisDescription);
                    dictionary.addWord(new Word(thisWord), definition);
                    break;
                }
                case 2: {
                    keyboard.nextLine();
                    System.out.println("Enter a word : ");
                    String myWord = keyboard.nextLine();
                    Word myWord2 = new Word(myWord);
                    System.out.println(dictionary.getDefinition(myWord2));
                    break;
                }
                case 3: {
                    System.out.println(dictionary.getAllWords());
                    break;
                }
                case 4: {
                    System.out.println(dictionary.getAllDefinitions());
                    break;
                }
                case 5: {
                    continua = false;
                    break;
                }
            }
        }
    }
}