# DIL (During I Learned)?

>Java Course
>
>(19. 12. 02 ~ 19. 12. 13)



---

## [Java](./java)



# Week 1.

---

## 1. install Java & IDE(Eclipse)

> Java는 Oracle 사이트에서 버전별로 설치가 가능하다
>
> IDE로는 Eclipse를 사용하기로 한다.

* set path

```
JAVA_HOME
C:\Program Files\Java\jdk1.8.0_231
```

```
Path
%JAVA_HOME%\bin
```

```
classpath
./
```




* Test install

```java
System.out.println("Hello Java?"");
```



---

## 2. Variable

> 변수는 데이터가 저장되는 공간이다.

### 1. Primitive type
* boolean, char
* byte, sort, int long
* float, double



### 2. Referance type
* String, etc

```java
int i = (int) .1f;			// int type
System.out.println(i);

float f = (float) 5.5;		// float type
System.out.println(f);

double d = 5;				// double type
System.out.println(d);

boolean flag;				// boolean type
flag = 5>10;
System.out.println(flag);

String s = "aaaaaa";		// String type
System.out.println(s);
```



### 3. Type Casting

> 서로 다른 자료형에 대하여 형변환을 이용하여 저장 또는 사용

```java
// ex) String to Integer
int str = Integer.parseInt("100") + 1;
```



---

## 3. Operator

### 1. 연산자의 종류

  * 산술 연산자

    '	+	-	*	/	%	<<	>>	'

  * 비교 연산자

    '	>	<	>=	<=	==	!=	'

  * 논리 연산자

    '	&&	||	!	&	|	^	~	'

  * 대입 연산자

    '	=	'

  * 기타

    '	( type )  ?	:	' 
    
    '	instanceof	'


```java
System.out.println(1>4 & 4<0);	// false		// & : 논리연산자
System.out.println(1&4);		// 0			// & : 비트연산자
// ...
```



### 2. Compare values

```java
String s1 = new String("java"); 
String s2 = new String("java");
// s1, s2		== & equals()
System.out.printf("s1 = %s, s2 = %s\n", s1, s2);
System.out.printf("s1 == s2 : %b\n",s1==s2);				// false	// ==
System.out.printf("s1.equals(s2) : %b\n\n",s1.equals(s2));	// true		// equals()
```



---

## 4. Scanner & FileInputStream

> 수업 진행에 있어 도움이 될 것을 미리 배워 사용

### 1. Scanner

```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);
name = sc.nextLine();
System.out.printf(name);

korScore = Integer.parseInt(sc.nextLine());
sc.hasNextLine();		// nextInt()로 int 받은 후 enter값이 남는것을 지우는 역할
System.out.printf("%d : %s\n", korScore
				(korScore >= 0 && korScore <=100) ? 
						((korScore >= 80) ? "합격이다" : "불합격이다") : "이상하다" );

sc.close();				// 사용 후 반납
sc = null;
```



### 2. FileInputStream

```java
import java.io.FileInputStream;
import java.util.Scanner;

Scanner sc = new Scanner( new FileInputStream("C://workspace/lib/score.txt") );

String studentName;
int kor, eng, math;

studentName = sc2.next();
kor = sc2.nextInt();
eng = sc2.nextInt();
math = sc2.nextInt();
sc2.nextLine();

if ( sc2 != null ) sc.close();
sc = null;
```



---

## 5. 조건문과 반복문

### 1. if문

```java
if ( 조건 ) {
    // code
} else if ( 조건 ) {
    // code
} else {
    // code
}
```



### 2. for문

```java
// for문
int sum = 0;
for ( int i=1 ; i<=10 ; i++ ) {
	if (i%2 == 0 ) {
		System.out.printf(" %d", i);
		sum += i;
	}			
}
```



### 3. while문

```java
// while문
int i = 0;
while ( i<10 ) {
	System.out.println(i++);
}
```



### 4. switch문

```java
// switch문
int num;
switch ( num )	{		// get int or char, String
    case 1 :
    case 2 :
        break;
    default :
        break;
}
```



### 5. break, continue 문

```java
for ( int i=1 ; i<10 ; i++ ) {
	for ( int j=2 ; j<10 ; j++ ) {
//      if(j==5) break;				// 5단부터 제외
		if(j==5) continue;			// 5단만 제외
		System.out.printf(" %d x %d = %2d |", j, i, j*i );
	}
	System.out.println();
}
		
// break point 'A'
A: for ( int i=1 ; i<10 ; i++ ) {
	for ( int j=2 ; j<10 ; j++ ) {
		if(j==5) break A;			// labeling : break point 'A'
		System.out.printf(" %d x %d = %2d |", j, i, j*i );
	}
	System.out.println();
}
```



---

## 6. Array

### 1. 배열

> 같은 타입의 변수를 하나의 묶음으로 다루는 것

```java
int[] eng;				// 배열 선언	- Stack area
eng = new int[5];		// 배열 생성	- Heap area (feat. new)
// ...
for ( int i=0 ; i<eng.length ; i++ ) {
	System.out.printf("%d ", eng[i]);
	sum += eng[i];
}
```



* 배열의 복사

```java
int[] temp = new int[num.length*2];
System.arraycopy(eng, 0, temp, 0, eng.length);	// System.arraycopy
```



### 2. String 배열

```java
String[] names = new String[5];
// ...
for (int i = 0; i < names.length; i++) {
	if ( names[i] != null  && names[i].length() > 0 ) {
		System.out.print(names[i].charAt(0));
		System.out.printf(" : %d\n", eng[i]);
	}						
}
```



#### ect 1. 배열을 사용한 for문의 다른 형태

```java
int[] num = { 1, 2, 3 };
for (int data :num) {
	if(data %2 != 0) {
		System.out.print(data);		// System.out.print(data + ' ')
		System.out.print(' ');		// ㄴ print int
	}
}
```



#### ect 2. 배열을 이용한 중복체크

```java
// duplication check
for (int i = 0; i < num.length; i++) {
	num[i] = (int)(Math.random()*45+1);
	for (int j = 0; j < i; j++) {
		if ( num[j] == num[i] ) {
			i--;		// 중복된 값일 경우, index i의 값을 -1, +1(break -> for i++)
			break;		// 하여 동일한 index i에 새로운 random() 숫자를 받아 다시 체크한다.
		}
	}
}
```



---

## 7. 객체지향 프로그래밍

### 1. 클래스와 객체

> `클래스`란 객체를 정의해 놓은 것으로 객체를 생성하는데 사용
>
> `객체`란 실제로 존재하는 것



### 2. 변수와 메서드

#### 객체의 구성요소

> 객체는 속성(data, variable)와 기능(method, function)으로 이루어져있다.



```java
class Employee {			// class
	String name;			// 속성(variable)
	String dept;
	int age;
	
	public void print() {	// 기능 (method)
		System.out.printf(
				"[ %10s | %10s | %3d ]\n", this.name, this.dept, this.age);
	}
}
```



#### 인스턴스의 생성과 사용

````java
// 생성
Employee emp1 = new Employee();
// 변수 사용
emp1.name = "Mr. Hong";
emp1.dept = "Tech.";
emp1.age = 32;
// 메서드 사용
emp1.print();
````



#### static 함수의 사용

```java
public class Calc {
    public static int add ( int a, int b ) {
		return a+b;
	}
}
```

```java
// in main
// no static
Calc calc = new Calc();
System.out.println(calc.add(99, 44));

// static
System.out.println(Calc.add(99, 44));		// 객체 선언 없이 클래스 명으로 메서드 호출
```



---

# Week 2.

---

## 7. 객체지향 프로그래밍

### 3. 생성자

#### 1. 생성자란?

> 생성자란 인스턴스가 생성될 때 호출되는 '인스턴스 초기화 메서드'이다.



* 생성자의 조건
  * 생성자의 이름은 클래스의 이름과 같아야 한다.
  * 생성자는 리턴 값이 없다.

```java
class Time {
    Time () {	// 생성자
	}
}
```



#### 2. 매개변수가 있는 생성자

```java
// Time
	Time ( int hour, int minute ) {
		this.hour = hour;
		this.minute = minute;
	}
```



