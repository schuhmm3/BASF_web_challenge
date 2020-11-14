# BASF QA Automation Web Code Challenge

Preconditions
-------------
You should have installed the driver(s) corresponding to the browser(s) you want to run the tests with.

By default, they're expected to be located at /usr/local/bin/

If you want to change the default path, please, edit the corresponding .properties file inside browserProfiles folder.

Execution Instructions
----------------------
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

After finishing, you should be able to open the report file and analyse the results

./target/site/serenity/index.html

Commannd line examples
----------------------
./gradlew clean test aggregate -Dproperties=browserProfiles/serenityChrome.properties

./gradlew clean test aggregate -Dproperties=browserProfiles/serenityChrome.properties -Dcucumber.options="--tags @search"

