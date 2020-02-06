package homework10;

import java.util.Random;

/* 3) Создать генератор паролей, который будет генерировать случайные пароли по следующим правилам:
Пароль состоит из 8 символов
В пароле допускаются только латинские большие и маленькие буквы, цифры и символ подчеркивания
Пароль обязательно должен содержать Большие и маленькие буквы и цифры */

public class Dz3 {
    private static final int LENGTH_PASSWORD = 8;

    public static void main(String[] args) {
        char[] password = yourPassword();
        System.out.println(password);
    }

    private static char[] yourPassword() {
        char[] password = generatePassword();
        boolean lowerCaseChar = false;
        boolean upperCaseChar = false;
        boolean numbersChar = false;
        for (int i = 0; i < password.length; i++) {
            if (password[i] >= 'a' && password[i] <= 'z') {
                lowerCaseChar = true;
            }
            if (password[i] >= 'A' && password[i] <= 'Z') {
                upperCaseChar = true;
            }
            if (password[i] >= '0' && password[i] <= '9') {
                numbersChar = true;
            }
        }
        if (lowerCaseChar == true && upperCaseChar == true && numbersChar == true) {
            return password;
        }else {
            return generatePassword();
        }
    }

    private static char[] generatePassword() {
        Random random = new Random();
        String symbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_0123456789";
        char[] password = new char[LENGTH_PASSWORD];
        for (int i = 0; i < LENGTH_PASSWORD; i++) {
            password[i] = symbols.charAt(random.nextInt(symbols.length()));
        }
        return password;
    }
}
