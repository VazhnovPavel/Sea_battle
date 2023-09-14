public class Main {
    static final String WELCOME = "Добро пожаловать в игру «Морской Бой»! \n" +
            "Начнём игру :) \n" +
            "";
    static final int ONEDECKERSHIP = 1;
    static final int TWODECKERSHIP = 2;
    static final int THREERDECKERSHIP = 3;
    static final int FOURDECKERSHIP = 4;
    static final int WIDTH_FIELD = 10;
    static final int HEIGHT_FIELD = 10;





    public static void main(String[] args) {
        System.out.println(WELCOME);
        Preparation preparation = new Preparation();
        int[][] battlefield_1 = preparation.createField(WIDTH_FIELD,HEIGHT_FIELD);
        int[][] battlefield_2 = preparation.createField(WIDTH_FIELD,HEIGHT_FIELD);

        battlefield_1 = preparation.addRandomShips(battlefield_1,ONEDECKERSHIP,TWODECKERSHIP,
                THREERDECKERSHIP,FOURDECKERSHIP);


    }



}
