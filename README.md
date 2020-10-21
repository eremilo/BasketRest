## rbaskets.in
для запуска тестов используете команду:
```mvnw clean test```

для запуска конкретного теста используете команду:
```mvnw test --tests <CreateBasket>```
####[Allure](http://allure.qatools.ru/)

для получения отчета Allure по пройденым тестам  используйте команды:
```mvnw allure:report```
```mvnw allure:serve```

Задача: 
- написать демо-проект по тестированию API на примере https://rbaskets.in

Технологический стэк:

- Java
- testNG https://testng.org/
- Rest Assured https://rest-assured.io
- Allure http://allure.qatools.ru