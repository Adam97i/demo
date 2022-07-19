package rpc.v1;

import rpc.v1.server.domain.User;
import rpc.v1.server.service.IUserService;

/**
 * 借助反射与动态代理，解耦了代码
 * 问题：
 *      服务端的地址端口写死
 *      需要知道服务端的服务类
 *      BIO获取
 */
public class RPCClient {
    public static void main(String[] args) {

        ClientProxy clientProxy = new ClientProxy("127.0.0.1", 8899);
        IUserService proxy = clientProxy.getProxy(IUserService.class);

        // 服务的方法1
        User userByUserId = proxy.getUserByUserId(10);
        System.out.println("从服务端得到的user为：" + userByUserId);
        // 服务的方法2
        User user = new User("dada","adam");
        Integer integer = proxy.insertUserId(user);
        System.out.println("向服务端插入数据："+integer);
    }
}