import java.io.*;

/** Client that uses AdditionBean, and also demonstrates serialization of the bean. */
public class BeanTest {
    public static void main(String[] args) throws Exception {
        AdditionBean bean = new AdditionBean();
        bean.setNum1(15);
        bean.setNum2(27);
        System.out.println("Number 1 : " + bean.getNum1());
        System.out.println("Number 2 : " + bean.getNum2());
        System.out.println("Sum      : " + bean.getSum());

        // Serialize and restore to show persistence of bean state
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(bean);
        }
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()))) {
            AdditionBean restored = (AdditionBean) ois.readObject();
            System.out.println("After serialization -> Sum: " + restored.getSum());
        }
    }
}
