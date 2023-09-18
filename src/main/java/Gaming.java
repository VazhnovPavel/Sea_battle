import java.util.Random;
import java.util.Scanner;

public class Gaming {
    public void start(int[][] intBattlefield_player, int[][] intBattlefield_computer, int[][] intBattlefield_X) {

        // Преобразование массивов из int в String (для того, чтобы ставить символы 'X' и '•')
        String[][] battlefield_player = convertIntArrayToStringArray(intBattlefield_player);
        String[][] battlefield_computer = convertIntArrayToStringArray(intBattlefield_computer);
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
            } while (playerX < 0 || playerX >= battlefield_computer.length || playerY < 0 || playerY >= battlefield_computer[0].length);

            //Проверяем, попал ли игрок, и выводим информацию в консоль
            checkShoot(battlefield_computer,battlefield_X,playerX,playerY,"Игрок");


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

                computerX = random.nextInt(battlefield_player.length  );
                computerY = random.nextInt(battlefield_player[0].length );
                System.out.println("Компьютер ходит " + ((computerX)+1) +" " + ((computerY)+1)+ " и...");

                //Проверяем, попал ли компьютер, и выводим информацию в консоль
                checkShoot(battlefield_player,battlefield_X,computerX,computerY,"Компьютер");

            // Вывод поля игрока
            printBattlefields(battlefield_player, "Твоё поле");

            // Проверка на победу компьютера
            if (checkForVictory(battlefield_player, "Компьютеру")) {
                System.out.println("Компьютер выиграл!");
                break;
            }
        }
    }

    // Метод для вывода полей
//    protected void printStringBattlefields(String[][] battlefield, String title) {
//        System.out.println(title);
//        for (String[] row : battlefield) {
//            for (String cell : row) {
//                System.out.print(cell + " ");
//            }
//            System.out.println();
//        }
//    }

    protected void printBattlefields(String[][] battlefield, String title) {
        System.out.println(title);
        for (String[] row : battlefield) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    protected void printBattlefields(int[][] battlefield, String title) {
        System.out.println(title);
        for (int[] row : battlefield) {
            for (int cell : row) {
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

    public void checkShoot(String[][] battlefield,String[][] battlefield_X, int x, int y, String whoShoot) {
        if (battlefield[x][y].equals("1") || battlefield[x][y].equals("2") ||
                battlefield[x][y].equals("3") || battlefield[x][y].equals("4")) {

            if (whoShoot.equals("Игрок")) {
                battlefield_X[x][y] = "X";
                System.out.println(whoShoot + " попал!\n");
            }
            else if (whoShoot.equals("Компьютер")) {
                battlefield[x][y] = "X";
                System.out.println(whoShoot + " попал!\n");
            }
        } else {
            // Промах
            if (whoShoot.equals("Игрок")) {
                battlefield_X[x][y] = "•";
                System.out.println("Промах!\n");
            }
            else if (whoShoot.equals("Компьютер")) {
                battlefield[x][y] = "•";
                System.out.println("Промах!\n");
            }
        }
    }



}
