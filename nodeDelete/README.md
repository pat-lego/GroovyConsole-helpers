# A Helper Utility to Delete Nodes

This is a helper utility that can delete nodes in the JCR Oak-Run console. I took the code from https://gist.github.com/stillalex/43c49af065e3dd1fd5bf and modified it to run over a JSON object

## How it works

1. Identify the oak-core version that is being used in your AEM instance and download the oak-run.jar dependency from the mvn repo
2. Run java -jar oak-run-\*.jar console /path/to/segmentstore 
3. Once in the console load the script by using `:load /path/to/the/rmNode.groovy` script
4. Modify the config.json file to contain all the nodes you would like to delete from the CRX/DE
5. Execute rmNode(session, '/path/to/the/config.json')

## Contributor

[Patrique Legault](https://twitter.com/_patlego)
 
