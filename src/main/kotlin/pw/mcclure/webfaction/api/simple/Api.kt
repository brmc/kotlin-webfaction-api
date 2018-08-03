package pw.mcclure.webfaction.api.simple

import pw.mcclure.webfaction.client.RpcAdapter
import pw.mcclure.webfaction.client.WebfactionRpc

open class Api(
    val rpc: RpcAdapter = WebfactionRpc(),
    internal var sessionId: String = ""
) {
    fun call(method: String, vararg params: Any) =
        rpc.call(method, sessionId, *params)
}
