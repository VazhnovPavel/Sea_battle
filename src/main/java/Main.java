

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
        int[][] battlefield_player = preparation.createField(WIDTH_FIELD,HEIGHT_FIELD);
        int[][] battlefield_computer = preparation.createField(WIDTH_FIELD,HEIGHT_FIELD);
        int[][] battlefield_X = preparation.createField(WIDTH_FIELD,HEIGHT_FIELD);
        // Размещаем корабли игрока и компьютера в случайном порядке
        battlefield_player = preparation.addRandomShips(battlefield_player);
        battlefield_computer = preparation.addRandomShips(battlefield_computer);

        gaming.printBattlefields(battlefield_player,"Твоё поле");
       // System.out.println("\nПоле компьютера");
       // printBattlefield(battlefield_computer);

        gaming.printBattlefields(battlefield_X,"\nЗакрытое поле компьютера");

        System.out.println(RULES);
        gaming.start(battlefield_player,battlefield_computer,battlefield_X);

    }

    /**
     * Печатаем поля боя с кораблями в консоль
     */
//    public static void printIntBattlefield(int[][] field) {
//        for (int i = 0; i < field.length; i++) {
//            for (int j = 0; j < field[0].length; j++) {
//                System.out.print(field[i][j] + " ");
//            }
//            // Переход на новую строку после каждой строки поля
//            System.out.println();
//        }
//    }

}
