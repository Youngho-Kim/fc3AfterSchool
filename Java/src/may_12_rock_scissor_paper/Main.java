package may_12_rock_scissor_paper;

/**
 * Created by DoDo on 2017-05-12.
 */
public class Main {


    public static void main(String[] args){
        //Player클래스를 상속한 User와 Computer 클래스의 객체를 만듭니다.
        User user = new User();
        Computer computer = new Computer();

        // Player클래스에서 상속받고 각각의 클래스에서 오버라이딩한 showPick()메소드를 통해 Pick 객체를 만듭니다.
        Pick userPick = user.showPick();
        Pick compPick = computer.showPick();

        //Pick의 static 메서드인 battle을 통해 두 Pick 객체를 비교해 결과값을 받습니다.
        int result = Pick.battle(userPick,compPick);

        //결과값에따라 적절한 문자열을 화면에 출력합니다.
        switch (result){
            //각각의 case는 result와 비교값이 같은 경우를 의미합니다.
            case Pick.DRAW :
                System.out.print("비김");
                //break를 통해 case 구분을 합니다.
                break;
            case Pick.USER_WIN :
                System.out.print("이김");
                break;
            case Pick.COMP_WIN :
                System.out.print("짐");
                break;
        }
    }
}
