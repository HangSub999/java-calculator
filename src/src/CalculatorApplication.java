import controller.CalculatorManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> marks = makeMarkFactory(input);
        List<Long> numbers = makeNumberFactory(input, marks);
        long sum = makeFirstNumber(input);
        System.out.println(makeCalculationNumber(sum, marks, numbers));
    }

    public static long makeCalculationNumber(long sum, List<String> marks, List<Long> numbers) {
        long tmp = sum;
        for (int i = 0; i < marks.size(); i++) {
            if (marks.get(i).equals("+")) {
                tmp += numbers.get(i + 1);
            }
            if (marks.get(i).equals("-")) {
                tmp -= numbers.get(i + 1);
            }
            if (marks.get(i).equals("*")) {
                tmp *= numbers.get(i + 1);
            }
            if (marks.get(i).equals("/")) {
                tmp /= numbers.get(i + 1);
            }
        }
        return tmp;
    }

    public static Long makeFirstNumber(String input) {
        return Long.parseLong(String.valueOf(input.charAt(0)));
    }

    public static List<Long> makeNumberFactory(String input, List<String> marks) {
        List<Long> numbers = new ArrayList<>();
        String[] tmp = input.split("");
        for (String s : tmp) {
            if (!marks.contains(s)) {
                numbers.add(Long.parseLong(s));
            }
        }
        return numbers;
    }

    public static List<String> makeMarkFactory(String input) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+') {
                list.add("+");
            }
            if (input.charAt(i) == '-') {
                list.add("-");
            }
            if (input.charAt(i) == '*') {
                list.add("*");
            }
            if (input.charAt(i) == '/') {
                list.add("/");
            }
        }
        return list;
    }

}
