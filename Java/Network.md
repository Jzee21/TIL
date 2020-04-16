# Java Network

## Network

> 유선, 무선을 이용하여 데이터를 통신하기 위해 컴퓨터를 논리적, 물리적으로 묶어놓은 형태



### Network의 형태

> 네트워크의 크기에 따라 구분

1. LAN(Local Area Network)
2. WAN(Wide Area Network) 
3. MAN(Metropolitan Area Network)



## Internet

> Network of Network
>
> 물리적인 네트워크의 형태 - 네트워크들의 집합



## Network Address

> Internet 위의 컴퓨터들이 서로를 인지하기 위해 주소를 사용한다
>
> NIC(Network Interface Card) 마다 주소를 부여한다.



### IP Address

> NIC에 접근하기 위한 논리적인 주소

- IPv4
  - 32비트 주소체계
  - xxx.xxx.xxx.xxx 의 형태
  - 2^32개(4,294,967,296)의 주소 할당 가능
- IPv6
  - 128비트 주소체계
  - IPv4의 부족한 주소량을 보완하기 위한 주소체계
  - 2^128인 약 3.4x10^38개(340,282,366,920,938,463,463,374,607,431,768,211,456)



### MAC Address

> NIC마다 가지는 고유의 물리적 주소(ID와 비슷)



### DNS

> Domain Name System
>
> 숫자로 된 IP Address를 문자로 사용
>
> www.naver.com



## Protocol

> 통신을 위해 정해진 규칙

TCP, IP, ARP, TELNET, FTP, HTTP .....



## Port

> 컴퓨터 내에서 동작하고 있는 프로그램을 지칭하는 숫자
>
> 0~65535의 범위를 가진다

- 0~1023  :  미리 예약된 숫자



## Socket

> 컴퓨터가 다른 컴퓨터와 통신하기 위한
>
> 복잡한 네트워크 처리를 알아서 처리하도록 하는 개념



### Example

#### Server

```java
try {

    ServerSocket server = new ServerSocket(5556);
    System.out.println("[server created]");

    Socket s = server.accept();
    System.out.println("Client Accept!");

    String date = (new Date()).toLocaleString();
    PrintWriter out = new PrintWriter(s.getOutputStream());
    out.println(date);
    out.flush();
    out.close();

    s.close();
    server.close();

} catch (IOException e) {
    e.printStackTrace();
}
```



#### Client

```java
try {
    Socket s= new Socket("localhost", 5556);
    BufferedReader br = new BufferedReader(
        new InputStreamReader(s.getInputStream()));
    System.out.println(br.readLine());

    br.close();
    s.close();

} catch (UnknownHostException e1) {
    e1.printStackTrace();
} catch (IOException e1) {
    e1.printStackTrace();
}
```











