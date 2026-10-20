package org.example;

import java.util.*;

import static java.util.Collections.reverse;

public class Main {
    static void main() {
        System.out.println("== 명언 앱 ==");

        Scanner sc = new Scanner(System.in);

        List<WiseSaying> forms = new ArrayList<>();

        int lastId = 0;


        while(true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            Rq rq = new Rq(cmd);
            String actionName = rq.getActionName();

            if (actionName.equals("종료")) {
                break;
            } else if (actionName.equals("등록")) {
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
            } else if (actionName.equals("목록")) {
                System.out.println("""
                        번호 / 작가 / 명언
                        ----------------------""");

                for (WiseSaying w: forms.reversed()) {
                    System.out.println(w.toString());
                }
            } else if (actionName.equals("삭제")) {
                int id = rq.getParamAsInt("id", -1);
                Optional<WiseSaying> find = forms.stream().filter(t -> t.id == id).findFirst();

                if (find.isPresent()) {
                    forms.remove(find.get());
                    System.out.println(id + "번 명언이 삭제되었습니다.");
                } else {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                }
            } else if (actionName.equals("수정")) {
                int id = rq.getParamAsInt("id", -1);

                Optional<WiseSaying> find = forms.stream().filter(t -> t.id == id).findFirst();
                if (find.isEmpty()) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                    continue;
                }

                WiseSaying form = find.get();
                WiseSaying newForm = new WiseSaying(form.id);

                System.out.println("명언(기존) : " + form.getText());
                System.out.print("명언 : ");
                newForm.setText(sc.nextLine().trim());

                System.out.println("작가(기존) : " + form.getAuth());
                System.out.print("작가 : ");
                newForm.setAuth(sc.nextLine().trim());

                int index = forms.indexOf(form);
                forms.remove(form);
                forms.add(index, newForm);
            }

        }//while

    }
}
