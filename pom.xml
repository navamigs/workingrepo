<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://ma... http://maven.apache.org/xsd/maven-4.0.0.xsd">
   <modelVersion>4.0.0</modelVersion>
   <groupId>com.easy</groupId>
   <artifactId>mavenparameterize</artifactId>
   <version>0.0.1-SNAPSHOT</version>
   <name>My Maven Project</name>
   <description>This is a simple Maven Project</description>
   <properties>
      <jre.level>1.8</jre.level>
      <jdk.level>1.8</jdk.level>
   </properties>
   <build>
      <plugins>
         <!-- Compiler plug-in -->
         <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.5.1</version>
            <configuration>
               <source>${jdk.level}</source>
               <target>${jdk.level}</target>
            </configuration>
         </plugin>
         <!-- Added Surefire Plugin configuration to execute tests -->
         <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>2.19.1</version>
            <configuration>
               <suiteXmlFiles>
              <suiteXmlFile>patienttests.xml</suiteXmlFile>
               </suiteXmlFiles>
               <systemPropertyVariables>
                  <browserName>firefox</browserName>
               </systemPropertyVariables>
            </configuration>
         </plugin>
      </plugins>
   </build>
   <dependencies>
      <dependency>
         <groupId>org.testng</groupId>
         <artifactId>testng</artifactId>
         <version>6.9.8</version>
         <scope>test</scope>
      </dependency>
   </dependencies>
</project>
