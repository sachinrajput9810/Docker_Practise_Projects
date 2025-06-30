import java.io.*;
import java.util.Scanner;

public class UserInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name to store in file or press enter to proceed: ");
        String userName = scanner.nextLine();

        if (!userName.isEmpty()) {
            // Append name to file
            try (FileWriter writer = new FileWriter("user_info.txt", true)) {
                writer.write(userName + "\n");
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }

            // Ask if user wants to see all names
            System.out.print("Do you want to see all user names? y/n: ");
            String showInfo = scanner.nextLine();

            if (showInfo.equalsIgnoreCase("y")) {
                try (BufferedReader reader = new BufferedReader(new FileReader("user_info.txt"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    System.out.println("Error reading from file: " + e.getMessage());
                }
            }
        }
    }
}
