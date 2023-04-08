## Demo testplan on [ecommerce.tealiumdemo.com](https://ecommerce.tealiumdemo.com/)

### Test plan definition

##### Simple register web load test plan

- Goal: To test the performance of the register functionality under normal conditions
- User population: maximum 200 users from different languages, using different browsers and devices.
- User scenario: The user navigates to the login page, enters a valid username and password, clicks on the login button, and then logs out.
- Workload model: a Steady state for 5 minutes.
- Metrics: Response time, throughput, errors.

##### run test:
cli: jmeter -n -t "Simple register function test plan.jmx" -l "register-report.jtl" -j "register-log.log" -e -o "path-to-empty-folder-for-html-report"

##### TODO:
- add more user scenarios
- use defined variable
- create plan with other work load model
- WDS integrattion for interact with web page
