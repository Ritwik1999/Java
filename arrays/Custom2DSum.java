package arrays;

public class Custom2DSum {
    public static void main(String[] args) {
        
        int array[][] = {{1, 2, 3, 4}, {1, 2, 3}, {1, 2}, {1}};

        System.out.print("The sum of all elements is: ");

        int sum = 0;

        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                sum += array[i][j];
            }
        }

        System.out.println(sum);
    }
}
