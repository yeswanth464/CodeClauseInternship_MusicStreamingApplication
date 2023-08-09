import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MusicPlayerApp{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] playlist = {
            "\"C:\\Users\\yeswa\\OneDrive\\Desktop\\music\\128-Raanjhanaa - Raanjhanaa 128 Kbps.mp3\"",
            "\"C:\\Users\\yeswa\\OneDrive\\Desktop\\music\\Apna-Bana-Le(PagalWorld).mp3\"",
            "\"C:\\Users\\yeswa\\OneDrive\\Desktop\\music\\Shayad - Love Aaj Kal 128 Kbps.mp3\""
        };
        int currentSongIndex = 0;

        while (true) {
            System.out.println("1. Play");
            System.out.println("2. Pause");
            System.out.println("3. Next");
            System.out.println("4. Previous");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    playSong(playlist[currentSongIndex]);
                    break;
                case 2:
                    System.out.println("Pausing...");
                    break;
                case 3:
                    currentSongIndex = (currentSongIndex + 1) % playlist.length;
                    System.out.println("Playing next song: " + playlist[currentSongIndex]);
                    playSong(playlist[currentSongIndex]);
                    break;
                case 4:
                    currentSongIndex = (currentSongIndex - 1 + playlist.length) % playlist.length;
                    System.out.println("Playing previous song: " + playlist[currentSongIndex]);
                    playSong(playlist[currentSongIndex]);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void playSong(String filePath) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "start", "\"\"", filePath);
            processBuilder.directory(new File(System.getProperty("user.dir")));
            processBuilder.start();
            System.out.println("Now playing: " + filePath);
        } catch (IOException e) {
            System.out.println("Error playing the song.");
        }
    }
}


