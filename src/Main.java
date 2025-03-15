import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите текст и нажмите <Enter>: ");
        String text = new Scanner(System.in).nextLine();
        System.out.println("Длина текста: " + text.length());
        System.out.println("Введите первое число: ");
        int firstNumber = numberFromInput();
        System.out.println("Введите второе число: ");
        int secondNumber = numberFromInput();
        System.out.println("Сумма чисел равна: " + numberSum(firstNumber, secondNumber));
        System.out.println("Разность чисел равна: " + numberDifference(firstNumber, secondNumber));
        System.out.println("Произведение чисел равно: " + numberMultiplication(firstNumber, secondNumber));
        System.out.println("Частное чисел равно: " + numberDivision(firstNumber, secondNumber));
    }

    public static int numberFromInput() {
        return new Scanner(System.in).nextInt();
    }

    //Сумма чисел
    public static int numberSum(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    //Разность чисел
    public static int numberDifference(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    //Произведение чисел
    public static int numberMultiplication(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    //Частное чисел
    public static double numberDivision(int firstNumber, int secondNumber) {
        return (double) firstNumber / secondNumber;    
    }
}
