# Hibernate Many-To-One Relationship
An example, where the lazy many-to-one relationship doesn't work

## How to run?
`docker-compose up`

## What does it do?
It spins up three service-containers:
- many-to-one-database: An azure-sql-edge database
- many-to-one-initial-setup: An instance of mssql-tools for creating a sample database-schema with sample data in the azure-sql-edge database.
- many-to-one-app: A spring boot app doing a sample query right after the startup

## Data model

### Table `PARENT`
This table has just one column `ID`.
Sample Data:
- ID: 1
- ID: 2
- ID: 3

### Table `CHILD`
This table has one column `ID` and a second column `PARENT_ID` referencing the `ID` of the `PARENT`.
Sample Data:
- ID: 11, PARENT_ID: 1
- ID: 12, PARENT_ID: 1
- ID: 13, PARENT_ID: 1
- ID: 21, PARENT_ID: 2
- ID: 22, PARENT_ID: 2
- ID: 23, PARENT_ID: 2
- ID: 31, PARENT_ID: 3
- ID: 32, PARENT_ID: 3
- ID: 33, PARENT_ID: 3

## Behaviour
The spring boot application is compiled and executed. It queries all data of the `CHILD` entity and prints out the `ID`
column values. When querying the data, the SQL-Statements are printed by Hibernate.

The output looks as follows:
```
many-to-one-app                     | ##################################################################
many-to-one-app                     | ############################### Query ############################
many-to-one-app                     | ##################################################################
many-to-one-app                     | Hibernate: select c1_0.id,c1_0.parent_id from child c1_0
many-to-one-app                     | Hibernate: select p1_0.id from parent p1_0 where p1_0.id=?
many-to-one-app                     | Hibernate: select p1_0.id from parent p1_0 where p1_0.id=?
many-to-one-app                     | Hibernate: select p1_0.id from parent p1_0 where p1_0.id=?
many-to-one-app                     | Result: 11, 12, 13, 21, 22, 23, 31, 32, 33
many-to-one-app                     | ##################################################################
many-to-one-app                     | ##################################################################
```
It shows, that the `PARENT` table is queried, although the `ManyToOne` relationship is configured to be lazy and the 
code doesn't access the `parent` property.

## Expected Behaviour
As the code does not access the property `parent` of the Entity `Child` and that property is configured to be lazy,
there should be no query to the `PARENT` table.
