package org.example;

import java.util.Scanner;

public class Main {
    static void main() {
        System.out.println("== 명언 앱 ==");

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();
            if (cmd.equals("종료")) {
                break;
            }
        }

    }
}
