package pw.mcclure.webfaction.api.simple

import pw.mcclure.webfaction.client.RpcAdapter
import pw.mcclure.webfaction.client.WebfactionRpc

/**
 *  Write and edit files on your server
 *
 *  See <https://docs.webfaction.com/xmlrpc-api/apiref.html#files>
 */
class FileApi(rpc: RpcAdapter = WebfactionRpc(), sessionId: String = "") :
    Api(rpc, sessionId) {
    /**
     *  See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-replace_in_file>
     */
    fun replace(file: String, textToReplace: String, replacementText: String) =
        call("replace_in_file", file, textToReplace, replacementText)

    /**
     *  See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-write_file>
     */
    fun write(file: String, text: String, mode: String = "wb") =
        call("write_file", file, text, mode)
}
