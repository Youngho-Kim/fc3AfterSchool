package may_12_rock_scissor_paper;

/**
 * Created by DoDo on 2017-05-12.
 */

//Player는 자신의 패에 해당하는 pick과 해당 Pick을 반환하는 showPick()메소드를 갖고 있습니다.
public class Player {
    protected Pick pick;
    public Pick showPick(){
        return pick;
    }
}
