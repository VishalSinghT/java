import java.util.*;

class TestClass {
    public static void main(String args[] )  {

        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        for(int i=1;i<=s;i++){
          //  int x= sc.nextInt();
            int y= sc.nextInt();
            for(int j=1;j<=y;j++){
                if(j%3==0&& j%5==0){
                    System.out.println("FizzBuzz");
                }
                else if(j%3==0){
                    System.out.println("Fizz");
                }
                else if(j%5==0){
                    System.out.println("Buzz");}
                else{
                    System.out.println(j);
                }
            }
        }
    }
}
