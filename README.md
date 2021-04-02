
 
# Phone Country API :
##### Sections :   
  * ##### About 
  * ##### Assumsion 
  * ##### Code Architecture : 
    * ###### BackEnd Architecture.  
    * ###### FrontEnd Architecture. 
 * ##### Test archture.  
 * ##### How to build  and run.
 * ##### Dockrize home Country API.
---

#### Assumsion:
As the data is small. I created the list static on the UI and create a Data util to provide me with the countey codes and the regex for each country.
For a large data I see that data should be on the database on table country of three Column.
|country_name|country_code|country_regex|
|---|---|---|
|Cameroon|+237|\(237\)\ ?[2368]\d{7,8}$|
Then render them on the page on load and when search join the country tale to complete the task .
here i decide to make it as simple and clean as i could.

### About: 
 **It's a Sring-boot application with Thymeleaf** 
**using spring-data-jpa and sqlite3 database  . You can filter using countrey and phone status Valid or Not Valid**

![](./onload-screenshoot.png)
 ![](./afterSearch-screenshoot.png)
### Code Architecture: 
![](./backEnd-architecture .png)
### Test Architecture: 
![](./backEnd-architecture .png)
#### How to build  and run:  
**Pull the project and create mvn clean instal :** 
  > git pull <repoURL> 
  <br/>
  > mvn clean install 
  
  Then run as a spring boot application then go to:
  localost:8090
  
#### Dockrize home Country Api:  
* **[Setup Docker on ubuntu](https://phoenixnap.com/kb/how-to-install-docker-on-ubuntu-18-04)** 
* **[Dockrize home Country Api .](https://medium.com./@wkrzywiec/how-to-put-your-java-application-into-docker-container-5e0a02acdd6b)**
    * *first build the project using maven* 
         > mvn clean install package 

    * *then go througth this [tutorial](https://medium.com./@wkrzywiec/how-to-put-your-java-application-into-docker-container-5e0a02acdd6b)* 

 

 
