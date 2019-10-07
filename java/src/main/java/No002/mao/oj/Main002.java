
package No002.mao.oj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main002 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            nums.add(scanner.nextInt());
        }
        scanner.close();

        // Map<Integer, Integer> result = new HashMap<Integer, Integer>();
        int size = nums.size();
        List<Integer> result = new ArrayList<Integer>();
        int n;
        for (int i = 0; i < size; i++) {
            n = nums.get(i);
            if ((n <= 3) || (n > 100000001)) {
                result.add(0);
                continue;
            }

            int k = 3;
            int primeNumberCount = 0;
            while (k <= (n - 2)) {
                if ((k % 2) == 0) {
                    k++;
                    continue;
                }
                // k计算过了，则从缓存取
                // if (cache.containsKey(k)) {
                // kIsPrimeNumber = cache.get(k) == PRIME_NUMBER;
                // } else {
                // kIsPrimeNumber = isPrime(k);
                // cache.put(k, kIsPrimeNumber ? PRIME_NUMBER : NOT_PRIME_NUMBER);
                // }
                //
                // k2IsPrimeNumber = isPrime(k + 2);
                // cache.put(k + 2, k2IsPrimeNumber ? PRIME_NUMBER : NOT_PRIME_NUMBER);

                if (isPrime(k) && isPrime(k + 2)) {
                    primeNumberCount++;
                }
                k++;
            }
            result.add(primeNumberCount);
        }

        result.stream().forEach(System.out::println);
    }

    public static boolean isPrime(int num) {
        if (num <= 3) {
            return num > 1;
        }
        // 不在6的倍数两侧的一定不是质数
        if (((num % 6) != 1) && ((num % 6) != 5)) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrt; i += 6) {
            if (((num % i) == 0) || ((num % (i + 2)) == 0)) {
                return false;
            }
        }
        return true;
    }

}