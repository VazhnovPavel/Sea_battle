import java.sql.SQLOutput;

public class Main {
    static final String WELCOME = "Добро пожаловать в игру «Морской Бой»! \n" +
            "Начнём игру :) \n" +
            "";
    static final int WIDTH_FIELD = 10;
    static final int HEIGHT_FIELD = 10;





    public static void main(String[] args) {
        System.out.println(WELCOME);
        Preparation preparation = new Preparation();
        int[][] battlefield_1 = preparation.createField(WIDTH_FIELD,HEIGHT_FIELD);
        int[][] battlefield_2 = preparation.createField(WIDTH_FIELD,HEIGHT_FIELD);

        battlefield_1 = preparation.addRandomShips(battlefield_1);
        battlefield_2 = preparation.addRandomShips(battlefield_2);

        System.out.println("Твоё поле");
        printBattlefield(battlefield_1);
        System.out.println("\nПоле компьютера");
        printBattlefield(battlefield_2);

    }

    public static void printBattlefield(int[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println(); // Переход на новую строку после каждой строки поля
        }
    }

}
