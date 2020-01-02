in cmd

관리자 모드 로그인

`sqlplus "/as sysdba"`

```bash
sqlplus "/as sysdba"
```

```bash
SQL> show user;
USER is "SYS"
# alter user {account_name} identified by {password};
SQL> alter user system identified by oracle;
# system user id : oracle
User altered.

SQL> create user jzee identified by 1234;

User created.

SQL> conn jzee/1234
ERROR:
ORA-01045: user JZEE lacks CREATE SESSION privilege; logon denied
# 권한 없음

SQL> conn system
Enter password:
Connected.

SQL> alter user jzee account unlock;

User altered.

SQL> grant connect, resource to jzee;

Grant succeeded.

SQL> conn jzee/1234
Connected.


```

```bash
# prompt 변경
SQL> set sqlprompt user>
user>
```

---

```bash
# SQL
create table Customers (
    code number(4) primary key,
    name varchar2(30) not null,
    email varchar2(50),
    phone varchar2(20)
);


```





