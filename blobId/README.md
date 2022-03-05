# A script to convert Blob IDs

You can use this script to convert missing blob Ids from the error.log to the path to where the blob is missing in your blob store.

This will help you locate the blob in another oak repository so that you can restore it.

## How it works

1. Identify the oak-core version that is being used in your AEM instance and download the oak-run.jar dependency from the mvn repo
2. Run java -jar oak-run-\*.jar console /path/to/segmentstore ":load /path/to/the/blobIdConverter.groovy inputFile outputFile"

The input file contains all of the blobIds seperated by a `\n` character and the output file is the location to where the output of the converted content is written 

## Contributor

[Patrique Legault](https://twitter.com/_patlego)
