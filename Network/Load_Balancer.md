# Load Balancer

---

## Traffic

> 서버의 데이터 전송량

> 외부에서 해당 서버에 접속을 많이 시도할 수록 트래픽이 증가한다. 트래픽이 서버가 버틸 수 있는 한계를 넘어서 지속적으로 들어올 경우, 서버는 버티지 못하고 다운되어 버린다.



### Traffic 해결 방법

- `Scale-up`  :  Server의 하드웨어 성능을 올린다
- `Scale-out`  :  여러대의 Server가 나누어 일을 처리한다.



### Scale-out의 장점

- 서버의 하드웨어 업그레드 비용보다 서버 1대 추가 비용이 더 저렴하다
- 여러대의 서버를 이용한 무중단 서비스가 가능하다



---

## Load Balancing

> 하나의 인터넷 서비스에 트레픽이 많을 때
>
> 서버의 로드율 변화, 부하량, 속도저하 등을 고려하여
>
> 여러대의 서버에 적절히 분산하여 해결해주는 서비스



### 분산방식

- `Round Robin`
  - 우선순위를 두지 않고 순서대로 분배한다
- `Least Connections`
  - 연결 갯수가 가장 적은 서버에게 분배한다.
  - 트래픽으로 인해 세션이 길어질 때 권장하는 방식
- `Source`
  - 사용자의 IP를 Hashing 하여 분배한다.
  - 동일한 IP에 대해 동일한 서버로의 연결을 보장한다



---

## Load Balancer

> Load Balancing 서비스를 제공하는 장비



### 종류

- `L2`
  - Mac 주소를 바탕으로 Load Balancing 한다
- `L3`
  - IP 주소를 바탕으로 Load Balancing 한다
- `L4`
  - Transport Layer(IP와 Port) Level에서 Load Balancing 한다
  - TCP, UDP 방식
- `L7`
  - Application Layer(사용자의 Request) Level에서 Load Balancing 한다
  - HTTP, HTTPS, FTP



---

# Reference Link

- 로드 밸런서(Load Balancer)란?

  출처 : [https://nesoy.github.io/articles/2018-06/Load-Balancer](https://nesoy.github.io/articles/2018-06/Load-Balancer) Nesoy Blog