# Thread

### run(), start()
* run() : 단순한 메소드 실행
* thread stack 생성 후 해당 stack에서 run()실행

### User Thread(Non-daemon-thread), Daemon Thread
* Daemon : 보조, 사용자 쓰레드 종료시 강제 종료
* 생성은 동일, 시작 전에 setDaemon(true);


### Thread의 불확실성
1. 스케쥴러의 불확실성
2. 우선순위의 불확실성

### Thread Group
1. Thread 묶음
2. 명시하지 않으면 생성한 Thread에 포함된다

### Thread Scheduling
1. sleep; 일정시간 일시정지, 후 실행대기상태, static 현재 실행중인 쓰레드에게 영향
2. join; 일정시간 실행하기, 후 원래 쓰레드로 복귀
    ```Java
        public static void main(String args[]){
            //작업
            th1.join();
        }
    ```
    => main 쓰레드 동작 중 th1 이 조인한다.
    => main 쓰레드가 멈추기 전에 th1이 조인하기에 (명시적으로 작업 시간이 설정되어 있지 않다) th1이 끝날 때 까지 메인 쓰레드가 일시 정지한다
    => th1이 끝나고 main복귀 -> 종료
3. interrupt 일시 정지된 쓰레드를 깨워 대기 상태화, 현재 쓰레드를 멈추라, 실제로는 변수 플래그 변경 정도만
    interrupted(); interrupt 여부 반환, false로 초기화
    isinterrupted(); interrupt 여부 반환, 초기화 x
    -> interruptedException발생, 기존 sleep, wait join을 깨운다,
    interrupted는 '현재상태'에 대한 방해이다.
4. yield자신에게 주어진 실행 시간을 다른 쓰레드에게 양보, 후 실행 대기 상태화
    명시적인 전환
    busy-waiting 상태 (아무 의미없이 돌고 있는 상태)에 대한 적절한 해결법이 될 수 있다.
### 상태
1. New
2. Runnable
3. Blocked
4. Waiting, Time_wating
5. terminated