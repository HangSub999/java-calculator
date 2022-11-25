package view;

import java.util.Scanner;

public class Input {

    public static Scanner scanner = new Scanner(System.in);

    public static String InputUser() {
        System.out.println("계산할 숫자와 부호를 입력해 주세요.");
        return scanner.nextLine();
    }
}
