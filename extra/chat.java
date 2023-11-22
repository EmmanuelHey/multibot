package extra;
import java.util.Scanner;

public class chat {
    public static void main(String[] args) {
        bot mannyBot = new bot();
        String location = "";
        
        System.out.println("Enter a location: ");
        Scanner input = new Scanner(System.in);

        location = input.nextLine();
        mannyBot.getWeather(location);
    }
}
