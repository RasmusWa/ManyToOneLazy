CREATE TABLE PARENT (
    ID INT PRIMARY KEY
                    )

CREATE TABLE CHILD (
    ID INT PRIMARY KEY,
    PARENT_ID INT NOT NULL REFERENCES PARENT(ID)
)

INSERT INTO PARENT VALUES
                       (1),
                       (2),
                       (3)

INSERT INTO CHILD VALUES
                      (11, 1),
                      (12, 1),
                      (13, 1),
                      (21, 2),
                      (22, 2),
                      (23, 2),
                      (31, 3),
                      (32, 3),
                      (33, 3)
