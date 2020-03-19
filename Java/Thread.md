# Thread

기본 개념

- Multiprocessing
  - Task를 실행하는 core(processor)가 2개 이상인 경우
- Multitasking
  - 하나의 core가 시분할(time-slicing)기법을 이용해서 여러개의 Task를 마치 동시에 수행되는 것처럼 보이게 하는 기법
- **Multithreading**
  - 하나의 Task를 여러개의 Sub-Task(Thread)로 분할해서 동시간대에, 혹은 동시간에 실행되는 것처럼 만드는 기법
  - Thread는독립적인 실행 흐름