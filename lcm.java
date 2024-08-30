import java.util.Scanner;
public class lcm {
   //using gcd
   /* public static int nlcm(int a, int b){
        int lcm = a * b / gcd(a, b);
        return lcm;
        }
        public static int gcd(int a, int b){
            if (b == 0)
            return a;
            return gcd(b, a % b);
        }*/
        public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int a=sc.nextInt();
            int b=sc.nextInt();
            System.out.println("lcm of "+a+" and "+b+" is "+nlcm(a,b));
            sc.close();
        }
//only lcm method without using gcd and hcf function
public static int nlcm(int a, int b){
    int lcm = a * b;
    for(int i=1;i<=a*b;i++){
        if(i%a==0 && i%b==0){
            lcm = i;
            break;
            }
            }
            return lcm;
        }
    }
