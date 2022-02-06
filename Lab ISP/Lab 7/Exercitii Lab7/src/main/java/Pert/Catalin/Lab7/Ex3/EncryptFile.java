package Pert.Catalin.Lab7.Ex3;

import java.io.*;
import java.util.Scanner;

public class EncryptFile {
    public EncryptFile() {
    }
    public void encryptFile(String filePath) {
        String encryptedFilePath = filePath.substring(0, filePath.lastIndexOf('.')) + ".enc";
        try (BufferedReader in = new BufferedReader(new FileReader(filePath));
             BufferedWriter out = new BufferedWriter(new FileWriter(encryptedFilePath))) {
            int c;
            while ((c = in.read()) != -1) {
                out.write(c - 1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void decryptFile(String filePath) {
        if(!filePath.substring(filePath.lastIndexOf(".")).equals(".enc")){
            System.out.println("File extension is not '.enc'");
            return;
        }
        String decryptedFilePath = filePath.substring(0, filePath.lastIndexOf('.')) + ".dec";
        try (BufferedReader in = new BufferedReader(new FileReader(filePath));
             BufferedWriter out = new BufferedWriter(new FileWriter(decryptedFilePath))) {
            int c;
            while ((c = in.read()) != -1) {
                out.write(c + 1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
