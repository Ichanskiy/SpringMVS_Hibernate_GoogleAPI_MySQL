create table USERS
(
  USER_PHONE     varchar(20) not null,
  USER_NAME      VARCHAR2(30) not null,
  USER_EMAIL     VARCHAR2(250) not null,
  USER_BIRTHDATE DATE not null
);

create table PLACEPOINT
(
  PLACEPOINT_ID      int(5) not null,
  PLACEPOINT_LONG    numeric(30) not null,
  PLACEPOINT_LAT     numeric(30) not null,
  PLACEPOINT_ADDRESS VARCHAR(250)
) ;

create table TAG
(
  TAG_NAME        VARCHAR(30) not null,
  TAG_NAME_PARENT_FK VARCHAR(30) not null,
  TAG_DISCRIPTION VARCHAR(250)
) ;

create table USEREXPENSES
(
  USEREXPENSES_ID   int(5) not null,
  USER_PHONE_FK     varchar(20) not null,
  PLACEPOINT_ID_FK  numeric(30) not null,
  USEREXPERSES_COUNT numeric(30) not null,
  USEREXPERSES_DATE timestamp default current_timestamp not null
) ;

create table USEREXPENSESTAG
(
  TAG_NAME_FK         VARCHAR(30) not null,
  USER_EXPENSES_ID_FK int(5) not null
) ;

-- Create/Recreate primary, unique and foreign key constraints 
alter table TAG
  add constraint PK_TAG primary key (TAG_NAME) ;
  
alter table TAG
add constraint FK_TAG
  foreign key (TAG_NAME_PARENT_FK)
  references TAG(TAG_NAME);


alter table PLACEPOINT
  add constraint PK_PLACEPOINT_ID primary key (PLACEPOINT_ID) ;
alter table PLACEPOINT
  add constraint NN_PLACEPOINT_ID
  check ("PLACEPOINT_ID" IS NOT NULL);
  
ALTER TABLE placepoint MODIFY COLUMN placepoint.PLACEPOINT_ID INT AUTO_INCREMENT;

alter table USERS
  add constraint PK_USER_PHONE unique (USER_PHONE) ;
alter table USERS
  add constraint PK_USER_PHONE primary key (USER_PHONE) ;

alter table USEREXPENSES
  add constraint PK_USEREXPENSES_ID primary key (USEREXPENSES_ID) ;
alter table USEREXPENSES
  add constraint UNQ_USEREXPENSES unique (USER_PHONE_FK, PLACEPOINT_ID_FK, USEREXPERSES_DATE) ;

    -- Create/Recreate primary, unique and foreign key constraints 
alter table USEREXPENSESTAG
  add constraint FK_TAG_NAME_FK foreign key (TAG_NAME_FK)
  references TAG (TAG_NAME);
alter table USEREXPENSESTAG
  add constraint FK_USER_EXPENSES_ID_FK foreign key (USER_EXPENSES_ID_FK)
  references USEREXPENSES (USEREXPENSES_ID);