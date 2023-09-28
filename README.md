# Flyway Database Version Control

**Flyway** updates a database from one version to the next using migrations. We can write migrations either in SQL with
database-specific syntax, or in Java for advanced database transformations.

## Configuration

* First disable or remove any auto update or create configuration of **DDL**

````text
spring.jpa.generate-ddl=false
spring.jpa.hibernate.ddl-auto = none
````

* Add the below plugin to your **pom.xml**

````xml
<plugin>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-maven-plugin</artifactId>
    <version>8.5.13</version>
</plugin>
````

* Add the flyway.config file in the rood directory of your project

````text
flyway.user = <db_user_name>
flyway.password = <password>
flyway.schemas = <schema_name>
flyway.url = <db_url>
flyway.locations = filesystem: <db/migration folder path> 
````

Note: add all your migration script to db/migration folder in the resources directory

* Script can be run with 2 ways:
    1) Run **Main** Method:

       ````properties
       #add this to your application.properties
       spring.flyway.baseline-on-migrate = true
       spring.flyway.enabled=true
       ````

    2) Run using **Terminal**:
        ````shell
        # This will run all the migration script       
        mvn flyway:migrate
        ````

## Naming Convention:

Migrations can either be versioned or repeatable

### Versioned:

````text
V<number>__<file_name>.sql
eg: V1__createTable.sql
````

### Repeatable:

````text
R__<file_name>.sql
eg: R__modifyColumn.sql
````

## Note
* Once versioned script is executed we should not modify that script.
* Create a new script file instead of modifying the current one.
* If already know that the script can be modified in the future create a Repeatable script

## Important Commands:

````shell
# Run migration script
mvn flyway:migrate

# Get current status 
mvn flyway:info

# Repairs metadata table.
mvn flyway:repair

# Baselines an existing database
mvn flyway:baseline

# Validates current database schema against available migrations.
mvn flyway:validate

#  Drops all objects in a configured schema. Of course, we should never use clean on any production database.
mvn flyway:clean
````

## Resources
- [Flyway docs](https://documentation.red-gate.com/fd?_ga=2.260545674.647223963.1695809865-886168606.1695809865)
- [database-migrations-with-flyway](https://www.baeldung.com/database-migrations-with-flyway)