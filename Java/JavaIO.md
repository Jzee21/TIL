# Java I/O

## Java 입출력

### 입출력

> 프로그램이 컴퓨터 내부 또는 외부의 장치와 데이터를 주고받는 것



### Stream

> Java에서 입출력을 수행하기 위해서는 두 대상을 연결하고 데이터를 전송할 수 있는 무언가가 필요하며, 이것을 스트림(Stream)이라 한다.
>
> 스트림이란 데이터를 운반하는데 사용되는 연결통로로서 단방향 통신만 가능하다.



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

[표준입출력](https://github.com/Jzee21/TIL/blob/master/Java/JavaIO.md#%ED%91%9C%EC%A4%80%EC%9E%85%EC%B6%9C%EB%A0%A5)



## 문자기반 스트림

### InputStreamReader

```java
InputStreamReader isr = new InputStreamReader(System.in);
```

- 바이트 단위의 InputStream을 이용하여

  문자기반 스트림인 InputStreamReader를 만들고 사용할 수 있다.

- 한 번에 하나의 문자를 읽는다.



### FileReader, FileWriter

```java
File file = //.....
FileReader fr = new FileReader(file);
```

- 파일로부터 데이터를 읽고 파일에 쓰는데 사용된다.



## 문자기반 보조스트림

### BufferedReader, BufferedWriter

> 가장 많이 쓰이는 보조스트림으로
>
> 버퍼를 이용하여 입출력의 효율을 높일 수 있도록 해주는 역할을 한다

```java
InputStreamReader isr = new InputStreamReader(System.in);
BufferedReader br = new BufferedReader(isr);
```

```java
FileReader fr = new FileReader(file);
BufferedReader br = new BufferedReader(fr);
```

- `readLine()` 메서드를 이용하여 라인 단위의 입출력 기능을 지원한다.



```java
FileReader fr = new FileReader(file);
BufferedReader br = new BufferedReader(fr);

String line = "";
while((line = br.readLine()) != null) {
    //...
}
```





## 표준입출력

> Java의 표준입출력은 콘솔(Console, 도스창)을 통한 데이터 입력과 출력을 의미한다.
>
> Java는 프로그램이 실행되는 동시에 아래의 스트림을 자동으로 생성한다.

```java
public final class System {
    public final static InputStream in = null;
    public final static PrintStream out = null;
    public final static PrintStream err = null;
    // ...
}
```

- System.in
- System.out
- System.err



## File

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





## 직렬화

> 객체를 데이터스트림으로 만드는 것



### ObjectStream







