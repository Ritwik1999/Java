/*
    An exception can describe the cause of another exception.
    e.g., Sometimes, a SQLException can be a cause for a NullPointerException or ArithmeticException
    The cause for one exception can be related to another exception in exception chaining
*/

package exception;

import java.sql.SQLException;

public class ExceptionChaining {
    public static void main(String[] args) {
        try {
            throw new ArithmeticException("divide by zero").initCause(new SQLException("Couldn't fetch data"));
        } catch (Throwable e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }
}
