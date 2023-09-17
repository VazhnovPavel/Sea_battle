import java.util.Random;

public class Preparation {
    public static final int EMPTY = 0;
    public static final int ONEDECKERSHIP = 1;
    public static final int FOURDECKERSHIP = 4;

    //соседние клетки, где нельзя размещать корабли
    public static final int[][]  NEIGHBOROFFSETS = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0,  -1},          {0, 1},
            {1,  -1}, {1, 0},  {1, 1}
    };

    /**
     * Создаём поле размером i на j
     */
    public int[][] createField(int i, int j) {
        int[][] battlefield = new int[i][j];
        return battlefield;
    }




    /**
     * Добавляем корабли на поле в случайных местах
     */
    public int[][] addRandomShips(int[][] battlefield) {
        Random random = new Random();

        // Задаем количество кораблей каждого размера
        int[] shipCounts = {4, 3, 2, 1};

        // Прогоняем в массие все корабли всех размеров
        for (int shipSize = FOURDECKERSHIP; shipSize >= ONEDECKERSHIP; shipSize--) {
            for (int shipCount = 0; shipCount < shipCounts[shipSize - 1]; shipCount++) {
                boolean placed = false;

                //выполняется, пока не найдёт места, куда поставить корабль
                while (!placed) {
                    //генерируем случайные координаты и направление
                    int x = random.nextInt(battlefield.length);
                    int y = random.nextInt(battlefield[0].length);
                    boolean horizontal = random.nextBoolean();

                    //если по координатам можно поставить корабль...
                    if (canPlaceShip(battlefield, x, y, shipSize, horizontal)) {
                        //...ставим корабль
                        placeShip(battlefield, x, y, shipSize, horizontal);
                        placed = true;
                    }
                }
            }
        }


        return battlefield;
    }

    /**
     * Делаем проверку, можем ли мы поместить корабль по данным координатам,
     * не нарушив ни одно из условий
     */
    private boolean canPlaceShip(int[][] battlefield, int x, int y, int shipSize, boolean horizontal) {
        if (horizontal) {
            return canPlaceHorizontalShip(battlefield, x, y, shipSize);
        } else {
            return canPlaceVerticalShip(battlefield, x, y, shipSize);
        }
    }

    /**
     * Проверка горизонтальных кораблей
     */
    private boolean canPlaceHorizontalShip(int[][] battlefield, int x, int y, int shipSize) {
        int rows = battlefield.length;
        int cols = battlefield[0].length;

        // Проверка, не выходит ли корабль за границы поля
        if (y + shipSize > cols) {
            return false;
        }

        // Проверяем каждую клетку, есть ли пересечения с другим кораблем
        for (int i = x; i < x + shipSize; i++) {
            for (int j = y; j < y + shipSize; j++) {
                if (i >= 0 && i < rows && j >= 0 && j < cols) {

                    // Есть пересечение с другим кораблем
                    if (battlefield[i][j] != EMPTY) {
                        return false;
                    }
                } else {

                    // Выход за границы массива
                    return false;
                }

                // Проверка соседних клеток
                for (int[] offset : NEIGHBOROFFSETS) {
                    int ni = i + offset[0];
                    int nj = j + offset[1];

                    // Если есть корабль в соседней клетке, возвращаем false
                    if (ni >= 0 && ni < rows && nj >= 0 && nj < cols && battlefield[ni][nj] != EMPTY) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    /**
     * Проверка вертикальных кораблей
     */
    private boolean canPlaceVerticalShip(int[][] battlefield, int x, int y, int shipSize) {
        int rows = battlefield.length;
        int cols = battlefield[0].length;

        // Проверка, не выходит ли корабль за границы поля
        if (x + shipSize > rows) {
            return false;
        }

        // Проверяем каждую клетку, есть ли пересечения с другим кораблем
        for (int i = x; i < x + shipSize; i++) {
            for (int j = y; j < y + shipSize; j++) {
                if (i >= 0 && i < rows && j >= 0 && j < cols) {

                    // Есть пересечение с другим кораблем
                    if (battlefield[i][j] != EMPTY) {
                        return false;
                    }
                } else {

                    // Выход за границы массива
                    return false;
                }

                // Проверка соседних клеток
                for (int[] offset : NEIGHBOROFFSETS) {
                    int ni = i + offset[0];
                    int nj = j + offset[1];

                    // Если есть корабль в соседней клетке, возвращаем false
                    if (ni >= 0 && ni < rows && nj >= 0 && nj < cols && battlefield[ni][nj] != EMPTY) {
                        return false;
                    }
                }
            }
        }

        return true;
    }


    /**
     * Размещаем корабль по разрешенным методом canPlaceShip() координатам
     */
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





