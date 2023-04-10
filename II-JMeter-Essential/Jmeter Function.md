# [Jmeter Function](https://jmeter.apache.org/usermanual/functions.html)

## Introduce Jmeter's Function

Jmeter Functions are special values that can populate fields of any Sampler or other element in a test tree. They can be used to perform calculations, manipulate strings, read files, generate random data, and more.

### Syntax and common notes
A function call looks like this:
```ts
${__functionName(var1,var2,var3)}
```
- "__functionName" match the name of function
- (var1,var2,var3): function's params. They depends on each function. Some function have no param, example: 
```js
${__threadNum} //which return thread number
```

- If a function parameter contains a comma, then be sure to escape this with "\", otherwise JMeter will treat it as a parameter delimiter. For example:
```js
${__time(EEE\, d MMM yyyy)}
```
- Variables are referenced as follows:
```js
${VARIABLE}
```
- If an undefined function or variable is referenced, Jmeter does not report an error but returns the reference unchanged3. For example: 
```js
$ {UNDEF} returns $ {UNDEF}
```
- Variables, functions, and properties are all case-sensitive. For example: 
```js 
${__Random (1,63, LOTTERY )} is not the same as ${__random (1,63, lottery )}
```
- You need to escape any backslash before a variable with another backslash otherwise Jmeter will not interpret the variable. For example: 
```js
C:\\test\\$ {test}
```
- `Properties` are not the same as `variables`. Variables are `local to a thread`; properties are common to `all threads`, and need to be referenced using the __P or __property function.
- Note that `variables cannot currently be nested`. i.e. `${Var${N}}` does not work. The `__V` (variable) function can be used to do this: `${__V(Var${N})}`. You can also use `${__BeanShell(vars.get("Var${N}")}`.
- Functions are shared between threads. Each occurrence of a function call in a test plan is handled by a separate function instance.
- When using variable/function references in SQL code (etc.), remember to include any necessary quotes for text strings, i.e. use
```SQL query
SELECT item from table where name='${VAR}'
not
SELECT item from table where name=${VAR}
(unless VAR itself contains the quotes)
```
## List of Function (Jmeter 5.5)

|Type of function |	Name	| Comment |
|-|-|-|
|Information|	[threadNum](https://jmeter.apache.org/usermanual/functions.html#__threadNum)|	get thread number|
|Information|	threadGroupName|	get thread group name|
|Information|	samplerName|	get the sampler name (label)|
|Information|	machineIP|	get the local machine IP address|
|Information|	machineName|	get the local machine name|
|Information|	time|	return current time in various formats|
|Information|	timeShift|	return a date in various formats with the specified amount of seconds/minutes/hours/days added|
|Information|	log|	log (or display) a message (and return the value)|
|Information|	logn|	log (or display) a message (empty return value)|
|Input|	StringFromFile|	read a line from a file|
|Input|	FileToString|	read an entire file|
|Input|	CSVRead|	read from CSV delimited file|
|Input|	XPath|	Use an XPath expression to read from a file|
|Input|	StringToFile|	write a string to a file|
|Calculation|	counter|	generate an incrementing number|
|Formatting|	dateTimeConvert|	Convert a date or time from source to target format|
|Calculation|	digest|	Generate a digest (SHA-1, SHA-256, MD5...)|
|Calculation|	intSum|	add int numbers|
|Calculation|	longSum|	add long numbers|
|Calculation|	Random|	generate a random number|
|Calculation|	RandomDate|	generate random date within a specific date range|
|Calculation|	RandomFromMultipleVars|	extracts an element from the values of a set of variables separated by `|` |
|Calculation|	RandomString|	generate a random string|
|Calculation|	UUID|	generate a random type 4 UUID|
|Scripting|	groovy|	run an Apache Groovy script|
|Scripting|	BeanShell|	run a BeanShell script|
|Scripting|	javaScript|	process JavaScript (Nashorn)|
|Scripting|	jexl2|	evaluate a Commons Jexl2 expression	jexl2|
|Scripting|	jexl3|	evaluate a Commons Jexl3 expression	jexl3|
|Properties|	isPropDefined|	Test if a property exists	|
|Properties| property|	read a property	|
|Properties|	P	|read a property (shorthand method)|
|Properties|	setProperty	|set a JMeter property|
|Variables|	split	|Split a string into variables|
|Variables|	eval	|evaluate a variable expression|
|Variables|	evalVar |evaluate an expression stored in a variable|
|Properties|	isVarDefined|	Test if a variable exists|
|Variables|	V	|evaluate a variable name	2.3RC3|
|String|	char	|generate Unicode char values from a list of numbers|
|String|	changeCase	|Change case following different modes|
|String|	escapeHtml	|Encode strings using HTML encoding	|
|String|	escapeOroRegexpChars|	quote meta chars used by ORO regular expression|
|String|	escapeXml	|Encode strings using XMl encoding|
|String|	regexFunction|	parse previous response using a regular expression|
|String|	unescape	|Process strings containing Java escapes (e.g. \n & \t)	|
|String|	unescapeHtml|	Decode HTML-encoded strings	|
|String|	urldecode	|Decode a application/x-www-form-urlencoded string	|
|String|	urlencode	|Encode a string to a application/x-www-form-urlencoded string	|
|String|	TestPlanName|	Return name of current test plan	|

## [Where](https://jmeter.apache.org/usermanual/functions.html#where) can functions and variables be used?
- Functions and variables can be written into any field of any test component.
- Functions which are used on the Test Plan have some restrictions. JMeter thread variables will have not been fully set up when the functions are processed, so variable names passed as parameters will not be set up, and variable references will not work, so split() and regex() and the variable evaluation functions won't work. The threadNum() function won't work (and does not make sense at test plan level).The following functions should work OK on the test plan:
- intSum, longSum, machineName, BeanShell, groovy, javaScript, jexl2/jexl3, random, time, property functions, log functions.
- Configuration elements are processed by a separate thread. Therefore functions such as __threadNum do not work properly in elements such as User Defined Variables.
- Variables defined in a UDV element are not available until the element has been processed.


## [The Function Helper Dialog](https://jmeter.apache.org/usermanual/functions.html#function_helper)
![Helper](https://jmeter.apache.org/images/screenshots/function_helper_dialog.png)

Using the Function Helper, you can select a function from the pull down, and assign values for its arguments. The left column in the table provides a brief description of the argument, and the right column is where you write in the value for that argument. Different functions take different arguments.

## Mostly used function in Load testing?

There are many Jmeter functions that can be useful for load testing, depending on your test scenario and requirements. Some of the common ones are:

- `__Random`: Generate a random number within a specified range1. For example: $ {__Random (1,100,RAND)} will generate a random number between 1 and 100 and store it in the variable RAND.
- `__RandomString`: Generate a random string of a specified length1. For example: $ {__RandomString (10,abcdefg,RANDSTR)} will generate a random string of 10 characters from the set abcdefg and store it in the variable RANDSTR.
- `__CSVRead`: Read from a CSV delimited file1. For example: $ {__CSVRead (test.csv,0)} will read the first column of the test.csv file and return the value. This can be used to parameterize your test with data from external sources.
- `__counter`: Generate an incrementing number1. For example: $ {__counter (TRUE,COUNT)} will generate a number that increases by 1 for each iteration and store it in the variable COUNT. This can be used to create unique identifiers or sequential requests.
- `__time`: Return current time in various formats1. For example: $ {__time (yyyy-MM-dd HH:mm:ss)} will return the current time in the format 2023-04-09 19:27:11. This can be used to create timestamps or measure response times.
- `__log`: Log (or display) a message (and return the value)1. For example: $ {__log (Hello World)} will log the message Hello World in the Jmeter log file and return Hello World. This can be used to debug your test script or display some information.



