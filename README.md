**Ushbu loyihani ishga tushurish uchun yuklab olganingizda databaseni moslab olishingiz kerak bo'ladi.**

```
create database g410;

create table servlet_users(
    id       SERIAL PRIMARY KEY,
    username VARCHAR(50)         NOT NULL,
    email    VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100)        NOT NULL
);
```

