import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        System.out.println("1 to quit");
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            if(num == 1) break;
            executor.submit(new PrimeLogger(num));
        }
        executor.shutdown();
    }
}

class PrimeLogger implements Runnable {
    private final int num;

    public PrimeLogger(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        // print num if it is prime
        boolean isPrime = true;
        for(int i = 2; i + i <= this.num; i ++){
            if(this.num% i == 0){
                isPrime = false;
                break;
            }
        }
        if(isPrime) System.out.println(this.num);
    }
}