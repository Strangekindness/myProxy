package dynamicProxy;

/**
 * @author Strangekindness
 * @desciption 委托类Dog
 * @Created 2019年09月12日  10:18
 */
public class Dog implements Animal {
    @Override
    public void run() {
        System.out.println("跑啊跑");
    }

    @Override
    public void jump() {
        System.out.println("跳啊跳");
    }

    @Override
    public void talk() {
        System.out.println("和它交流");
    }
}
