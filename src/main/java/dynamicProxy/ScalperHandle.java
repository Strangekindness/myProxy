package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Strangekindness
 * @desciption 动态代理黄牛
 * @Created 2019年09月12日  10:03
 */

//静态代理与动态代理的区别
//静态代理需要自己写代理类并一一实现目标方法，且代理类必须实现与目标对象相同的接口。
//动态代理不需要自己实现代理类，它是利用 JDKAPI，动态地在内存中构建代理对象（需要我们传入被代理类），并且默认实现所有目标方法。

public class ScalperHandle implements InvocationHandler {

    private Object proxyTarget;

    public Object getProxyInstance(Object target) {
        this.proxyTarget = target;
        // 第一个参数，是类的加载器
        // 第二个参数是委托类的接口类型，证代理类返回的是同一个实现接口下的类型，保持代理类与抽象角色行为的一致
        // 第三个参数就是代理类本身，即告诉代理类，代理类遇到某个委托类的方法时该调用哪个类下的invoke方法
        return Proxy.newProxyInstance(proxyTarget.getClass().getClassLoader(), proxyTarget.getClass().getInterfaces(), this);
    }


    // 第一个参数为 Proxy 类类型实例，如匿名的 $proxy 实例
    // 第二个参数为委托类的方法对象
    // 第三个参数为委托类的方法参数
    // 返回类型为委托类某个方法的执行结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object methodObject = null;


        /*//未加方法限定，即代理所有方法
        System.out.println("黄牛干活了");
        methodObject = method.invoke(proxyTarget, args);
        System.out.println("黄牛干完了");*/


        if ("buy".equals(method.getName()) || "talk".equals(method.getName())) {
            System.out.println("黄牛干活了");
            // 调用目标方法
            methodObject = method.invoke(proxyTarget, args);
            System.out.println("黄牛干完了");
        } else {
            // 不使用第一个proxy参数作为参数，否则会造成死循环
            methodObject = method.invoke(proxyTarget, args);
        }


        return methodObject;
    }

}
