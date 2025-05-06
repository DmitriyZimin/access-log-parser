import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        filePath();
    }

    public static void filePath() {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        while (true) {
            System.out.print("Введите путь к файлу:");

            String path = scanner.nextLine();
            File file = new File(path);

            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();

            if (!fileExists && !isDirectory) {
                System.out.println("Указан путь к несуществующему файлу");
                continue;
            } else if (isDirectory) {
                System.out.println("Указан путь к папке");
                continue;
            }

            attempts++;
            System.out.println("Путь указан верно. Это файл номер " + attempts);
        }
    }
}
