
package No025.mao.oj;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
        }
        scanner.close();
        int n = input.length();
        if ((n == 0) || (n >= 50)) {
            System.out.println(0);
        }
        int max = count(input.substring(0, 1), input.substring(1, input.length()));
        System.out.println(max);
    }

    /**
     * @param substring
     * @param charAt
     */
    private static int count(String current, String left) {
        if (left.length() == 0) {
            return 0;
        }
        String next = left.substring(0, 1);
        String pre = current.substring(current.length() - 1, current.length());
        // stop here
        if (left.length() == 1) {
            if ((pre.equals("G")) && (next.equals("R"))) {
                return 1;
            } else {
                return 0;
            }
        }

        // not (pre is G and next is R), try next
        if (!((next.equals("R")) && (pre.equals("G")))) {
            return count(current + next, left.substring(1, left.length()));
        }

        if (current.length() > 1) {
            // change next to G
            int changeR2G = 1 + count(current + "G", left.substring(1, left.length()));

            // change pre to R
            int changePre2R = 1 + back(current.substring(0, current.length() - 1))
                + count(current + next, left.substring(1, left.length()));
            return Math.min(changeR2G, changePre2R);

        } else {
            return 1 + count(current + "G", left.substring(1, left.length()));
        }

    }

    private static int back(String left) {
        if (left.length() == 1) {
            if (left.endsWith("G")) {
                return 1;
            } else {
                return 0;
            }
        }

        if (left.endsWith("G")) {
            return 1 + back(left.substring(0, left.length() - 1));
        } else {
            return 0;
        }
    }

}
