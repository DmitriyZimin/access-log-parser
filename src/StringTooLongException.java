public class StringTooLongException extends RuntimeException {
    private static final String MESSAGE = "Найдена строка длиной больше 1024 символов!";

    public StringTooLongException() {
        super(MESSAGE);
    }
}
