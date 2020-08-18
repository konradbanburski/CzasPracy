create table ACCOUNTS (
    ID int unsigned primary key auto_increment,
    LOGIN varchar (100) UNIQUE,
    PASSWORD varchar (100),
    NAME varchar (50),
    SURNAME varchar (50),
    DEPARTMENT varchar (100),
    ACCOUNT_TYPE int
);
