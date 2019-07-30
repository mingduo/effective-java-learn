package effectivejava;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.io.*;

/**
 * 
 * @description:
 * @since 2019/7/26
 * @author : weizc 
 */
public class SingleonObjectInSerializeDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        /**
         * 创建一个使用这两种方法的单例类
         * 仅仅将 implements Serializable 添加到声明中是不够的。
         * 为了维护单例的保证，声明所有的实例属性为 transient
         * ，并提供一个 readResolve 方法 (条目 89)。否则，每
         * 当序列化实例被反序列化时，就会创建一个新的实例，
         */
        serialzeObject( SingleonCat.TOM);

        serialzeObject( SingleonCat3.CAT_3);

        serialzeObject( SingleonCat2.getInstance());

    }

    private static <T extends   Serializable> void serialzeObject(T originalCat) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(originalCat);

        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        T curentCat = (T) objectInputStream.readObject();


        System.out.println("before serialize:"+originalCat +"\nbefore serialize address:"+System.identityHashCode(originalCat));
        System.out.println("after serialize:"+curentCat +"\nafter serialize address:"+System.identityHashCode(curentCat));


        System.out.printf("is serialize : %s\n",(originalCat == curentCat) );
    }


}
@ToString
class SingleonCat implements Serializable {

      String name;

    public static SingleonCat TOM = new SingleonCat("TOM");



    private SingleonCat(String name) {
        this.name=name;

    }
}

@ToString
class SingleonCat2 implements Serializable {

    /*transient */ String name;

    private static SingleonCat2 ourInstance = new SingleonCat2("TOM");

    public static SingleonCat2 getInstance() {
        return ourInstance;
    }

    private SingleonCat2(String name) {
        this.name=name;

    }

    private Object readResolve() {
// Return the one true Elvis and let the garbage collector
// take care of the Elvis impersonator.
        return ourInstance;
    }
}

@AllArgsConstructor
enum SingleonCat3{
    CAT_3("HELE");

    String name;


}