import java.util.Scanner;

public class ConvertAmount {

    static final double ROUBLES_PER_DOLLAR = 72.12;
    public static void main(String[] args) {

        int[] dollarsArray;
        double[] roublesArray;
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

        //Получить n сумм денег в долларах
        System.out.print("Введите " + n + " сумм денег в американских долларах через пробел: ");
        dollarsArray = new int[n];
        for (i = 0; i < n; i++) {
            dollarsArray[i] = input.nextInt();
        }

        //Конвертировать сумму денег в российские рубли
        roublesArray = find_roubles(dollarsArray, n);

        //Отобразить в таблице n сумм денег в американских долларах и
        // эквивалентные ии суммы денег в российских рублях в пользу покупателя
        System.out.println("\n  Сумма, Р    Сумма, $");
        for (i = 0; i < n; i++) {
            System.out.println("\t" + dollarsArray[i] + "\t"
                + (int)(roublesArray[i] * 100) / 100.0);
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
     * Конвертирует n сумм денег из американских долларов в российские рубли
     */
    public static double[] find_roubles(int[] dollarsArray, int n) {
        double[] roublesArray = new double[n];
        int i;
        for (i = 0; i < n; i++) {
            roublesArray[i] = ROUBLES_PER_DOLLAR * dollarsArray[i];
        }
        return roublesArray;
    }
}