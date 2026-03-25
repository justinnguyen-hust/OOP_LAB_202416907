import java.util.Scanner;
public class DisplayTriangle{
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Nhap n: ");
        int number = keyboard.nextInt();

        for(int i = 1; i <= number; i++){
            for(int j = number-i; j > 0; j--){
                System.out.print(" ");
            }
            for(int k = 1; k <= 2*i - 1; k++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}