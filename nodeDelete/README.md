# A Helper Utility to Delete Nodes

This is a helper utility that can delete nodes in the JCR Oak-Run console. I took the code from https://gist.github.com/stillalex/43c49af065e3dd1fd5bf and modified it to run over a JSON object

## How it works

1. Identify the oak-core version that is being used in your AEM instance and download the oak-run.jar dependency from the mvn repo
2. Run java -jar oak-run-\*.jar console /path/to/segmentstore 
3. Once in the console load the script by using `:load /path/to/the/rmNode.groovy` script
4. Modify the config.json file to contain all the nodes you would like to delete from the CRX/DE
5. Execute rmNode(session, '/path/to/the/config.json')

Note: That this script can use Google GSON but as of now is built with GSON 2.8.0 this is because of how oak-run is built it includes its dependencies within the JAR (https://github.com/apache/jackrabbit-oak/blob/trunk/oak-run/src/main/assembly/oak-run.xml#L29-L56) which includes GSON 2.8.0 (https://github.com/apache/jackrabbit-oak/blob/trunk/oak-run/pom.xml#L367-L371). If you would ever like to include other JARs within the scope of oak-run you can add dependencies to the POM and run a build in order to get other libs availabe at runtime of oak-run.

## Contributor

[Patrique Legault](https://twitter.com/_patlego)
 
