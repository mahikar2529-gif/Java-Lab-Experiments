import java.io.Serializable;

/**
 * Experiment 10: A JavaBean for addition of two numbers.
 * Rules followed: public no-argument constructor, private properties with
 * getters/setters, and implements Serializable.
 */
public class AdditionBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private int num1;
    private int num2;

    public AdditionBean() { }

    public int getNum1() { return num1; }
    public void setNum1(int num1) { this.num1 = num1; }

    public int getNum2() { return num2; }
    public void setNum2(int num2) { this.num2 = num2; }

    /** Read-only property "sum". */
    public int getSum() { return num1 + num2; }
}
