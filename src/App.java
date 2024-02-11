import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import ExceptClasses.FildParametersExceptioin;
import ExceptClasses.FildQuantException;
import ExceptClasses.FileErrorsException;
import ExceptClasses.MinDataSizeException;

public class App {

    /**
     * Метод ввода строковых данных из консоли
     * 
     * @param message - выводимый запрос
     * @return
     */
    public static String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    public static String[] dataText(String str) throws FildQuantException {

        String[] textData = str.split(" ");

        if (textData.length != 6)
            throw new FildQuantException("Количество введённых полей не соответствует требуемому", textData.length);

        return textData;
    }

    public static void writeFile(String file, String dataString) throws FileErrorsException {
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(dataString);
            fileWriter.write("\n");
        } catch (IOException e) {
            throw new FileErrorsException(dataString, file);
        }
    }

    public static void main(String[] args) throws Exception {
        try {
            // Ввод данных
            String dataString = prompt("Введите данные: ");
            if (dataString.length() < 23)
                throw new MinDataSizeException("Строка данных: \n" + dataString + "\nслишком короткая");

            // Парсинг строки
            String[] dataText = dataText(dataString);

            // Проверка данных
            for (int err = 0; err < dataText.length; err++) {
                if (dataText[err].equals(""))
                    throw new FildParametersExceptioin("Пустое значение поля", err);

            }

            String lastName = dataText[0];
            String firstName = dataText[1];
            String patronymic = dataText[2];
            String birthday = dataText[3];
            int phoneNumber = Integer.parseInt(dataText[4]);
            String sex = dataText[5];

            if (lastName.length() < 2 || firstName.length() < 2 || patronymic.length() < 2)
                throw new FildParametersExceptioin("Неправильно указаны ФИО", 6);

            String[] bdFormat = birthday.split("\\.");
            if (!(bdFormat.length == 3 && bdFormat[0].length() == 2 &&
                    bdFormat[1].length() == 2 && bdFormat[2].length() == 4))
                throw new FildParametersExceptioin("Неправильный формат даты рождения", 7);

            if (!(sex.equals("f") || sex.equals("m")))
                throw new FildParametersExceptioin("Неправильный пол", 8);

            // Создание файла
            dataString = "";
            for (String string : dataText) {
                dataString = dataString + "<" + string + "> ";
            }
            String file = lastName + ".txt";
            writeFile(file, dataString);

        } catch (NumberFormatException e) {
            System.out.println("Номер телефона должен быть в формате целого числа");
        } catch (MinDataSizeException e) {
            System.out.println(e.getMessage());
        } catch (FildQuantException e) {
            System.out.println(e.getMessage());
            System.out.println("Число заполненых полей: " + e.getCount());
            System.out.println("Должно быть заполнено шесть полей");
        } catch (FildParametersExceptioin e) {
            System.out.println(e.getMessage());
            e.getErrorCode();
        } catch (FileErrorsException e) {
            System.out.println("Ошибка записи данных в файл");
            System.out.println("Строка данных: ");
            System.out.println(e.getMessage());
            System.out.println("Имя файла: ");
            System.out.println(e.getFileName());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Необрабатываемое исключение");
        }

    }
}
