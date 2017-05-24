## 의사 코드(Sudo Code)
- 알고리즘 기술 언어로 실제 실행되는 코드는 아니지만, 더 간결한 표현으로 쉽게 알고리즘의 논리 흐름을 표현할 수 있다.
- 특정 언어의 문법에 귀속되지 않고 이해를 목적으로 한다.
- 다양한 파스칼 스타일, 포트란 스타일, C 스타일 등 다양한 스타일이 있다.
<br/>

### 대입 문
- 변수에 값을 대입한다.
+ **변수 <- 값;**

(Java : int a = 0; b = 1;)
변수에 값을 대입함을 의미하는 코드이다.
```Sudo
  vari <- 3;
```
<br/>

### 기본 연산자
- 기본 수학 연산자는 C 또는 자바와 동일합니다.
- **a = b;**
(Java : a == b;)
예외적으로 같음을 의미하는 동등비교의 연산은 = 입니다.  
<br/>

### 조건문
#### if문
- 조건에 따라 특정 과정, 연산을 실행한다.
+ **if(조건식) then 실행문1;**
(Java :  if(조건식){실행문 1})
* **else if(조건식) then 실행문2;**
(Java : else if(조건식){실행문 2}
- **else 실행문3;**
(Java : else{실행문})
```Sudo
if(vari = 3) then print "vari is 3";
    else if(vari > 3) then print "vari is bigger than 3";
      else print "vari is smaller than 3";
```
#### case문  
- 여러 조건들 중 해당 조건에 일치하는 경우에 정해진 과정, 연산을 실행한다.
+ **case { 비교값 = 조건1: 실행1; 비교값 = 조건2: 실행2;...}**
(Java: switch(비교값){ case 조건1: 실행1; break; case 조건2: 실행2; break;....})
```Sudo
case{
  vari = 3: print "vari is 3";
  vari > 3: print "vari is bigger than 3";
  vari < 3: print "vari is smaller than 3";
}
```
<br/>

### 반복문
일정한 과정과 연산을 조건에 따라 반복 수행하는 루프입니다.
#### for문
- **for(초기식; 조건식; 증감식) do 실행문;**
(Java: for(초기식; 조건식; 증감식 ){실행문})
+ for문 시작에 1회에 한해 초기식을 실행한다.
+ 조건식의 참 거짓을 판단해, 참일 경우 실행문을 실행합니다.
+ 실행문을 1회 수행하면 증감식을 실행합니다.
+ 증감식 실행 후 조건식을 재판단하고, 참일 경우 실행문을 반복 실행합니다.

```Sudo
for(i<-0; i < 10; i++) do{
  print i +" is smaller than 10";
}
```
#### while-do
- **while(조건식) do 실행문;**
(Java: while(조건식){})
+ 조건식의 참 거짓을 판단해, 참 일 경우 실행문을 실행합니다.
+ 실행문을 1회 수행하면 조건식을 재판단합니다.
+ 참일 경우 반복 실행합니다.
```Sudo
while(i<10) do print "i is slammer than 10";
```

#### do-while
- **do 명령문; while(조건식);**
(Java do{}while(조건식))
+ 먼저 1회 명령문을 실행한다
+ 조건식의 참거짓을 판단해 반복한다.
```Sudo
do print "i may smaller than 10";
  while(i<10);
```

### 함수문
작업별로 모듈화를 하는 부속 프로그램

* **함수이름(매개변수) 명령문; return 결과값; end**
 (Java void 함수이름(매개변수) { 명령문; return 결과값;}))
 - 기본적으로 자바의 함수와 동작 원리는 동일하다.
 - end를 통해 함수의 끝을 표시한다.

```Sudo
SampleFunction(parameter)
  print parameter;
  return parameter+1;
end
```
