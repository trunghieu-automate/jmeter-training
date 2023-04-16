# Sample code for Junit request sample

## Design note
- Using intellij
- Build jar file by `mvn package` -> check ***output*** folder
- Everything should be thread-safe and synchronized cause Jmeter is parallel run in nature. 
- Properties reader class take config.properties file (copy file to jmeter's bin folder).
- Custome @Rule to read csv file.
- Handle Jmeter Context API for manipulate Jmeter defined variable. 

## TODO:
- add Page Object model design pattern
