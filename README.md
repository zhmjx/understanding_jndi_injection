# understanding_jndi_injection
understanding jndi injection, rmi for example

# 注意事项
+ RemoteObject模式下register、server、client均需共享接口class
+ Reference模式下clinet要关闭两个安全选项，见相应cmd.txt

# 总结
JNDI Reference注入：JNDI服务绑定Reference对象的时候，JNDI客户端lookup(url) 将使用URLClassLoader从远程服务器加载class，恶意url将造成RCE。
    -JNDI客户端会加载reference绑定的ObjectFactory类并实例化，而JNDI客户端作为目标，因而JNDI server恶意类的静态代码块、构造函数、getObjectInstance等动作可以在JNDI Client上实现RCE；
    -而当JNDI绑定传统的Remote Object时，JNDI客户端只需要和JNDI Server共享某个接口定义，然后通过反序列化传递对象和接受结果就可以，不需要去JNDI server加载类，恶意方法均在server执行，
    不会影响Client的安全。
    -Reference出现的意义由此也能窥见一斑，即JNDI Client和JNDI Server不需要维护统一的接口了，通过统一的Reference规范远程加载统一的ObjectFactory类和实例化类来完成远程调用。

# demo结构
![image](https://user-images.githubusercontent.com/70132162/119106419-ecec6f00-ba50-11eb-82bf-e76306b3ec5a.png)
