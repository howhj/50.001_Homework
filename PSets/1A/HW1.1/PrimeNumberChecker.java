package HW11.lib;

public class PrimeNumberChecker{
    public static void main(String[] args) {
        System.out.println(isPrime(4));
        System.out.println(isPrime(7));
        System.out.println(isPrime(14));
        System.out.println(isPrime(23));
        System.out.println(isPrime(99));
    }

    public static int isPrime(int num){
        if (num%2 == 0) {
            return 0;
        }
        else if (num == 5) {
            return 1;
        }
        else if (num%5 == 0) {
            return 0;
        }
        else {
            for (int i=3; i<num; i+=2) {
                //System.out.println("i="+ i);
                if (num%i == 0) {
                    return 0;
                }
            }
            return 1;
        }
    }
}

