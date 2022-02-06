package Pert.Catalin.Lab7.Ex3;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/Pert/Catalin/Lab7/Ex3/Confidential.txt";
        String encryptedFilePath = filePath.substring(0, filePath.lastIndexOf('.')) + ".enc";
        EncryptFile F = new EncryptFile();
        F.encryptFile(filePath);
        F.decryptFile(encryptedFilePath);
    }
}
