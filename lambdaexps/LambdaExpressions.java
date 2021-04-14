package lambdaexps;

public class LambdaExpressions {
    public static void main(String[] args) {
        // LambdaExpressions with no return type
        emp e = (name, designation) -> {
            System.out.println("Name: " + name + "\nDesignation: " + designation);
        };

        e.display("Sergio", "The Professor");

        // LambdaExpressions with a return type
        test t = (a, b) -> {
            return a + b;
        };
        int ans = t.add(3, 2);
        System.out.println(ans);

        // LambdaExpressions with threads because Runnable is a functional interface
        Runnable r = () -> {
            System.out.println("I am from thread 1");
        };

        Thread thr1 = new Thread(r);
        thr1.start();
    }
}

// functional interface - it is an interface that has only one (abstract) method
interface emp {
    void display(String name, String designation);
}

interface test {
    int add(int a, int b);
}