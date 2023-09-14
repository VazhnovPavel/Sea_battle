import java.util.Random;

public class Preparation {


    public int[][] createField(int i,int j){

        //Создаем два поля 10 на 10
        int[][] battlefield = new int[i][j];

    return battlefield;
    }

    public int[][] addRandomShips(int[][] field, int ... ships) {
        Random random = new Random();

        for (int ship : ships) {
            do {
                boolean horizontalShip = random.nextBoolean();
                int i, j;

                if (horizontalShip) {
                    i = random.nextInt(field.length);
                    j = random.nextInt(field[0].length - ship + 1); // Учтем длину корабля
                } else {
                    i = random.nextInt(field.length - ship + 1); // Учтем длину корабля
                    j = random.nextInt(field[0].length);
                }

                if (condition_1(field, i, j) && condition_2(field, i, j) && condition_3(field, i, j)) {
                    for (int k = 0; k < ship; k++) {
                        if (horizontalShip) {
                            field[i][j + k] += 1;
                        } else {
                            field[i + k][j] += 1;
                        }
                    }
                }
            } while (!isValid(field));
        }

        return field;
    }


        private boolean condition_1 ( int[][] field, int i, int j){
            // Проверяем, что координаты находятся в пределах массива
            if (i >= 0 && i < field.length && j >= 0 && j < field[0].length) {
                // Проверяем, что значение в указанной ячейке равно 0
                return field[i][j] == 0;
            } else {
                // Координаты находятся за пределами массива, или не пустые
                return false;
            }
        }
        private boolean condition_2 ( int[][] field, int i, int j){
            // Проверка соседних клеток: сверху, снизу, слева, справа
            boolean aboveIsEmpty = i > 0 && (field[i - 1][j] == 0);
            boolean belowIsEmpty = i < field.length - 1 && (field[i + 1][j] == 0);
            boolean leftIsEmpty = j > 0 && (field[i][j - 1] == 0);
            boolean rightIsEmpty = j < field[0].length - 1 && (field[i][j + 1] == 0);

            // Если все соседние клетки пусты, то возвращаем true, иначе false
            return aboveIsEmpty && belowIsEmpty && leftIsEmpty && rightIsEmpty;
        }

        private boolean condition_3 ( int[][] field, int i, int j){
            // Проверка клеток по диагонали: справа-верх, справа-вниз, слева-верх, слева-низ
            boolean upperRightIsEmpty = i > 0 && j < field[0].length - 1 && (field[i - 1][j + 1] == 0);
            boolean lowerRightIsEmpty = i < field.length - 1 && j < field[0].length - 1 && (field[i + 1][j + 1] == 0);
            boolean upperLeftIsEmpty = i > 0 && j > 0 && (field[i - 1][j - 1] == 0);
            boolean lowerLeftIsEmpty = i < field.length - 1 && j > 0 && (field[i + 1][j - 1] == 0);

            // Если все клетки по диагонали пусты, то возвращаем true, иначе false
            return upperRightIsEmpty && lowerRightIsEmpty && upperLeftIsEmpty && lowerLeftIsEmpty;
        }

    // Допустимая конфигурация поля
    private boolean isValid(int[][] field) {
        // Реализуйте проверку допустимости поля
        return true;
    }
    }

