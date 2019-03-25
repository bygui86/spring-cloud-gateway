
# Spring Cloud Gateway sample projects

## Sub-projects

* [Spring Cloud Gateway](spring-cloud-gateway)
* [Service A](service-a)
* [Service B](service-b)
* [Person Service](person-service)
* [Address Service](address-service)

---

## Run

1. Start service-a
	```
	cd ./service-a
	mvnw clean spring-boot:run
	```

2. Start service-b
	```
	cd ./service-b
	mvnw clean spring-boot:run
	```

3. Start person service
	```
	cd ./person-service
	mvnw clean spring-boot:run
	```

4. Start address service
	```
	cd ./address-service
	mvnw clean spring-boot:run
	```

5. Start gateway
	```
	cd ./spring-cloud-gateway
	mvnw clean spring-boot:run
	```

---

## TODOs

* reactive gateway
* reactive services
