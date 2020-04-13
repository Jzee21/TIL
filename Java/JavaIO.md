# Java I/O

## I/O

> 데이터를 외부에서 읽거나, 외부로 출력하는 작업



## Stream

>  data를 받아들이거나 보내는 통로로서
>
> Java의 입출력은 Stream을 이용한다.



Stream은 기본적으로

1. InputStream
2. OutputStream

이 있다.



```java
System.out 	: public final static PrintStream out = null;
System.out.println("Hello world!");
```

- Java에서 기본적으로 제공하는 객체, 메서드
- Java 프로그램에서 Java 표준 출력(Dos)로 데이터를 전달하는 Stream 객체





## 개선된 Stream

> 기본적은 Stream 객체(InputStream, OutputStream)는 성능이 상당히 좋지 않다.
>
> 이를 위해 기존의 Stream 객체를 이용하여 개선된 또 다른 Stream을 만들어 사용한다.

```java
InputStreamReader isr = new InputStreamReader(System.in);
BufferedReader br = new BufferedReader(isr);
```





## InputStream

> 데이터를 받기 위해서는 기본적으로 InputStream 객체가 필요하다.
>
> InputStream 객체는 숫자를 받아들이기에는 좋을 수 있지만
>
> 문자열을 읽어들이기에는 효율이 좋지 않다.(매우)

```java
InputStreamReader isr = new InputStreamReader(System.in);
BufferedReader br = new BufferedReader(isr);
```

- `InputStreamReader`  : 기본적인 InputStream을 이용하여 만든 개선된 Stream

  문자열을 받아들이기에는 InputStream 객체보다 좋지만, 한 번에 하나의 문자열만

  받을 수 있다

- `BufferedReader`  :  `readLine()` method를 이용하여 줄 단위로 문자열을 받는 기능을 제공한다



## FileReader

```java
FileChooser fileChooser = new FileChooser();
fileChooser.setTitle("Open File");
File file = fileChooser.showOpenDialog(primaryStage);	// JavaFX

try {
    FileReader fr = new FileReader(file);	// FileNotFoundException
    BufferedReader br = new BufferedReader(fr);
    
    String line = "";
    while((line = br.readLine()) != null) {	// IOException
        //...
    }
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e2) {
	e2.printStackTrace();
}
```





## BufferedReader

대표적인 입력 Stream

단순 문자열을 처리할 때는 BufferedReader를 사용하면 된다.

단, HashMap과 같은 자료구조 데이터를 저장할 때는 효과적이지 않다.



## PrintWriter

대표적인 출력 Strem



## ObjectStream





---

# Java I/O

## Java 입출력

### 입출력

> 프로그램이 컴퓨터 내부 또는 외부의 장치와 데이터를 주고받는 것



### Stream

> Java에서 입출력을 수행하기 위해서는 두 대상을 연결하고 데이터를 전송할 수 있는 무언가가 필요하며, 이것을 스트림(Stream)이라 한다.
>
> 스트림이란 데이터를 운반하는데 사용되는 연결통로로서
>
> 단방향 통신만 가능하다.



### 바이트기반 Stream

> 바이트단위로 데이터를 입출력하는 스트림

- File  :  FileInputStream, FileOutputStream
- ByteArray  :  ByteArrayInputStream, ByteArrayOutputStream
- Piped  :  PipedInputStream, PipedOutputStream
- Audio  :  AudioInputStream, AudioOutputStream



### 보조스트림

> 스트림의 기능을 보완하기 위한 보조스트림
>
> 스스로 데이터를 입출력 하는 기능은 없지만, 스트림의 기능을 향상시키거나 새로운 기능을 추가한다.

- Filter  :  FilterInputStream, FilterOutputStream
- Buffered  :  BufferedInputStream, BufferedOutputStream
- Data  :  DataInputStream, DataOutputStream
- SequenceInputStream
- LineNumberInputStream
- Object  :  ObjectInputStream, ObjectOutputStream
- PrintStream
- PushbackInputStream



### 문자기반 스트림

> 바이트기반 스트림은 1byte 단위로 처리하기 때문에 숫자를 제외한 문자의 처리에는 어려움이 있다.

InputStream  >>  Reader

OutputStream  >>  Writer



- FileReader, FileWriter
- CharArrayReader, CharArrayWriter
- PipedReader, PipedWriter
- StringReader, StringWriter



---

## 바이트기반 스트림

### InputStream, OutputStream





## 문자기반 스트림

### FileReader, FileWriter





## 문자기반 보조스트림

### BufferedReader, BufferedWriter





## 표준입출력





## File





## 직렬화

> 객체를 데이터스트림으로 만드는 것







