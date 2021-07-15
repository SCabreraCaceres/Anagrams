Zooplus Coding Exercise - Anagrams
==================================

Instructions
------------

An anagram is a word or sentence that can be rearranged to create another one, like LISTEN can be turn to SILENT, or RECITALS can turn into ARTICLES.

The purpose is to implement a command line application to match the longest anagram version of a given sentence.
To run the application it will be something like:

```
java -cp <some_class_path> <class_name> <pathToDirectoryWithTextFiles>

scala -classpath <some_class_path> <class_name> <pathToDirectoryWithTextFiles>

groovy [-cp <some_class_path>] <script_file> <pathToDirectoryWithTextFiles>
```
Anyway is not needed to follow this structure to run the app, just let us know how to run it.

When this is run, the application should read one or more text files from the given directory that would work as dictionaries, map them somehow, and give a prompt to interact with it, so words or sentences can be used to search for anagrams.

Example (does not have to match your solution):
```$bash/ java -cp . org.awesome.App /some/dir
matchFor>
matchFor> Astronomer
Longest anagram is... ‘Moon starer’
matchFor> Statue of Liberty
Longest anagram is...’Built to stay free’
matchFor> We
Longest anagram is... not found here
```
You can implement a method using the following signature:

``` String searchAnagram(String word) ```

### Must have
* The application must run and work correctly.
* The application must have unit tests to prove that it works.
* Commit history. In order to know how you work, we would like to have your commit history.

### Things to consider before starting
* What is the minimum anagram acceptable?
* How two words/sentence can be anagram of each other?
* Data structure design: how are we gonna search for anagrams? 
* How are you going to test it?
* How to build the app

### How to proceed
* You can create a branch in this repository to develop your solution.
* Include a solution.md file with all the relevant information for the result, such as assumptions or how to build and run the application.
* Create a PR to the repo with your solution

### Important
* You can make your own assumptions to solve the problem. Please indicate them in the solution.md file.
* If you have any doubts about the problem or something that you would like us to clarify, please feel free to contact us.
