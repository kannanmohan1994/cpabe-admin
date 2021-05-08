# cpabe-admin

**A GUI based application for Access Control Management in Patient Health Record System.** 

**To run this application you must follow the below procedures:**
1. Install Eclipse IDE
2. Install maven software inside eclipse to install dependencies provided in pom.xml
3. XAMPP software for mySQL database (Storing data) and PHPmyAdmin (For easy DB Management)
4. Once all the above are installed clone this project in your system. 
5. Use the cpabe.sql file inside the project folder to import database structure. 
   For importing just go to https://localhost/phpmyadmin/ and then press import and chose the cpabe.sql file 
6. Run pom.xml file to download and install dependencies. 
7. Run the LoginFrame.java as Java Application in Eclipse.

**Functionalities of Admin app:**
1. Add a patient/doctor.
2. View all patients/doctor in system.
3. Add a policy for doctor through a UI guided system.
4. Add a custom policy for doctor/patient. 
   Custom policy is made mainly for the purpose where a patient needs to view another patient's file (Very rare case) or 
   any other complicated policy structure that can't be achieved by UI guided policy generator system. The syntax for a policy is as follows:
   Requestor attributes: <attribute1><space><attribute2><space>... Requestor attribute will be of structure p:abc / d:abc (p for patient, d for doctor)
   Resource attributes: <attribute1><space><attribute2><space>... Resource attribute will be of structure phr:abc
   Action attributes: <attribute1><space><attribute2><space>... Action attribute can be a:view, a:edit. 
5. Delete existing policy.
6. View all policies in system.

Another application for the user (doctor/patient) will be build following this application. That application will focus on permitting access based on the policies that are written by admin through the ADMIN app. The application is build in the following repository:

https://github.com/kannanmohan1994/cpabe-user
