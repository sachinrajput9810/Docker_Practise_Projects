import java.io.*;
import java.util.*;

public class ReadServers {
    public static void main(String[] args) {
        List<String> content = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("servers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Exception Type: " + e.getClass().getName());
        }

        // Equivalent to Python's `else:` block — only runs if no exception
        if (!content.isEmpty()) {
            for (String line : content) {
                System.out.println(line.strip());
            }
        }
    }
}
