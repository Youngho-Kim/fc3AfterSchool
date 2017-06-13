# TDD

1. 무엇을 테스트 해야하는지 생각한다.  
    시나리오(이야기)를 생각해 내라.
2. 테스트를 먼저 작성한다.  
    이 테스트는 실패하거나 심지어 컴파일이 안될 수도 있다.
3. 빠르게 테스트가 성공하기 위한 조건을 충족한다  
    좋은 코드를 의미하는 것이 아니다.  
    빠르게 적용할 수 있는 것은 바로 구현하고 그렇지 않은 대상은 할 일에 추가하며 스텁을 넣는다
4. 할 일 리스트를 하나하나 지워가며 작업한다. 새로 생긴 할 일은 계속 추가한다.
5. 중복을 제거해나간다.
6. 리팩토링   
    이를 통해 의존성을 감소해 효율성을 증진시킬 수 있다.


작성(1,2) --> 실행(3) --> 올바르게(4,5,6) 


##Junit
테스트에 매개변수, 반환 값을 지정할 수 없다.
### @
@Test : 수행하는 테스트에 붙는 어노테이션  
    
    변수로 timeout과 expect를 줄수 있음   
    timeout = 3000 // 3000밀리 세컨즈 내에 테스트가 완료되지 않으면 실패로 간주
    expect = NullpointerException.class // 해당 예외가 발생하지 않으면 실패로 간주
    
@Before : 테스트 수행 전 1회 실행 되는 메소드  
@After : 테스트 수행 후 1회 실행 되는 메소드  

    @Test가 여럿이면 @Before, After도 여러번 수행된다.  
    
    
@BeforeClass : 테스트 클래스 실행시 1회에 한해서 실행
@AfterClass : 테스트 클래스 완전 종료시 1회에 한해서 실행

@RunWith(Parameterized.class) : 다양한 케이스 데이터를 이용해 여러 케이스를 테스트 하는 클래스  
@Parameterized.Parameters : 케이스 데이터를 가지고 있는 컬렉션을 반환하는 스테틱 메소드  

    @RunWith(Parameterized.class)
    public class TestManyCases{
        @Parameters
        public static Collection data(){
            return Arrays.asList(new Object[][]{
            ...2차원 배열
            }); 
        }
        ...
        //케이스 데이터를 받는 생성자가 필요, 테스트 케이스 당 인스턴스가 하나씩 생성되는 것을 잊으면 안됨
        public TestManyCases(Object var1, object var2...){
        }
    }

## assert  
org.junit.Assert에 static으로 정의되어 있는 메소드들 => import satic으로 들여와야한다.  
assert...(기대값, 비교값) 형태로 작성한다.  
assertThat은 hamcrest의 Match클래스를 사용한다.

##Suite  
여러개의 테스트를 모아서 한 번에 테스트, 여러 suite를 모아 하나의 suite를 구성할 수 있음
