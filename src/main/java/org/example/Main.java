package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void main() {
        System.out.println("== 명언 앱 ==");

        Scanner sc = new Scanner(System.in);

        List<WiseSaying> forms = new ArrayList<>();

        while(true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();
            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = sc.nextLine();

                System.out.println("작가");
                String auth = sc.nextLine();

                WiseSaying newForm = new WiseSaying();
                newForm.setText(content);
                newForm.setAuth(auth);
                forms.add(newForm);
            }
        }

    }
}
