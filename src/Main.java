import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String path = filePath();
        parseFile(path);
    }

    public static String filePath() {
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
            } else {
                return path;
            }
            attempts++;
            System.out.println("Путь указан верно. Это файл номер " + attempts);
        }
    }

    ;

    public static void parseFile(String path) {
        int totalLines = 0;
        int googlebotCount = 0;
        int yandexbotCount = 0;

        Pattern logPattern = Pattern.compile("^(\\S+)\\s+-\\s+-\\s+\\[(.*?)\\]\\s+\"(\\S+)\\s+(\\S+)\\s+HTTP/\\d\\.\\d\"\\s+(\\d+)\\s+(\\d+)\\s+\"[^\"]*\"\\s+\"([^\"]*)\"");
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader reader = new BufferedReader(fileReader);

            String line;

            while ((line = reader.readLine()) != null) {
                    if (line.isEmpty()) {
                        continue;
                    }
                    if (line.length() > 1024) {
                        throw new StringTooLongException();
                    }
                Matcher matcher = logPattern.matcher(line);
                if (matcher.find()) {
                    totalLines++;
                    String userAgent = matcher.group(7);
                    String inBrackets = extractContentInBrackets(userAgent);
                    String[] fragments = inBrackets.split(";");
                    if (fragments.length > 1) {
                        String secondFragment = fragments[1].trim();
                        int slashIdx = secondFragment.indexOf('/');
                        String beforeSlash = (slashIdx != -1) ? secondFragment.substring(0, slashIdx) : secondFragment;
                        if (beforeSlash.equals("Googlebot")) {
                            googlebotCount++;
                        } else if (beforeSlash.equals("YandexBot")) {
                            yandexbotCount++;
                        }
                    }
                }
            }
            System.out.println("Количество строк в файле: " + totalLines);
            if (totalLines > 0) {
                double googlebotPercent = Math.round((double) googlebotCount / totalLines * 100);
                double yandexbotPercent = Math.round((double) yandexbotCount / totalLines * 100);
                System.out.println("Доля запросов от Googlebot: " + googlebotPercent + "%");
                System.out.println("Доля запросов от YandexBot: " + yandexbotPercent + "%");
            } else {
                System.out.println("Доля запросов от Googlebot: 0%");
                System.out.println("Доля запросов от YandexBot: 0%");
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println("Указанный файл не существует: " + fnfe.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    private static String extractContentInBrackets(String input) {
        int startIndex = input.indexOf('(');
        int endIndex = input.lastIndexOf(')');
        if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
            return input.substring(startIndex + 1, endIndex);
        }
        return "";
    }
}
