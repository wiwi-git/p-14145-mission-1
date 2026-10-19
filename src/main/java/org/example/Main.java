package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    static void main() {
        System.out.println("== 명언 앱 ==");

        Scanner sc = new Scanner(System.in);

        List<WiseSaying> forms = new ArrayList<>();

        int lastId = 0;


        while(true) {
            System.out.print("명령) ");
//            String cmd = sc.nextLine().trim();
            ParseCmd cmd =  new ParseCmd(sc.nextLine().trim());

            if (cmd.getCommand() == Command.EXIT) {
                break;
            } else if (cmd.getCommand() == Command.REGISTER) {
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
            } else if (cmd.getCommand() == Command.LIST) {
                System.out.println("""
                        번호 / 작가 / 명언
                        ----------------------""");
                for (WiseSaying w: forms.reversed()) {
                    System.out.println(w.toString());
                }
            } else if (cmd.getCommand() == Command.DELETE) {
                int id = Integer.parseInt(cmd.getParam("id"));
                Optional<WiseSaying> find = forms.stream().filter(t -> t.id == id).findFirst();

                if (find.isPresent()) {
                    forms.remove(find.get());
                    System.out.println(id + "번 명언이 삭제되었습니다.");
                }
            }
        }//while

    }
}
