ALTER TABLE ??????
DROP CONSTRAINT ??????_????

GO

ALTER TABLE ??????
DROP CONSTRAINT ??????_??????????

GO

ALTER TABLE ??????????
DROP CONSTRAINT ??????????_?????????

GO

ALTER TABLE ?????_?_????????
DROP CONSTRAINT ?????_?_????????_?????_?_?????????

GO

ALTER TABLE ?????_?_????????
DROP CONSTRAINT ?????_?_????????_????

GO

ALTER TABLE ????
DROP CONSTRAINT ????_?????

GO

ALTER TABLE ???????????_?_???????
DROP CONSTRAINT ???????????_?_???????_?????

GO

ALTER TABLE ???????????_?_???????
DROP CONSTRAINT ???????????_?_???????_???????????

GO

ALTER TABLE ???????
DROP CONSTRAINT ???????_???????????

GO

ALTER TABLE ???????
DROP CONSTRAINT ???????_??????????

GO

ALTER TABLE ?????????
DROP CONSTRAINT UNIQUE_?????????_?????????

GO

ALTER TABLE ????
DROP CONSTRAINT CHECK_????_????_?????

GO

/*
???????????? ?????? ?5
????????? ?????? ? ??????? SQL-?????????

? ?????? ?????? ???? ??????????? ????? SQL-???????? ??? ???????? ???? ?????? ????????????? ???? ??????.
????? ? CREATE TABLE ?????? ???? ?????????? ???????? ????? ?? ?????????, 
??????????? ???????????? ? ??????????? ??????????? 
(? CREATE TABLE ??? ???? ?????? ?????? ???? ?????????? ???? ?? ?? ?????? ??????????? ??????? ????).
*/

DROP TABLE ??????????
GO

DROP TABLE ?????????
GO

DROP TABLE ??????
GO

DROP TABLE ????
GO

DROP TABLE ?????
GO

DROP TABLE ?????_?_????????
GO

DROP TABLE ?????_?_?????????
GO

DROP TABLE ???????????_?_???????
GO

DROP TABLE ??????????
GO

DROP TABLE ???????
GO

DROP TABLE ???????????
GO

CREATE TABLE ??????????
(
	  ??? int IDENTITY PRIMARY KEY
	, ??? nvarchar(40) NOT NULL
	, ???_????????? int NOT NULL
)

GO

CREATE TABLE ?????????
(
	  ??? int IDENTITY PRIMARY KEY
	, ????????? nvarchar(20) NOT NULL /*UNIQUE*/
)

GO

CREATE TABLE ??????
(
	  ??? int IDENTITY PRIMARY KEY
	, ???_?????????? int NOT NULL
	, ???_???? int NOT NULL
	, ???? date NOT NULL
	, ????? time(0) NOT NULL
	, ?????_??????? int NOT NULL
	, ?????????? int NOT NULL
)

GO

CREATE TABLE ????
(
	  ??? int IDENTITY PRIMARY KEY
	, ???_????? int NOT NULL
	, ????_????? money NOT NULL DEFAULT 30 /*CHECK(????_????? > 0)*/
	, ???? date NOT NULL
)

GO

CREATE TABLE ?????
(
	  ??? int IDENTITY PRIMARY KEY
	, ????????_????? nvarchar(30) NOT NULL UNIQUE
	, ???????_????????? nvarchar(10) NOT NULL
)

GO

CREATE TABLE ?????_?_????????
(
	  ??? int IDENTITY PRIMARY KEY
	, ???_???? int NOT NULL
	, ???_??????_?_????????? int NOT NULL
	, ?????????? int NOT NULL DEFAULT 3 CHECK(?????????? > 0)
)

GO

CREATE TABLE ?????_?_?????????
(
	  ??? int IDENTITY PRIMARY KEY
	, ????? nvarchar(40) NOT NULL
	, ??????? nvarchar(14) NOT NULL
	, ???? date NOT NULL
)

GO

CREATE TABLE ???????????_?_???????
(
	  ??? int IDENTITY PRIMARY KEY
	, ???_??????????? int NOT NULL
	, ???_????? int NOT NULL
	, ?????????? int NOT NULL DEFAULT 1 CHECK(?????????? > 0)
)

GO

CREATE TABLE ??????????
(
	  ??? int IDENTITY PRIMARY KEY
	, ???????? nvarchar(40) NOT NULL
	, ????? nvarchar(40) NOT NULL
	, ??????? nvarchar(12) NOT NULL
)

GO

CREATE TABLE ???????
(
	  ??? int IDENTITY PRIMARY KEY
	, ???_??????????? int NOT NULL
	, ?????????? int NOT NULL DEFAULT 1 CHECK(?????????? > 0)
	, ???_?????????? int NOT NULL
	, ???? date NOT NULL
	, ???? money NOT NULL DEFAULT 1 CHECK(???? > 0)
)

GO

CREATE TABLE ???????????
(
	  ??? int IDENTITY PRIMARY KEY
	, ???????? nvarchar(25) NOT NULL
	, ???????_????????? nvarchar(10) NOT NULL
)

GO
/*
???????????? ?????? ?7
???????????? ?????? ????? ????????? ? ??????? SQL ?????????
? ?????? ?????? ???? ??????????? ????? SQL-???????? ??? ??????????? ?????? ????? ?????????
(ALTER TABLE + CONSTRAINT).
????? ? ALTER TABLE ?????? ???? ?????????? ??????????? ???????????? ? ??????????? ???????????
(? ALTER TABLE ??? ???? ?????? ?????? ???? ?????????? ???? ?? ?? ?????? ??????????? ??????? ????).
*/
ALTER TABLE ??????
ADD CONSTRAINT ??????_?????????? FOREIGN KEY (???_??????????)
REFERENCES ??????????(???)

GO

ALTER TABLE ??????
ADD CONSTRAINT ??????_???? FOREIGN KEY (???_????)
REFERENCES ????(???)

GO

ALTER TABLE ??????????
ADD CONSTRAINT ??????????_????????? FOREIGN KEY (???_?????????)
REFERENCES ?????????(???)

GO

ALTER TABLE ????
ADD CONSTRAINT ????_????? FOREIGN KEY (???_?????)
REFERENCES ?????(???)

GO

ALTER TABLE ?????_?_????????
ADD CONSTRAINT ?????_?_????????_???? FOREIGN KEY (???_????)
REFERENCES ????(???)

GO

ALTER TABLE ?????_?_????????
ADD CONSTRAINT ?????_?_????????_?????_?_????????? FOREIGN KEY (???_??????_?_?????????)
REFERENCES ?????_?_?????????(???)

GO

ALTER TABLE ???????????_?_???????
ADD CONSTRAINT ???????????_?_???????_????? FOREIGN KEY (???_?????)
REFERENCES ?????(???)

GO

ALTER TABLE ???????????_?_???????
ADD CONSTRAINT ???????????_?_???????_??????????? FOREIGN KEY (???_???????????)
REFERENCES ???????????(???)

GO

ALTER TABLE ???????
ADD CONSTRAINT ???????_??????????? FOREIGN KEY (???_???????????)
REFERENCES ???????????(???)

GO

ALTER TABLE ???????
ADD CONSTRAINT ???????_?????????? FOREIGN KEY (???_??????????)
REFERENCES ??????????(???)

GO

ALTER TABLE ?????????
ADD CONSTRAINT UNIQUE_?????????_????????? UNIQUE(?????????)

GO


ALTER TABLE ????
ADD CONSTRAINT CHECK_????_????_????? CHECK(????_????? > 0)

GO

/*
???????????? ?????? ?8
?????????????? SQL-???????? ??? ??????????? ???????
? ?????? ?????? ???? ??????????? ????? SQL-???????? ??? ????????? ?????? ? ???? ?????? ?
INSERT INTO?VALUES, ??????????? ?????? ? ?????-???? ????? ??????? ? UPDATE,
???????? ?????? ?? ?????-???? ??????? ? DELETE.
? ?????????? ?????????? ?????? ? ?????? ??????? ?????? ???? ???????? ?? ????? 2-? ???????,
? ?????? ???????? ??????? ?????? ???? ???????? ?????? ???????,
??? ? ????? ?? ?? ???????????? ??????.
*/

INSERT INTO ????????? VALUES('???????')
GO

INSERT INTO ????????? VALUES('??????')
GO

INSERT INTO ????????? VALUES('????????')
GO

INSERT INTO ????????? VALUES('??????')
GO

INSERT INTO ????????? VALUES('???????????')
GO

INSERT INTO ????????? VALUES('?????')
GO

INSERT INTO ?????????? VALUES ('???????? ???????? ?????????????', 2)
GO

INSERT INTO ?????????? VALUES ('????????? ???? ?????????', 3)
GO

INSERT INTO ?????????? VALUES ('????????? ????? ??????????', 2)
GO

INSERT INTO ?????????? VALUES ('?????? ????? ?????????', 1)
GO

INSERT INTO ?????????? VALUES ('??????? ????????? Ը???????', 3)
GO

INSERT INTO ?????????? VALUES ('????????? ???? ??????????', 5)
GO

INSERT INTO ?????????? VALUES ('????????? ??? ??????????', 1)
GO

INSERT INTO ?????????? VALUES ('????????? ???????? ?????????????', 3)
GO

INSERT INTO ?????????? VALUES ('???????? ????? ???????????', 4)
GO

INSERT INTO ?????_?_????????? VALUES ('??.?????????, 34', '+375333340111', '20191014')
GO

INSERT INTO ?????_?_????????? VALUES ('??.??????, 14', '+375293832900', '20191012')
GO

INSERT INTO ?????_?_????????? VALUES ('??.??????, 14', '+375291795744', '20191009')
GO

INSERT INTO ?????_?_????????? VALUES ('??.????, 113?', '+375334567890', '20191011')
GO

INSERT INTO ?????_?_????????? VALUES ('??.????????, 1', '+375445612978', '20191021')
GO

INSERT INTO ????? VALUES ('???? ? ???????', '?????')
GO

INSERT INTO ????? VALUES ('???????? ? ???????', '????')
GO

INSERT INTO ????? VALUES ('???????? ? ???????? ??????', '????')
GO

INSERT INTO ????? VALUES ('??????? ???????? ?? ?????', '?????')
GO

INSERT INTO ????? VALUES ('??????? ?? ????? ?????', '?????')
GO

INSERT INTO ????? VALUES ('?????? ????', '?????')
GO

INSERT INTO ????? VALUES ('??????? ?????? ??????', '?????')
GO

INSERT INTO ????? VALUES ('????? ??????', '?????')
GO

INSERT INTO ????? VALUES ('????????? ?????', '?????')
GO

INSERT INTO ????? VALUES ('??????? ??????', '?????')
GO

INSERT INTO ???? VALUES (1, 500, '20191008')
GO

INSERT INTO ???? VALUES (2, 300, '20191008')
GO

INSERT INTO ???? VALUES (3, 150, '20191008')
GO

INSERT INTO ???? VALUES (4, 100, '20191007')
GO

INSERT INTO ???? VALUES (5, 700, '20191009')
GO

INSERT INTO ???? VALUES (6, 650, '20191008')
GO

INSERT INTO ???? VALUES (7, 210, '20191005')
GO

INSERT INTO ???? VALUES (8, 400, '20191008')
GO

INSERT INTO ???? VALUES (9, 400, '20191008')
GO

INSERT INTO ???? VALUES (10, 70, '20191008')
GO

INSERT INTO ???? VALUES (3, 160, '20191027')
GO

INSERT INTO ?????_?_???????? VALUES (1, 1, 1)
GO

INSERT INTO ?????_?_???????? VALUES (2, 1, 3)
GO

INSERT INTO ?????_?_???????? VALUES (1, 2, 4)
GO

INSERT INTO ?????_?_???????? VALUES (4, 2, 1)
GO

INSERT INTO ?????_?_???????? VALUES (10, 3, 1)
GO

INSERT INTO ?????_?_???????? VALUES (9, 3, 3)
GO

INSERT INTO ?????_?_???????? VALUES (6, 4, 2)
GO

INSERT INTO ?????_?_???????? VALUES (7, 4, 1)
GO

INSERT INTO ?????_?_???????? VALUES (1, 5, 2)
GO

INSERT INTO ?????_?_???????? VALUES (3, 5, 5)
GO

INSERT INTO ?????_?_???????? VALUES (9, 3, 1)
GO

INSERT INTO ?????_?_???????? VALUES (5, 3, 1)
GO

INSERT INTO ?????? VALUES (2, 1, '20191008', '10:30', 1, 1)
GO

INSERT INTO ?????? VALUES (2, 8, '20191008', '11:00', 1, 2)
GO

INSERT INTO ?????? VALUES (2, 10, '20191008', '11:20', 1, 1)
GO

INSERT INTO ?????? VALUES (5, 1, '20191008', '10:30', 1, 1)
GO

INSERT INTO ?????? VALUES (5, 1, '20191008', '10:30', 1, 1)
GO

INSERT INTO ?????? VALUES (5, 1, '20191008', '10:30', 1, 1)
GO

INSERT INTO ?????? VALUES (5, 1, '20191008', '10:30', 1, 2)
GO

INSERT INTO ?????? VALUES (5, 1, '20191008', '11:40', 2, 1)
GO

INSERT INTO ?????? VALUES (8, 1, '20191008', '12:30', 1, 3)
GO

INSERT INTO ?????? VALUES (8, 1, '20191009', '10:30', 1, 5)
GO

INSERT INTO ?????? VALUES (8, 1, '20191009', '10:50', 2, 5)
GO

INSERT INTO ?????? VALUES (8, 1, '20191009', '10:30', 1, 1)
GO

INSERT INTO ?????? VALUES (9, 1, '20191017', '17:30', 1, 1)
GO

INSERT INTO ??????????? VALUES ('?????', '????')
GO

INSERT INTO ??????????? VALUES ('???? ???????', '?????')
GO

INSERT INTO ??????????? VALUES ('???????', '?????')
GO

INSERT INTO ??????????? VALUES ('????', '?????')
GO

INSERT INTO ??????????? VALUES ('???', '?????')
GO

INSERT INTO ??????????? VALUES ('??????', '?????')
GO

INSERT INTO ??????????? VALUES ('???????', '?????')
GO

INSERT INTO ??????????? VALUES ('????', '??')
GO

INSERT INTO ??????????? VALUES ('????????', '?????')
GO

INSERT INTO ??????????? VALUES ('????', '?????')
GO

INSERT INTO ??????????? VALUES ('?????? ???', '??')
GO

INSERT INTO ??????????? VALUES ('????', '?????')
GO

INSERT INTO ??????????? VALUES ('?????', '????')
GO

INSERT INTO ??????????? VALUES ('?????', '?????')
GO

INSERT INTO ??????????? VALUES ('????', '?????')
GO

INSERT INTO ??????????? VALUES ('??????', '?????')
GO

INSERT INTO ??????????? VALUES ('????????', '?????')
GO

INSERT INTO ???????????_?_??????? VALUES (1, 1, 320)
GO

INSERT INTO ???????????_?_??????? VALUES (2, 2, 200)
GO

INSERT INTO ???????????_?_??????? VALUES (3, 4, 400)
GO

INSERT INTO ???????????_?_??????? VALUES (4, 6, 100)
GO

INSERT INTO ???????????_?_??????? VALUES (5, 3, 200)
GO

INSERT INTO ???????????_?_??????? VALUES (6, 1, 120)
GO

INSERT INTO ???????????_?_??????? VALUES (7, 2, 200)
GO

INSERT INTO ???????????_?_??????? VALUES (8, 9, 100)
GO

INSERT INTO ???????????_?_??????? VALUES (9, 10, 50)
GO

INSERT INTO ???????????_?_??????? VALUES (10, 1, 200)
GO

INSERT INTO ???????????_?_??????? VALUES (11, 4, 222)
GO

INSERT INTO ???????????_?_??????? VALUES (12, 3, 200)
GO

INSERT INTO ???????????_?_??????? VALUES (13, 9, 200)
GO

INSERT INTO ???????????_?_??????? VALUES (14, 1, 30)
GO

INSERT INTO ???????????_?_??????? VALUES (15, 2, 20)
GO

INSERT INTO ???????????_?_??????? VALUES (16, 2, 10)
GO

INSERT INTO ???????????_?_??????? VALUES (17, 8, 5)
GO

INSERT INTO ???????????_?_??????? VALUES (5, 8, 40)
GO

INSERT INTO ???????????_?_??????? VALUES (3, 1, 75)
GO

INSERT INTO ???????????_?_??????? VALUES (15, 1, 200)
GO

INSERT INTO ???????????_?_??????? VALUES (12, 2, 200)
GO

INSERT INTO ???????????_?_??????? VALUES (11, 7, 1)
GO

INSERT INTO ???????????_?_??????? VALUES (1, 1, 2)
GO

INSERT INTO ???????????_?_??????? VALUES (13, 1, 3)
GO

INSERT INTO ???????????_?_??????? VALUES (14, 4, 54)
GO

INSERT INTO ?????????? VALUES ('?? ????????', '?.????????', '23-14-56')
GO

INSERT INTO ?????????? VALUES ('?? ?????? ?????', '?.??????', '33-12-14')
GO

INSERT INTO ?????????? VALUES ('??? ?????????', '?.??????', '23-64-35')
GO

INSERT INTO ?????????? VALUES ('?????? ????????', '?.??????', '34-65-78')
GO

INSERT INTO ?????????? VALUES ('??? ???????', '?.?????', '45-65-90')
GO

INSERT INTO ??????? VALUES (1, 150, 5, '20191011', 300)
GO

INSERT INTO ??????? VALUES (2, 200, 1, '20191011', 150)
GO

INSERT INTO ??????? VALUES (3, 150, 2, '20191011', 200)
GO

INSERT INTO ??????? VALUES (4, 300, 3, '20191011', 3000)
GO

INSERT INTO ??????? VALUES (5, 450, 4, '20191011', 320)
GO

INSERT INTO ??????? VALUES (6, 1000, 5, '20191011', 123)
GO

INSERT INTO ??????? VALUES (7, 150, 2, '20191011', 234)
GO

INSERT INTO ??????? VALUES (8, 150, 3, '20191011', 900)
GO

INSERT INTO ??????? VALUES (9, 15, 4, '20191011', 399)
GO

INSERT INTO ??????? VALUES (10, 10, 5, '20191011', 989)
GO

INSERT INTO ??????? VALUES (11, 50, 1, '20191011', 234)
GO

INSERT INTO ??????? VALUES (12, 30, 2, '20191012', 300)
GO

INSERT INTO ??????? VALUES (13, 55, 3, '20191011', 300)
GO

INSERT INTO ??????? VALUES (14, 112, 3, '20191015', 750)
GO

INSERT INTO ??????? VALUES (15, 1, 1, '20191010', 680)
GO

INSERT INTO ??????? VALUES (17, 80, 5, '20191010', 332)
GO

INSERT INTO ??????? VALUES (16, 90, 1, '20191010', 123)
GO

INSERT INTO ??????? VALUES (3, 150, 5, '20191023', 300)
GO

DELETE FROM ??????
WHERE ???? = '20191017'
GO

UPDATE ???????
SET  ?????????? += 10
WHERE ???_?????????? = 1
GO
/*
???????????? ?????? ?9
????????? ????????????? (view)?
? ?????? ?????? ???? ??????????? ????? SQL-??????? ??? ???????? ?????????????.
?????? ? ????????????? ?????? ?????????? ?????? ?? ????? ??? ?? 2-? ?????? ???? ??????
(????????????? ?? ?????? ?????? ? ??????? ?? ??????????? ? ?????????? ? ???????????? ?? ???????????).
????? ????? ?????? ????????? ???????? ?? ?????????? ??????? ? ?????????????? ?????????????
? ????? Management Studio.
*/
/*DROP VIEW ???????????????????08102019
GO*/

/*
--???????? - ??? ????????? 
--????????? - ?????????? ????? ? ????? ???? 08.10.2019
*/
/*
CREATE VIEW ???????????????????08102019
AS
SELECT ??????.??? as ?????????, ??????.???? as ??????????, ?????_???????, ????_?????, ?????.????????_?????
FROM ??????, ????, ?????
WHERE ????.??? = ??????.???_???? and ????.???_????? = ?????.??? and ????.???? = '20191008'
GO

SELECT *
FROM ???????????????????08102019
GO
*/

/*
???????????? ?????? ? 11
????????? ?????????? ???????? ????????? ?? SQL-????????
? ?????? ?????? ???? ??????????? ????? SQL-??????? ??? ???????? ????????????????? ???????? ?????????.
????????? ?????? ???????????? ???????? ? ??? ??????? ?? ?????-???? ???????????? ??????? ???? ?????? ?
?????????? ??????????????? ?????? ?? ?????-???? ???????? ??????? (????????, ???????? ??? ????????
? ?????????? ??? ??????).
????????? ?? ?????? ?????? ? ??????? ?? ??????????? ? ?????????? ? ???????????? ?? ???????????.
????? ? ?????? ?????? ???? ??????????? ???????? ?? ?????? ????????????? ????????? ? ????? Management Studio.
*/

DROP PROCEDURE ??????????
GO

--???????? - ????
--????????? - ???????? ????????? ???? ?? ?????? ????

CREATE PROCEDURE ?????????? @???? INT
AS
SELECT ????????_?????, ????_?????, ????
FROM ????, ?????
WHERE ????.???_????? = ?????.??? and ????_????? = @????
GO

/*EXEC ?????????? 400
GO*/

/*
???????????? ?????? ? 13
????????? ????????????????? ???????? ????????? ?? SQL-????????
? ?????? ?????? ???? ??????????? ????? SQL-??????? ??? ???????? ????????????????? ???????? ?????????.
????????? ?????? ???????????? 2 ????????? ? ???????? ?? ???????? ????? ???? ???????????? ??????,
?? ??????? ??????????? ????? ??????? ???????? ???????, ? ?????????? ??????????????? ?????? ???????? ???????
(????????, ???????? ??????? ????????????? ? ??????? ????????, ? ?????????? ??????, ???????????? ???????? ?????????????? ?????????? ????????).
??? ?????????? ?????? ???? ??????? ???????? ?? ????????? (?? NULL).
???? ??? ?????? ????????? ?????? ???????? ????????? NULL,
????? ??????? ?? ????? ????????? ??????????? ?? ??????
(????????, ???? ? ???????? ??????? ????????????? ?????? ???????? NULL,
?? ?????? ???? ?????????? ??? ?????? ????????? ????????). ???????? ???????? NULL ? ??????????
?????? ??????????? ? ?????????? IF, ? ?? ? ???????? ????????.
?????????????? ????? ?????? ?????? ????????? ??? ???? ???????? ??????? ? ???? ???????????? ??????,
?? ??????? ??????????? ????? ??????? (?????? ???? ? ??? ?? ????? ?????, ???? ???? ????? ?? ?????
?? ???????????).
????????? ?? ?????? ?????? ? ??????? ?? ??????????? ? ?????????? ? ???????????? ?? ???????????.
? ?????? ????? ?????? ???? ???????????? ????????? ?? ?????? ????????????? ????????? ? ?????
Management Studio. ?????? ???? ???????? ?????????? ??? ???? ?????????? NULL / NOT NULL ? ??????????,
???????????? ???????????, ???????? ? ????????? ????? ??????? ??????????,
???????????? ??????? ???????? ?? ?????????.
*/

DROP PROCEDURE ???????????????????????????????????????????????????????
GO

/*
--???????? ????????????? ?? ??????? ?????
--???????? ??????????????????? ?? ??????? ???????????
--????????? ??????????? ? ??????? ?? ???????? ??????????? ? ?? ???????? ?????
*/

CREATE PROCEDURE ??????????????????????????????????????????????????????? @????????????? varchar(40) = '????? ??????',
				@??????????????????? varchar(40) = '????????'
AS
begin
  if @????????????? is null
    if @??????????????????? is null
      SELECT ???????????_?_???????.??? as ?????????????????????, ???_???????????, ???_?????, ????????_?????,
			???????? as ????????_???????????, ??????????
      FROM ?????, ???????????_?_???????, ???????????
      WHERE ?????.??? = ???????????_?_???????.???_????? and
	    ???????????_?_???????.???_??????????? = ???????????.???
	else
	  SELECT ???????????_?_???????.??? as ?????????????????????, ???_???????????, ???_?????, ????????_?????,
			???????? as ????????_???????????, ??????????
      FROM ?????, ???????????_?_???????, ???????????
      WHERE ?????.??? = ???????????_?_???????.???_????? and
	    ???????????_?_???????.???_??????????? = ???????????.??? and
	    @??????????????????? = ???????????.????????
  else
    if @??????????????????? is null
      SELECT ???????????_?_???????.??? as ?????????????????????, ???_???????????, ???_?????, ????????_?????,
			???????? as ????????_???????????, ??????????
      FROM ?????, ???????????_?_???????, ???????????
      WHERE ?????.??? = ???????????_?_???????.???_????? and
	    ???????????_?_???????.???_??????????? = ???????????.??? and
	    @????????????? = ?????.????????_?????
	else
	  SELECT ???????????_?_???????.??? as ?????????????????????, ???_???????????, ???_?????, ????????_?????,
			???????? as ????????_???????????, ??????????
      FROM ?????, ???????????_?_???????, ???????????
      WHERE ?????.??? = ???????????_?_???????.???_????? and
	    ???????????_?_???????.???_??????????? = ???????????.??? and
	    @??????????????????? = ???????????.???????? and
	    @????????????? = ?????.????????_?????
end
GO

/*EXEC ???????????????????????????????????????????????????????
GO

EXEC ??????????????????????????????????????????????????????? null, null
GO

EXEC ??????????????????????????????????????????????????????? @????????????? = null
GO

EXEC ??????????????????????????????????????????????????????? @????????????? = null
GO

EXEC ??????????????????????????????????????????????????????? @????????????? = null, @??????????????????? = '????????'
GO

EXEC ??????????????????????????????????????????????????????? '??????? ???????? ?? ?????', '?????'
GO

EXEC ??????????????????????????????????????????????????????? '????????? ?????', null
GO

EXEC ??????????????????????????????????????????????????????? '?????? ????', @??????????????????? = '????'
GO

EXEC ??????????????????????????????????????????????????????? '????? ??????'
GO

EXEC ??????????????????????????????????????????????????????? @????????????? = '?????? ????', @??????????????????? = null
GO

EXEC ??????????????????????????????????????????????????????? @????????????? = '??????? ??????', @??????????????????? = '????????'
GO*/

/*
???????????? ?????? ? 14
??????????? ????? ????????? ??????? ? ???????? ??????????
? ?????? ?????? ???? ??????????? ????? SQL-??????? ??? ???????? ???????? ?????????, ?????????????? ???????????? ????????
????????? ???? ?????-???? ??????? ???? ??????. ? ????????? ?????? ???? ??????????? ???? ????????? ??????? ???????
(??? ????????????? ???????) ? ???????????? ????????? ???????? ?????????????? ?? ???????????? ???????? ????. ????????
?????????????? ?????? ???? ?????????? ?? ????????? ? ??????? ????????? RETURN.
???????? ??????? ???????????? ?????? ????????? ?????. ???? ??????? ?????? ????????????? ????????? ??????????????? ??????? ???????
(????????, ?????? ????? ??????? ???????? ???????? ???????????????????), ?? ???????????????, ??? ?????? ??????????? ?? ??????????? ???????? ?????????? ????? ???????. ????????? ????? ???? ???????????????, ? ???? ?????? ???????? ? ??????? ?????? ???????????? @P.
???? ???? ????????????? ? ????? ?? ???????. ?? ?????? ???? ???????? ? ?????????????? ?????????????? ??????? ?? ????????? ???????,
?? ??????????? ?????? ID ????????? ??????.
? ??????, ????? ????????? ??????? ??????, ?????? ???? ???????? ????? ??????? ? ???????????? ? ??????? ???????? ? ???? ?????????,
????? ???????? ???? ?? ????? ??????? ??????????????.
????? ? ?????? ?????? ???? ???????????? ????????? ?? ?????????? ????????? ????????:
1)      ?????????? ??????? ??? ????????? ???????? ?????? ?? ??????? ???? ??????: ???? ?????????? ????? ? ????????? ???? ?
?????????? ??????????????????. ?????? ?????? ???? ??????????? ?? ???????? ?????????? ?????;
2)      ????? ????????????? ????????? ? ????? Management Studio ? ??????????? ? ?????????? ????????, ????????????? ??????????,
? ???????????? ????? ????????.
??????? 12
????? ????? ???????? ?????????, ??????????? ?? ????????? ?????????, ?????? @P
*/

DROP PROC ??????????????????????????????????
GO

CREATE PROC ?????????????????????????????????? @P int
AS

--????????? - ????? ???????? ?????????, ??????????? ?? ????????? ?????????, ?????? @P

DECLARE @id INT = (SELECT MAX(???) FROM ???????????_?_??????? WHERE ?????????? = @P),
		@res INT = 0
SET @id = (SELECT MIN(???) FROM ???????????_?_??????? WHERE ??? > @id)
WHILE @id is not null
begin
  SET @res = @res + (SELECT ?????????? FROM ???????????_?_??????? WHERE ??? = @id)
  SET @id = (SELECT MIN(???) FROM ???????????_?_??????? WHERE ??? > @id)
END
RETURN @res
GO

/*DECLARE @res INT
EXEC @res = ?????????????????????????????????? 200
SELECT @res AS "?????"*/

/*
???????????? ?????? ? 15
?????????????? ????????? ?????? ? ????????  ???????????
? ?????? ?????? ???? ??????????? ????? SQL-??????? ??? ???????? ????????????????? ???????? ?????????.
????????? ?????? ???????????? ???????? ? ??? ??????? ?? ?????-???? ???????????? ??????? ???? ?????? ? ?????????? ??????????????? ??????
?? ?????-???? ???????? ??????? (????????, ???????? ??? ???????? ? ?????????? ??? ??????).
???????????? ???????? ?????? ? ????????? ?????? ??????????? ? ??? ?????:
1)      ????????? ???????? ?????? ?? ????????? ??????? ? ??????? SELECT ? INTO (????????, ?????? ????????);
2)      ??????????? ????????? ??????? (????????, ???????? ???????) c ??????? UPDATE ??? DELETE ???????;
3)      ??????? ??????????? ????????? ??????? ??? ?????????? ?????? ?????????.
????????? ?? ?????? ?????? ? ??????? ?? ??????????? ? ?????????? ? ???????????? ?? ???????????.
? ?????? ????? ?????? ???? ??????????? ???????? ?? ?????? ????????????? ????????? ? ????? Management Studio.
*/

DROP PROC ?????????????????????????????????????
GO

CREATE PROC ????????????????????????????????????? @???_????? INT
--???????? - ???_?????
--????????? - ???? ? ??????????? ?????? ?? 10 ??????
AS
BEGIN
  SELECT ???, ???_?????, ????_?????, ???? INTO #RES FROM ???? WHERE ???_????? = @???_?????
  UPDATE #RES SET ????_????? = ????_????? + 10 WHERE ???_????? = @???_?????
  SELECT ??? AS "??? ????", ???_????? AS "??? ?????", ????_????? AS "???? ?????", ????
  FROM #RES
END
GO

EXEC ????????????????????????????????????? 9