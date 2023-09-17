

public class Main {
    static final String WELCOME = "Добро пожаловать в игру «Морской Бой»! \n" +
            "Тебе предстоит играть против компьютера. Побеждает тот, кто первым потопит все корабли \n" +
            "Начнём игру :) \n" +
            "";
    static final String RULES = "\nТвой ход первым. Побеждает тот, кто потопит все 20 палуб";
    static final int WIDTH_FIELD = 10;
    static final int HEIGHT_FIELD = 10;


    public static void main(String[] args) {
        System.out.println(WELCOME);
        Preparation preparation = new Preparation();
        Gaming gaming = new Gaming();

        // Добавляем игровые поля
        int[][] battlefield_1 = preparation.createField(WIDTH_FIELD,HEIGHT_FIELD);
        int[][] battlefield_2 = preparation.createField(WIDTH_FIELD,HEIGHT_FIELD);
        int[][] battlefield_X = preparation.createField(WIDTH_FIELD,HEIGHT_FIELD);
        // Размещаем корабли игрока и компьютера в случайном порядке
        battlefield_1 = preparation.addRandomShips(battlefield_1);
        battlefield_2 = preparation.addRandomShips(battlefield_2);

        System.out.println("Твоё поле");
        printBattlefield(battlefield_1);
       // System.out.println("\nПоле компьютера");
       // printBattlefield(battlefield_2);
        System.out.println("\nЗакрытое поле компьютера");
        printBattlefield(battlefield_X);

        System.out.println(RULES);
        gaming.start(battlefield_1,battlefield_2,battlefield_X);

    }

    /**
     * Печатаем поля боя с кораблями в консоль
     */
    public static void printBattlefield(int[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            // Переход на новую строку после каждой строки поля
            System.out.println();
        }
    }

}
