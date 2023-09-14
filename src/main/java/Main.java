public class Main {
    static final String WELCOME = "Добро пожаловать в игру «Морской Бой»! \n" +
            "Начнём игру :) \n" +
            "";
    static final int FOURDECKERSHIP = 1;
    static final int THREEDECKERSHIP = 2;
    static final int TWORDECKERSHIP = 3;
    static final int ONEDECKERSHIP = 4;
    static final int WIDTH_FIELD = 10;
    static final int HEIGHT_FIELD = 10;









    public static void main(String[] args) {
        System.out.println(WELCOME);
        Preparation preparation = new Preparation();
        int[][] battlefield_1 = preparation.createField(WIDTH_FIELD,HEIGHT_FIELD);
        int[][] battlefield_2 = preparation.createField(WIDTH_FIELD,HEIGHT_FIELD);



    }



}
