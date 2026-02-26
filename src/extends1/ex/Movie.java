package extends1.ex;

public class Movie extends Item{

    private String direcotr;
    private String acotr;

    public Movie(String name, int price, String direcotr, String acotr) {
        super(name, price);
        this.direcotr = direcotr;
        this.acotr = acotr;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("- 감독:" + direcotr + ", 배우:" + acotr);
    }
}
