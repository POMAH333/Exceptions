package ExceptClasses;

public class FildQuantException extends Exception {

    private final int count;

    public FildQuantException(String message, int count) {
        super(message);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

}
