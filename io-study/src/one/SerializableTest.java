package one;
import java.io.*;
public class SerializableTest {
    public static void main(String[] args) throws Exception {
//        new SerializableTest().new Person2();
//        SerializableTest stest=new SerializableTest();
//        stest.new Person2();
        Person person=new SerializableTest.Person();
        //序列化
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("D:\\Kernel-Code\\io-study\\Io测试\\person"));
        oos.writeObject(person);
        //反序列化
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("D:\\Kernel-Code\\io-study\\Io测试\\person"));
        Person person1=(Person)ois.readObject();
        System.out.println(person1);
    }
    private static class Person implements Serializable {
        private String name;
        private Integer age;
    }
//    private class Person2{ }
}
