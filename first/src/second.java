import java.util.Scanner;

public class second {



    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int temp = sc.nextInt();
        temp  = ((temp- 32)*5)/9;
        System.out.println(temp);
    }
}
