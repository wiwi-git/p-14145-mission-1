package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void main() {
        System.out.println("== 명언 앱 ==");

        Scanner sc = new Scanner(System.in);

        List<WiseSaying> forms = new ArrayList<>();
        int lastId = 0;

        while(true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();
            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = sc.nextLine();

                System.out.print("작가 : ");
                String auth = sc.nextLine();
                int id = lastId + 1;
                WiseSaying newForm = new WiseSaying(id);
                newForm.setText(content);
                newForm.setAuth(auth);
                forms.add(newForm);

                lastId = id;

                System.out.println(id + "번 명언이 등록되었습니다.");
            }
        }

    }
}
