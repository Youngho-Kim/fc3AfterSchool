package may_12_rock_scissor_paper;

/**
 * Created by DoDo on 2017-05-12.
 */
public class Computer extends Player {

//Computer는 Player를 상속하고 showPick()메소드를 오버라이딩합니다.
    public Pick showPick() {
        //Math.random(), 0이상 1미만의 무작위 수를 반환하는 메소드,를 통해 무작위 수를 얻고
        // 그에 3을 곱하고 int로 강제 변환해 0,1,2의 무작위 값을 얻습니다.
        int numbPick = (int)(Math.random()*3);

        //얻은 무작위 수에 맞는 Pick을 만들어 반환합니다.
        if(numbPick == 0){
            pick = new Pick(Pick.ROCK);
            System.out.printf("Com: %s %n",Pick.ROCK);
        }else if(numbPick == 1){
            pick = new Pick(Pick.SCISSOR);
            System.out.printf("Com: %s %n",Pick.SCISSOR);
        }else if(numbPick == 2){
            pick = new Pick(Pick.PAPER);
            System.out.printf("Com: %s %n",Pick.PAPER);
        }

        return pick;
    }
}
