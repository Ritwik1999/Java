package classexercises.aprilextwosix;

public class CatTwoQuestionOne {
    public static void main(String[] args) {
        try {
            if (true) {
                throw new satishexception("I am userdefined exception");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class satishexception extends Exception {
    satishexception(String S) {
        super(S);
    }
}