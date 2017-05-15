package may_12_rock_scissor_paper;

import java.util.Scanner;

/**
 * Created by DoDo on 2017-05-12.
 */
public class Pick {
//게임에 사용될 기본 상수들을 정의합니다.
    public static final int DRAW  = 0;
    public static final int USER_WIN = 1;
    public static final int COMP_WIN = 2;
    public static final String ROCK ="바위";
    public static final String SCISSOR ="가위";
    public static final String PAPER ="보";

//Pick의 이름과 값을 저장할 전역 변수를 선언합니다.
    String label;
    int value;

//생성자를 통해 적절한 Pick객체를 (인스턴스)를 만듭니다.
    public Pick(String label) {
        this.label = label;
        calValue(label);
    }
// label에 맞는 value를 갖도록하는 메소드입니다.
    private void calValue(String label){
        switch (label){
            case "가위":
                value = 1;
                break;
            case "바위":
                value = 0;
                break;
            case "보":
                value =2;
                break;
            default:
                //가위도 바위도 보도 아닌 값이 입력될 경우 default가 반응하게됩니다.
                System.out.println("잘못된 선택입니다.");
                Scanner scanner = new Scanner(System.in);
                //메소드 자기자신을 호출(재귀)하여 새로 얻게된 값에 맞는 value가 저장되도록합니다.
                calValue(scanner.nextLine());
        }
    }


    //static 메소드로 두 Pick을 비교하여 게임의 결과를 반환합니다.
    public static int battle(Pick userPick, Pick compPick){
        //비교는 각 Pick의 value를 빼 그 차이를 이용합니다.
        int temp = userPick.value -  compPick.value;
        if(temp == -1 || temp == 2){
            //위에 미리 정의된 상수를 사용해 무엇을 의미하는 지 더 명확히 할 수 있습니다.
            return USER_WIN;
        }else if(temp == 1 || temp == -2){
            return COMP_WIN;
        }else{
            return DRAW;
        }
    }
}
