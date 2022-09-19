package top.starp.util;

import top.starp.copy.Person;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectUtil {

    //深度拷贝
    public static Object deepClone(Object object) throws Exception{
        // 序列化
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

//        oos.writeObject(this);
        oos.writeObject(object);

        // 反序列化
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);

        return ois.readObject();
    }

    public static void main(String[] args) throws Exception {
        Object o = ObjectUtil.deepClone(new Person());
        System.out.println("o Person deepClone");
        System.out.println(o);
//        o Person deepClone
//        Person{pname='null', page=0, address=null}
    }
}
