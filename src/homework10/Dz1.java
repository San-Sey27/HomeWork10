package homework10;
/*1) Вывести в 1 строку через пробел все числа от 1 до 99 со следующими изменениями:
- если число кратно 3 то вывести вместо него Hello
- если число кратно 5 то вывести вместо него World
- если число кратно и 3 и 5 то вывести вместо него HelloWorld*/

public class Dz1 {
    public static void main(String[] args) {

        for (int i = 1; i < 99; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                System.out.print("HelloWorld ");
            } else if (i % 5 == 0) {
                System.out.print("World ");
            } else if (i % 3 == 0) {
                System.out.print("Hello ");
            } else {
                System.out.print(" " + i + " ");
            }
        }
    }
}
