package may_12_rock_scissor_paper;

import java.util.Scanner;

/**
 * Created by DoDo on 2017-05-12.
 */
public class User extends Player {
//User는 Player를 상속하고 showPick()메소드를 오버라이딩합니다.
    public Pick showPick(){
        //콘솔을 통한 사용자 입력을 받을 준비를 합니다.
        Scanner scanner = new Scanner(System.in);
        //사용자 입력을 매개변수로 새로운 Pick을 만들어 pick에 대입합니다.
        String strPick = scanner.nextLine();
        pick = new Pick(strPick);
        //pick을 반환합니다.
        return pick;
    }
}
