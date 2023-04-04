# Download & setup Apache Jmeter
### System requirements: 
[source-1](https://jmeter.apache.org/usermanual/get-started.html)


- Java Version: JMeter requires a fully compliant JVM 8 or higher. You can download and install the latest version of Java SE Development Kit from Oracle page
- Operating Systems: JMeter is a 100% Java application and should run correctly on any system that has a compliant Java implementation14. However, you may need to adjust some settings such as machine sizing, OS tuning, and Java heap size depending on your test plan and load scenario4.
- Optional: If you plan on doing JMeter development or using some advanced features, then you may need some optional packages such as Java Compiler, SAX XML Parser, Email Support, SSL Encryption, JDBC Driver, etc1. You can find more details on these packages and how to install them in the JMeter Classpath section of the user manual.

### Setup guide:
Here are the steps to install Apache JMeter on `Windows`:

1. Download the latest version of Apache JMeter from the [official website](https://jmeter.apache.org/download_jmeter.cgi). You can choose either a zip or a tar file depending on your preference.
2. Extract the downloaded file to a folder of your choice. For example, C:\JMeter.
3. Make sure you have Java installed on your system. You can either use JRE or JDK. You can check your Java version by opening a command prompt and typing java -version. If you don’t have Java, you can download it from here.
4. Go to the bin folder inside your JMeter installation directory. For example, C:\JMeter\bin.
5. Double-click on the jmeter.bat file to launch JMeter in GUI mode.
6. You can now start building your test plan by adding elements such as thread groups, samplers, listeners, etc. For more details on how to use JMeter, you can refer to the [user manual](https://jmeter.apache.org/usermanual/get-started.html).
