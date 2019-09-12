package staticProxy;

/**
 * @author Strangekindness
 * @desciption 委托类ME
 * @Created 2019年09月12日  9:50
 */
public class Me implements Human{

    @Override
    public void eat() {
        System.out.println("吃啊吃");
    }

    @Override
    public void sleep() {
        System.out.println("睡啊睡");
    }

    @Override
    public void buy() {
        System.out.println("买啊买");
    }
}
