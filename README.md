# tri_point API

환경(Environments)
---
- JDK(Java version) : Open jdk 8(zule 8)
- STS(Spring Tool Suite) : sts-3.9.14.RELEASE
- Spring-Boot-Starter : Spring-Boot-Starter 2.6.7
- MySQL : MySQL Community Servcer 8.0.29


애플리케이션 실행(Excute Application)
---
### 1. 파일 다운받기
- git clone https://github.com/Chaaany/tri_point.git [원하는 directory] 실행
- 또는 zip 파일로 다운 받은 후 압축 풀기

### 2. DB Table 생성
- /tri_point/src/main/resources/database/tripledb.sql 실행하여 DB Table 생성

### 3. Dump data import
- /tri_point/src/main/resources/database/dump/triple_attachedphoto.sql 
- /tri_point/src/main/resources/database/dump/triple_place.sql 
- /tri_point/src/main/resources/database/dump/triple_point.sql 
- /tri_point/src/main/resources/database/dump/triple_review.sql 
- /tri_point/src/main/resources/database/dump/triple_user.sql 
- 실행하여 dump data 생성

### 4. Spring boot application.properties 환경 설정
- tri_point/src/main/resources/application.properties 파일 내용 변경
- PORT 설정 : server.port=[원하는 port 번호 - 현재 9999]
- DB login ID 설정 : spring.datasource.username=[database root 사용자 명 - 현재 triple]
- DB login PASSWORD 설정 : spring.datasource.password=[database root 비밀번호 - 현재 triple]
![image](https://user-images.githubusercontent.com/34885297/175756456-dcad0265-0d53-458f-9ed6-e58e7e957d5a.png)

### 5. Spring boot 실행
- ./mvnw spring-boot:run
- 또는 STS에서 Spring Starter Project 생성 후 애플리케이션 실행
- (프로젝트 생성시 Dependencies 설정 및 Spring Boot Version 설정 없음 - pom.xml로 처리)
![image](https://user-images.githubusercontent.com/34885297/175756442-280f9d5b-3242-4be5-b673-6dbb0f24aa98.png)
![image](https://user-images.githubusercontent.com/34885297/175756526-e49c1416-d5ee-4efc-99e1-cf0bdf8f1a9c.png)

![image](https://user-images.githubusercontent.com/34885297/175756517-ed5fb11b-ea84-4bed-ac32-ac5ebc826a43.png)



### 6. Swagger API 사용 
- http://localhost:[application.properties상 설정한 번호 - 현재 9999]/swagger-ui/index.html 접속
![image](https://user-images.githubusercontent.com/34885297/175756480-a07734e1-a154-484b-aa58-afc326d9aff7.png)
![image](https://user-images.githubusercontent.com/34885297/175756588-4242c46c-ffd5-4193-860e-ff398e539dbd.png)
- main-controller 클릭 후 try it out - Excute - parameter 필요시 Example Value에 맞게 입력 (해당 sample 코드로는 이미 point 부여 된 상태)
![image](https://user-images.githubusercontent.com/34885297/175756625-2b374647-c507-4eb7-a330-c09578c10fe0.png)

### 7. application Testing
- \TripleApi\src\test\java\com\triple\service에서 JUNit 실행 또는 Swagger에서 create data 후 POST/events api 호출
![image](https://user-images.githubusercontent.com/34885297/175756641-062ce4ac-b613-485c-a259-8821f9daa725.png)







