package com.ssm.demo.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class LocalMain {

    public static void main(String[] args) {

        UserApi userApi= (UserApi) rpc(UserApi.class);
        User user=userApi.selectById(1);
        System.out.println("本地输出远程调用结果：\n"+user.toString());

    }

    public static Object rpc(final Class clazz){
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = new Socket("127.0.0.1", 8888);
                String className = clazz.getName();//api类名
                String methodName = method.getName(); // api 方法名
                Class<?>[] parameterTypes = method.getParameterTypes(); // 方法参数类型集合

                ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeUTF(className);
                objectOutputStream.writeUTF(methodName);
                objectOutputStream.writeObject(parameterTypes);
                objectOutputStream.writeObject(args);

                ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
                Object o=objectInputStream.readObject();
                objectInputStream.close();
                objectOutputStream.close();

                return o;
            }
        });
    }
}
