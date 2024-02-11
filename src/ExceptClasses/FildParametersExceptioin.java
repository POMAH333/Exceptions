package ExceptClasses;

public class FildParametersExceptioin extends Exception {

    private final int errorCode;

    public FildParametersExceptioin(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        switch (errorCode) {
            case 0:
                System.out.println("Пустое значение фамилии.");
                return errorCode;
            case 1:
                System.out.println("Пустое значение имени.");
                return errorCode;
            case 2:
                System.out.println("Пустое значение отчества.");
                return errorCode;
            case 3:
                System.out.println("Пустое значение дня рождения.");
                return errorCode;
            case 4:
                System.out.println("Пустое значение номера телефона.");
                return errorCode;
            case 5:
                System.out.println("Пустое значение пола.");
                return errorCode;
            case 6:
                System.out.println("Слишком короткие фамилия, имя или отчество.");
                return errorCode;
            case 7:
                System.out.println("Дата рождения должна быть в формате: dd.mm.yyyy");
                return errorCode;
            case 8:
                System.out.println("Пол может быть только f или m");
                return errorCode;
            default:
                return errorCode;
        }

    }

}
