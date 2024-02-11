package ExceptClasses;

public class FileErrorsException extends Exception {

    private final String fileName;

    public FileErrorsException(String message, String fileName) {
        super(message);
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

}
