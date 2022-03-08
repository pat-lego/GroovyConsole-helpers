import org.apache.jackrabbit.oak.spi.commit.CommitInfo
import org.apache.jackrabbit.oak.spi.commit.EmptyHook
import org.apache.jackrabbit.oak.spi.state.NodeStore
import org.apache.jackrabbit.oak.spi.state.NodeBuilder
import org.apache.jackrabbit.oak.commons.PathUtils

import java.io.FileReader

import com.google.gson.JsonParser
import com.google.gson.JsonObject
import com.google.gson.JsonArray
import com.google.gson.JsonElement

def rmNode(def session, String filePath) {
    println "Reading file location ${filePath}"

    NodeStore ns = session.store
    NodeBuilder nb = ns.root.builder()

    
    JsonParser jParser = new JsonParser()
    JsonObject jObject = jParser.parse(new FileReader(filePath)).getAsJsonObject()

    JsonArray deleteNodes = jObject.get('delete').getAsJsonArray()
    Iterator<JsonElement> deleteItems = deleteNodes.iterator()

    Boolean rm = Boolean.TRUE

    while (deleteItems.hasNext()) {
        String path = deleteItems.next().getAsString()
        println "About to delete ${path}"
        NodeBuilder aBuilder = nb
        for (p in PathUtils.elements(path)) {  aBuilder = aBuilder.getChildNode(p) }

        if (aBuilder.exists()) {
            Boolean delete = aBuilder.remove()
            rm = rm && delete
            ns.merge(nb, EmptyHook.INSTANCE, CommitInfo.EMPTY)
        } else {
            rm = Boolean.FALSE
            println "Node ${path} doesn't exist"
        }
    }
    return rm
}
