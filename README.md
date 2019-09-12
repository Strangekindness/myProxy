# 自己写的动态代理小demo

- 代理模式在Java领域很多地方都有应用，它分为静态代理和动态代理，其中SpringAOP就是动态代理的典型例子。动态代理又分为接口代理和cglib（子类代理）
## 静态代理

- 为其他对象提供一种代理以控制对这个对象的访问。在某些情况下，一个对象不适合或者不能直接引用另一个对象，而代理对象可以在客户端和目标对象之间起到中介的作用

- 项目中黄牛（Scalper）就只是做了我们不愿意做的事（排队买票），实际看演唱会的人还是我。客户端也并不关心代理类代理了哪个类，因为代码控制了客户端对委托类的访问。
客户端代码表现为 Human human = new Scalper();
- 但是代理类实现了抽象角色的接口，导致代理类无法通用。比如，我的狗病了，想去看医生，但是排队挂号很麻烦，我也想有个黄牛帮我的排队挂号看病。
但是黄牛它不懂这只狗的特性（黄牛跟狗不是同一类型，黄牛属于Human但狗属于Animal类但排队挂号和排队买票相对于黄牛来说它两就是一件事，这个方法是不变的，现场排队。
那我们能不能找一个代理说既可以帮人排队买票也可以帮狗排队挂号呢？
- 答案肯定是可以的，可以用动态代理。



## 动态代理


- 如静态代理的内容所描述的，静态代理受限于接口的实现。动态代理就是通过使用反射，动态地获取抽象接口的类型，从而获取相关特性进行代理。因动态代理能够为所有的委托方进行代理



## 注意

- 基于接口类的动态代理模式，必须具备抽象角色、委托类、代理三个基本角色。委托类和代理类必须由抽象角色衍生出来，否则无法使用该模式。
  
- 动态代理模式最后返回的是具有抽象角色（顶层接口）的对象。在委托类内被private或者protected关键修饰的方法将不会予以调用，即使允许调用。也无法在客户端使用代理类转换成子类接口，对方法进行调用。也就是说上述的动态代理返回的是委托类（Me）或（Dog）的就接口对象（Human）或（Animal）。
- 在invoke方法内为什么不使用第一个参数进行执行回调。在客户端使用"getProxyInstance(newChild())"时，JDK会返回一个proxy的实例，实例内有InvokecationHandler对象及动态继承下来的目标。客户端调用了目标方法，有如下操作：首先JDK先查找proxy实例内的handler对象,然后执行handler内的invoke方法。
- 根据invoke这个方法第一个参数proxy就是对应着proxy实例。如果在invoke内使用method.invoke(proxy,args),会出现这样一条方法链，目标方法→invoke→目标方法→invoke…，最终导致堆栈溢出。