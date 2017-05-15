## Day 1 (2017/05/13/fri)
##### 가위 바위 보 게임

- 가위, 바위, 보의 객체를 갖게될 Pick이라는 클래스를 만듭니다.
- 사용자와 컴퓨터 클래스가 상속할 Player라는 클래스를 만듭니다.
- Player는 Pick을 반환하는 메소드인 showPick()이라는 메소드를 갖습니다.
- 사용자와 컴퓨터 클래스는 Player클래스의 showPick()메소드를 오버라이드합니다.

- 사용자 입력에 따른 (scanner.nextLine()) 패를 만듭니다. 생성자(Constructor)사용을 권합니다.
- 컴퓨터 입력에 따른 (Math.random()) 패를 만듭니다. 생성자(Constructor)사용을 권합니다.
- Pick에 사용자와 컴퓨터의 패를 비교해 승패를 결정하는 static 메소드(battle())을 만듭니다.

- Pick에 static 상수로 패의 값과, 패의 레이블, 승 패 여부값을 저장해둡니다.
