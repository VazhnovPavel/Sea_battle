import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Gaming {
    public void start(int[][] intBattlefield_1, int[][] intBattlefield_2, int[][] intBattlefield_X) {

        // Преобразование массивов из int в String (для того, чтобы ставить символы 'X' и '•'
        String[][] battlefield_1 = convertIntArrayToStringArray(intBattlefield_1);
        String[][] battlefield_2 = convertIntArrayToStringArray(intBattlefield_2);
        String[][] battlefield_X = convertIntArrayToStringArray(intBattlefield_X);

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Игра идёт, пока кто-то не потопит все корабли
        while (true) {
            // Ход игрока
            System.out.println("Ход игрока:");
            int playerX, playerY;

            do {
                System.out.print("Введи координаты выстрела (строка и столбец, например, 1 2): ");
                playerX = scanner.nextInt() - 1; // -1, чтобы сделать индексацию с 0
                playerY = scanner.nextInt() - 1;
            } while (playerX < 0 || playerX >= battlefield_2.length || playerY < 0 || playerY >= battlefield_2[0].length);

            if (battlefield_2[playerX][playerY].equals("1") ||
                    battlefield_2[playerX][playerY].equals("2") ||
                    battlefield_2[playerX][playerY].equals("3") ||
                    battlefield_2[playerX][playerY].equals("4")) {
                battlefield_X[playerX][playerY] = "X";
                System.out.println("Попадание!");
            } else {
                // Промах
                battlefield_X[playerX][playerY] = "•";
                System.out.println("Промах!");
            }

            //Вывод поля компьютера
            printBattlefields(battlefield_X, "Закрытое поле компьютера");
            // Проверка на победу игрока
            if (checkForVictory(battlefield_X, "Игроку")) {
                System.out.println("Игрок выиграл!");
                break;
            }

            // Ход компьютера
            System.out.println("Ход компьютера:");
            int computerX, computerY;

                computerX = random.nextInt(battlefield_1.length  );
                computerY = random.nextInt(battlefield_1[0].length );
                System.out.println("Компьютер ходит " + ((computerX)+1) +" " + ((computerY)+1)+ " и...");


            if (battlefield_1[computerX][computerY].equals("1") ||
                    battlefield_1[computerX][computerY].equals("2") ||
                    battlefield_1[computerX][computerY].equals("3") ||
                    battlefield_1[computerX][computerY].equals("4")) {

                // Попадание компьютера
                battlefield_1[computerX][computerY] = "X";
                System.out.println("Компьютер попал!");
            } else {
                // Промах компьютера
                battlefield_1[computerX][computerY] = "•";
                System.out.println("Компьютер промахнулся!");
            }

            // Вывод поля игрока
            printBattlefields(battlefield_1, "Твоё поле");

            // Проверка на победу компьютера
            if (checkForVictory(battlefield_1, "Компьютеру")) {
                System.out.println("Компьютер выиграл!");
                break;
            }
        }
    }

    // Метод для вывода полей
    private void printBattlefields(String[][] battlefield, String title) {
        System.out.println(title);
        for (String[] row : battlefield) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    // Метод для преобразования int[][] в String[][]
    private String[][] convertIntArrayToStringArray(int[][] intArray) {
        String[][] strArray = new String[intArray.length][intArray[0].length];
        for (int i = 0; i < intArray.length; i++) {
            for (int j = 0; j < intArray[0].length; j++) {
                strArray[i][j] = Integer.toString(intArray[i][j]);
            }
        }
        return strArray;
    }




    private boolean checkForVictory(String[][] checkField, String player) {
        int countX = 0; // Переменная для подсчета символов 'X'

        // Перебираем каждую клетку в массиве
        for (int row = 0; row < checkField.length; row++) {
            for (int col = 0; col < checkField[0].length; col++) {
                if (checkField[row][col].equals("X")) {
                    countX++; // Если клетка содержит 'X', увеличиваем счетчик
                }
            }
        }

        // Проверяем, если счетчик символов 'X' больше или равен 20, возвращаем true
        System.out.println(player+ " осталось потопить "+ (20 - countX) + " палуб \n");
        return countX >= 20;
    }


}
