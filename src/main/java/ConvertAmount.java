import java.util.Scanner;

public class ConvertAmount {

    static final double ROUBLES_PER_DOLLAR = 72.12;
    public static void main(String[] args) {

        int dollars;
        double roubles;
        int digit;
        int n;
        int i;

        Scanner input = new Scanner(System.in);

        //отобразить инструкцию
        instruct();

        //Получать количество конвертаций по тех пор,
        //пока не введено корректное значение
        do {
            System.out.print("Введите корректное количество конвертаций: ");
            n = input.nextInt();
        } while (n <= 0);

        //До тех пор, пока не конвертированы все суммы, получать,
        //отображать и конвертировать суммы денег в американских
        //долларах и отображать суммы денег в российских рублях

        for (i = 0; i < n; ++i) {

            //Получить сумму денег в долларах
            System.out.print("Введите сумму денег в американских долларах: ");
            dollars = input.nextInt();

            //Отобразить сумму денег в американских долларах
            //с правильным окончанием
            System.out.print(dollars);

            if (5 <= dollars && dollars <= 20) {
                System.out.print(" американских долларов равны ");
            } else {
                digit = dollars % 10;

                if (digit == 1) {
                    System.out.print(" американский доллар равен ");
                } else if (2 <= digit && digit <= 4) {
                    System.out.print(" американских доллара равны ");
                } else {
                    System.out.print(" американских долларов равны ");
                }
            }

            //Конвертировать сумму денег в российские рубли
            roubles = find_roubles(dollars);

            //Отобразить сумму денег в российских рублях в пользу покупателя
            System.out.println((int) (roubles * 100) / 100.0
                    + " российского рубля.");
        }
    }

    /**
     * Отображает инструкцию
     */
    public static void instruct() {
        System.out.println("Эта программа конвертирует сумму денег "
            + "из американских долларов в российские рубли.");
        System.out.println("Курс покупки равен " + ROUBLES_PER_DOLLAR
            + " рубля.\n");
    }

    /**
     * Конвертирует сумму денег из американских долларов в российские рубли
     */
    public static double find_roubles(int dollars) {
        return ROUBLES_PER_DOLLAR * dollars;
    }
}