**Anagrams** is a project that finds anagrams of words or sentences in a list of words
read from one or more files.

Assumptions:

Corner cases:

* One word/sentence is null.
* One word/sentence is empty.
* One word/sentence is blank.
* One word/sentence has only one character.
* Words/sentences have the same characters in the same order.
* The provided folder does not exist.

Happy path:

* Words/sentences have the same letters in different order independently of the case
  and ignoring blank spaces.
* If the provided path contains several files, their content will be read as one file.
* Words/sentences in the files will be separated by a line separator.


Technical information:

The application runs on Java 11 and Maven.

### How to run the application

* From a terminal:

From the root of the project *recruiting-sara-cabrera*, run
  ```
  mvn clean package
  ```
  This will generate anagramsFinder-0.0.1-SNAPSHOT.jar file in target folder.
  Then you can run
  ```
  java -jar target/anagramsFinder-0.0.1-SNAPSHOT.jar path/to/dictionaries/folder
  ```
* Run Configuration in IntelliJ: 

Create a run configuration from Run -> Edit Configurations -> + -> Application

  * In name add: Application  
  * In main class add: com.exercise.anagrams.Application
  * In Program Arguments add the path to the folder with the dictionaries.
  * Then you can go to Run -> Run 'Application'