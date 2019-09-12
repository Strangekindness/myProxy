package dynamicProxy;

import staticProxy.Human;
import staticProxy.Me;

/**
 * @author Strangekindness
 * @desciption 主函数
 * @Created 2019年09月12日  10:08
 */
public class Main {
    public static void main(String[] args){
        ScalperHandle scalperHandle = new ScalperHandle();
        Human human = (Human) scalperHandle.getProxyInstance(new Me());

        human.eat();
        human.sleep();
        human.buy();

        System.out.println("------------------");

        Animal animal = (Animal) scalperHandle.getProxyInstance(new Dog());
        animal.run();
        animal.jump();
        animal.talk();
    }
}
