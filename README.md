#  BASF QA Web Automation Code Challenge

## Tool Stack
The selected framework is SerenityBDD http://www.thucydides.info/.

> Serenity BDD helps you write cleaner and more maintainable automated acceptance and regression tests faster. Serenity also uses the test results to produce illustrated, narrative reports that document and describe what your application does and how it works.

Under the hood, Serenity provides you out-of-the-box reporting capabilities and support for writing BDD scenarios with Gherkin that will run under Cucumber. 
The programming language of election is Java,  one of the most spread languages in test automation projects.
Serenity also offers integration with Selenium, the most widely used framework for Web browser test automation.

## How to deploy and run the tests

**Preconditions**
-------------  
You should have installed the driver(s) corresponding to the browser(s) you want to run the tests with.  
  
By default, they're expected to be located at /usr/local/bin/  
  
If you want to change the default path, please, edit the corresponding .properties file inside browserProfiles folder.  
  
**Execution instructions**
-------------  

  
For running your tests the only thing you should do is downloading the test project from the provided repo.  
  
Then you should be able to run the automated tests just by typing from the directory you downloaded the tests:  
  
* Linux/Mac:  
  
    ./gradlew clean test aggregate -Dproperties={browserProfile} (-Dcucumber.options="--tags @tag")  
  
* Windows:  
  
    gradlew.bat clean test aggregate -Dproperties={browserProfile} (-Dcucumber.options="--tags @tag")"  
  
{browserProfile} Should be the name of one .properties file inside browserProfiles folder  
Provided ones are:  
* browserProfiles/serenityChrome.properties  
* browserProfiles/serenityFirefox.properties  
  
You could create your own including a new properties file in this folder for the browser you want (e.g. Safari).  
  
(-Dcucumber.options="--tags @tag") is optional and will allow you to run a subset of tests. If not specified all the tests will be run  
  
Available tags are:  
* @login  
* @search  

**Command line examples**
-------------  
./gradlew clean test aggregate -Dproperties=browserProfiles/serenityChrome.properties  
  
./gradlew clean test aggregate -Dproperties=browserProfiles/serenityChrome.properties -Dcucumber.options="--tags @search"

## Expected output

After finishing, you should be able to open the report file and analyse the results  
  
./target/site/serenity/index.html  

## Found issues

While exploring and automating the provided web at https://qknows-qa.basf.com I found some issues that I'd report as bugs to be reviewed.

* **Severity**: Major. **Priority**: Medium
You're asked to accept Terms of use every single time you navigate to home page what affects the UX (Usability) of the system and difficults the automation of the tests.

* **Severity**: Blocker. **Priority**: High
After performing a search, if you click in 'View Full Text' icon in any of the response entries you get error 

> **This site can’t be reached**
> 
> cipros.basf-ag.de’s server IP address could not be found.

* **Impediment**:
Even though tests are ready to be run with different browsers, when trying to run them in Firefox "search" test is not working and I'm getting this error
> "ElementNotInteractableException: Element could not be scrolled into view"

If you google this error, you can find it's been reported many times and there's  an open bug in bugzilla.  Opened  4 years ago  Updated  2 months ago

> OPEN bug https://bugzilla.mozilla.org/show_bug.cgi?id=1374283 