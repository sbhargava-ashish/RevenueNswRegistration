This project can be used to Create person , vehicles and register them against each other.


Application port is 8088 in application.properties.

Project use Spring web and Spring data with in memory h2 database.

Application also has swagger configuration which can be accessed after application startup.

Swagger link : http://localhost:8088/swagger-ui.html


Add Person : Method POST : http://localhost:8088/person/add

Body :

```json
{
  "name" : "Ashish Bhargava",
  "age" : "30"
}
```

Add Vehicle : Method POST : http://localhost:8088/vehicle/add

Body :
```json
{
  "regoNumber" : "1234",
  "brand" : "Mazda2"
}
```

OR 
```json
{
  "regoNumber" : "1234",
  "brand" : "Mazda2",
  "personId" : "1"
}
```

Find All Person : Method GET : http://localhost:8088/person/findAll

Find All Vehicles : Method GET : http://localhost:8088/vehicle/findAll


Link Vehicle : Method PUT : http://localhost:8088/vehicle/link?regoNumber=1234&personId=2

Unlink Vehicle : Method PUT : http://localhost:8088/vehicle/unlink?regoNumber=1234&personId=2
