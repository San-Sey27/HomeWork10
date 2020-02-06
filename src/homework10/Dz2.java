package homework10;

import java.util.Scanner;

/*2) Написать метод. Входящий параметр:
Строка со словами разделенными пробелом которые состоят из больших и маленьких букв.
Метод должен вернуть ту же строку в которой первая буква в каждом слове большая, а остальные маленькие
Например: Test test tESt => Test Test Test*/

public class Dz2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(WordsToUpperCase(str));
    }

    private static String WordsToUpperCase(String str) {
        String[] splitStr = str.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < splitStr.length; i++) {
            String rez = splitStr[i].substring(0, 1).toUpperCase() + splitStr[i].substring(1).toLowerCase() + " ";
            stringBuilder.append(rez);
        }
        return String.valueOf(stringBuilder);
    }
}

