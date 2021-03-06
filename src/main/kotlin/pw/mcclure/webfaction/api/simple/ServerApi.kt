package pw.mcclure.webfaction.api.simple

import pw.mcclure.webfaction.client.RpcAdapter
import pw.mcclure.webfaction.client.WebfactionRpc

/**
 *  List IPs and machines
 * 
 * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#servers>
 */
class ServerApi(rpc: RpcAdapter = WebfactionRpc(), sessionId: String = "") :
    Api(rpc, sessionId) {

    /**
     *  See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-list_ips>
     */
    fun listIps() = call("list_ips");

    /**
     *  See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-list_machines>
     */
    fun listMachines() = call("list_machines");
}