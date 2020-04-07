# SQLite

> Android System 내부에는 기본적으로 SQLite라는 DB가 포함되어있다.



## SQLite 사용

> 기존에는 `SQLiteOpenHelper`를 이용하여 데이터를 저장하였지만,
>
> 2017년 Google I/O에서 `Android Architecture Components(AAC)`를 발표하면서 
>
> Android Developer 에서는 SQLite를 직접 사용하는 것은 `Low Level API`이기 때문에
>
>  AAC의 `Room`의 사용을 강력하게 권장한다.



## SQLite 기초

```java
String dbName = _21_dbNameEt.getText().toString();
database = openOrCreateDatabase(dbName, MODE_PRIVATE, null);

//
getString(R.string.channel_name);
//

String tableName = _21_tableNameEt.getText().toString();
String sql = "CREATE TABLE IF NOT EXISTS " + tableName
    + " ( _id INTEGER PRIMARY KEY AUTOINCREMENT, "
    + "name TEXT, age INTEGER, mobile TEXT)";
database.execSQL(sql);

String empName = _21_empNameEt.getText().toString();
int empAge = Integer.parseInt(_21_empAgeEt.getText().toString());
String empMobile = _21_empMobileEt.getText().toString();

String sql = "INSERT INTO emp(name, age, mobile) VALUES "
    + "('" + empName + "', " + empAge + ", '" + empMobile + "')";
database.execSQL(sql);
```



### 예제 1








## Low Level API

> `SQLiteOpenHelper`를 사용하는 방법과, 이를 사용하지 않는 방법이 있다.





### SQLiteOpenHelper

> SQLiteOpenHelper 를 이용하기 위해서는 별도의 Class를 Define 해주어야 한다.

```java
class MyDatabaseHelper extends SQLiteOpenHelper {
    
}
```





#### Method Override

> `SQLiteOpenHelper`를 상속받은 Helper 객체를 생성하면
>
> 반드시 Override 해야할 메서드들이 있다.
>
> 1. 생성자
> 2. onCreate()
> 3. onUpgrade()
>
> 여기에 필수는 아니지만 Override 하면 좋은 메서드로
>
> - onOpen()
>
> 메서드가 있다.



#### 생성자

> `SQLiteOpenHelper` 객체는 기본 생성자가 존재하지 않는다.
>
> 따라서 아래와 유사한 생성자를 기본으로 필요로 한다.

```java
public static final int DATABASE_VERSION = 1;
public static final String DATABASE_NAME = "MyDatabase";

public MyDatabaseHelper(@Nullable Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
}
```

`super(context, DATABASE_NAME, null, DATABASE_VERSION)`

- context 
- name  :  생성하거나 불러올 DB의 이름
- factory  :  기본적으로 `null`을 사용한다.
- version  :  DB의 버전 정보



#### onCreate()

> 생성자가 실행되면 자동적으로 `onOpen()` 메서드가 callback 된다
>
> 하지만, 만약 해당 DB가 존재하지 않다면, `onCreate()` 메서드가 먼저 호출된다.

```java
@Override
public void onCreate(SQLiteDatabase db) {

}
```





#### onOpen()

> 생성자의 `DATABASE_NAME` 이름으로 생성된 DB가 있을 때
>
> 생성자가 수행된 후 이 메서드가 자동적으로 callback 된다.

```java
@Override
public void onOpen(SQLiteDatabase db) {
    super.onOpen(db);
}
```





#### onUpgrade()

> 생성자의 `DATABASE_NAME` 이름으로 생성된 DB가 있을 때
>
> 기존의 `DATABASE_VERSION`과 `새로운 Version`이 다르다면
>
> `onUpgrade()` 메서드가 호출된 후, `onOpen()` 메서드가 실행된다.

```java
@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

}
```





#### 호출 순서

```java
if ( DATABASE_NAME DB가 존재하는가? ) {
    if ( 기존 Version == 새로운 Version ) {
        onOpen();
    } else {
        onUpgrade();
    }
} else {
    onCreate();
}
```



#### 예제 2

```java
class MyDBHelper extends SQLiteOpenHelper {
    public MyDBHelper(Context context, String DB_NAME, int DB_VERSION) {
    	super(context, DB_NAME, null, DB_VERSION);
	}
    
    @Override
    public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE IF NOT EXISTS person"
                + " ( _id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT, age INTEGER, mobile TEXT)";
        db.execSQL(sql);
    }
    
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
    
    
    @Override
    public void onUpgrade(SQLiteDatabase db, 
                          int oldVersion, int newVersion) {

    }
    
}
```

```java
private SQLiteDatabase database;
// ...
MyDBHelper helper = new MyDBHelper(___Activity.this, dbName, 1);
database = helper.getWritableDatabase();

```







## Cursor

> 예제 1

```java
String sql = "SELECT _id, name, age, mobile FROM emp";

Cursor cursor = database.rawQuery(sql, null);

cursor.moveToNext();

cursor.getInt(0);
cursor.getString(1);

```

![image-20200407130005843](Image/image-20200407130005843.png)



## Room







## Table

> Android System에서 SQLite는 각 앱별로 별도의 DB 공간을 가진다.



