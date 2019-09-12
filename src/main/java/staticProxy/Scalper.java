package staticProxy;

/**
 * @author Strangekindness
 * @desciption 静态代理黄牛
 * @Created 2019年09月12日  9:54
 */
public class Scalper implements Human{

    private Me me;

    public Scalper(){
        me = new Me();
    }

    @Override
    public void eat() {

    }

    @Override
    public void sleep() {

    }

    @Override
    public void buy() {
        this.buyTicket();
        me.buy();
    }

    public void buyTicket(){
        System.out.println("黄牛帮人买票");
    }
}
