import java.util.Random;

public class Preparation {
    public static final int EMPTY = 0;
    public static final int ONEDECKERSHIP = 1;
    public static final int FOURDECKERSHIP = 4;

    public int[][] createField(int i, int j) {
        //Создаем два поля i на j
        int[][] battlefield = new int[i][j];
        return battlefield;
    }

    public int[][] addRandomShips(int[][] battlefield) {
        Random random = new Random();

        // Задаем количество кораблей каждого размера
        int[] shipCounts = {4, 3, 2, 1};

        for (int shipSize = FOURDECKERSHIP; shipSize >= ONEDECKERSHIP; shipSize--) {
            for (int shipCount = 0; shipCount < shipCounts[shipSize - 1]; shipCount++) {
                boolean placed = false;

                while (!placed) {
                    int x = random.nextInt(battlefield.length);
                    int y = random.nextInt(battlefield[0].length);
                    boolean horizontal = random.nextBoolean();

                    if (canPlaceShip(battlefield, x, y, shipSize, horizontal)) {
                        placeShip(battlefield, x, y, shipSize, horizontal);
                        placed = true;
                    }
                }
            }
        }

        return battlefield;
    }

    private boolean canPlaceShip(int[][] battlefield, int x, int y, int shipSize, boolean horizontal) {
        int rows = battlefield.length;
        int cols = battlefield[0].length;

        int[][] neighborOffsets = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},           {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        if (horizontal) {
            if (y + shipSize > cols) {
                return false; // Корабль не помещается по горизонтали
            }

            for (int i = x; i < x + shipSize; i++) {
                for (int j = y; j < y + shipSize; j++) {
                    if (i >= 0 && i < rows && j >= 0 && j < cols) {
                        if (battlefield[i][j] != EMPTY) {
                            return false; // Есть пересечение с другим кораблем
                        }
                    } else {
                        return false; // Выход за границы массива
                    }




            // Проверка соседних клеток
                    for (int[] offset : neighborOffsets) {
                        int ni = i + offset[0];
                        int nj = j + offset[1];
                        if (ni >= 0 && ni < rows && nj >= 0 && nj < cols && battlefield[ni][nj] != EMPTY) {
                            return false; // Есть корабль в соседней клетке
                        }
                    }
                }
            }
        } else {
            if (x + shipSize > rows) {
                return false; // Корабль не помещается по вертикали
            }


            for (int i = x; i < x + shipSize; i++) {
                for (int j = y; j < y + shipSize; j++) {
                    if (i >= 0 && i < rows && j >= 0 && j < cols) {
                        if (battlefield[i][j] != EMPTY) {
                            return false; // Есть пересечение с другим кораблем
                        }
                    } else {
                        return false; // Выход за границы массива
                    }

                    // Проверка соседних клеток
                    for (int[] offset : neighborOffsets) {
                        int ni = i + offset[0];
                        int nj = j + offset[1];
                        if (ni >= 0 && ni < rows && nj >= 0 && nj < cols && battlefield[ni][nj] != EMPTY) {
                            return false; // Есть корабль в соседней клетке
                        }
                    }
                }
            }
        }

        return true;
    }



    private void placeShip(int[][] battlefield, int x, int y, int shipSize, boolean horizontal) {
        if (horizontal) {
            for (int i = y; i < y + shipSize; i++) {
                battlefield[x][i] = shipSize;
            }
        } else {
            for (int i = x; i < x + shipSize; i++) {
                battlefield[i][y] = shipSize;
            }
        }
    }
}





