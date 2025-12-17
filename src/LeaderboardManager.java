import java.io.*;
import java.time.LocalDateTime;

public class LeaderboardManager {

    private static final String FILE_NAME = "leaderboard.txt";

    // Save winner to file (append mode)
    public static void saveWinner(String winnerName) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(winnerName + " | " + LocalDateTime.now() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving leaderboard data.");
        }
    }

    // Display leaderboard
    public static void showLeaderboard() {
        System.out.println("\n----- LEADERBOARD -----");

        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No games played yet.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int rank = 1;
            while ((line = br.readLine()) != null) {
                System.out.println(rank + ". " + line);
                rank++;
            }
        } catch (IOException e) {
            System.out.println("Error reading leaderboard.");
        }
    }
}
