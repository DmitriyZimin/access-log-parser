import java.io.*;
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
            try {


                FileReader fileReader = new FileReader(path);
                BufferedReader reader = new BufferedReader(fileReader);

                boolean firstLineProcessed = false;
                int totalLines = 0;
                int maxLength = 0;
                int minLength = 0;

                String line;
                while ((line = reader.readLine()) != null) {
                    int length = line.length();

                    if (length > 1024) {
                        throw new StringTooLongException();
                    }

                    totalLines++;
                    if (!firstLineProcessed) {
                        minLength = length;
                        maxLength = length;
                        firstLineProcessed = true;
                    } else {
                        if (length < minLength) {
                            minLength = length;
                        }
                        if (length > maxLength) {
                            maxLength = length;
                        }
                    }
                }
                System.out.println("Количество строк в файле: " + totalLines);
                System.out.println("Длина самой длинной строки: " + maxLength);
                System.out.println("Длина самой короткой строки: " + minLength);
            } catch (FileNotFoundException fnfe) {
                System.err.println("Указанный файл не существует: " + fnfe.getMessage());
            } catch (IOException e) {
                System.err.println("Ошибка при чтении файла: " + e.getMessage());
            }
        }
    }
}
