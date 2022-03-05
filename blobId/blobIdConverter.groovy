import java.io.FileWriter

def convertBlobIds(inputFile, outputFile) {
    def regex = ~/^([a-z0-9]{2})([a-z0-9]{2})([a-z0-9]{2})([a-z0-9]+)\#\d+$/

    String[] orgBlobIds = new File(inputFile).text.readLines()
    List<String> convertedBlobIds = []

    for (blobId in orgBlobIds) {
        if ((match = blobId =~ regex)) {
            convertedBlobIds.add("${match.group(1)}/${match.group(2)}/${match.group(3)}/${match.group(1)}${match.group(2)}${match.group(3)}${match.group(4)}")
        }
    }

    FileWriter writer = new FileWriter(outputFile)
    for (String str: convertedBlobIds) {
        writer.write(str + System.lineSeparator())
    }
    writer.close()
}

convertBlobIds(args[0], args[1])
