package pw.mcclure.webfaction.api

import pw.mcclure.webfaction.client.RpcAdapter
import pw.mcclure.webfaction.client.WebfactionRpc

open class Api(val sessionId: String, val rpc: RpcAdapter = WebfactionRpc()) {
    fun call(method: String, vararg params: Any) =
        rpc.call(method, sessionId, *params)
}
