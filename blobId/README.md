# A script to convert Blob IDs

You can use this script to convert missing blob Ids from the error.log to the path to where the blob is missing in your blob store.

This will help you locate the blob in another oak repository so that you can restore it.

## How it works

1. Run the necessary script from Andrew Khoury - https://gist.github.com/andrewmkhoury/080d9e53dfed5115b90df9f5b06521fe which will show any missing blobs
2. Document those Ids and then put them in a file seperated by `/n` characters
3. Run groovy blobIdConverter.groovy /path/to/the/inputFile /path/to/the/outputFile

The input file contains all of the blobIds seperated by a `\n` character and the output file is the location to where the output of the converted content is written 

## Contributor

[Patrique Legault](https://twitter.com/_patlego)
