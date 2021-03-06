package pw.mcclure.webfaction.api.simple

import pw.mcclure.webfaction.client.RpcAdapter
import pw.mcclure.webfaction.client.WebfactionRpc

/**
 *  List disc usage.
 *
 *  (The login command has been moved to [Client][pw.mcclure.webfaction.client.Client])
 */
class GeneralApi(rpc: RpcAdapter = WebfactionRpc(), sessionId: String = "") :
    Api(rpc, sessionId) {

    /**
     *  See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-list_disk_usage>
     */
    fun listDiskUsage() = call("list_disk_usage")
}
