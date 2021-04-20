package exception;

public class ExceptionDemo {
    public static void f1() throws Exception {
        throw new Exception("Exception is thrown");
    }

    public static void f2() throws Exception {
        f1();
    }

    public static void main(String[] args) {
        try {
            f2();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
