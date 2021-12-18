import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * test
 */
public class test {
    static LocalDateTime date = LocalDateTime.now();
    static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tanggal = format.format(date);
        System.out.println("Enter the number of test cases");
        String t = sc.nextLine().toUpperCase();
        System.out.println(chairValidation(t));
        System.out.println(tanggal);
        
        sc.close();
    }

    public static boolean chairValidation(String input) {
        if ((input.contains("A") || input.contains("B") || input.contains("C") || input.contains("D"))
                && (input.contains("1") || input.contains("2") || input.contains("3") || input.contains("4")) && input.length() == 2) {
            return true;
        } else {
            return false;
        }
    }
}