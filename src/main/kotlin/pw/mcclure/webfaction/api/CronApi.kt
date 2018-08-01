package pw.mcclure.webfaction.api

import pw.mcclure.webfaction.client.RpcAdapter
import pw.mcclure.webfaction.client.WebfactionRpc

class CronApi(sessionId: String, rpc: RpcAdapter = WebfactionRpc()) :
    Api(sessionId, rpc) {
    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-create_cronjob>
     */
    fun create(line: String) = call("create_cronjob", line)

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-delete_cronjob>
     */
    fun delete(line: String) = call("delete_cronjob", line);
}