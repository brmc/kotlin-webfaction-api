package pw.mcclure.webfaction.api

import pw.mcclure.webfaction.client.RpcAdapter
import pw.mcclure.webfaction.client.WebfactionRpc


class DnsApi(rpc: RpcAdapter = WebfactionRpc(), sessionId: String = "") :
    Api(rpc, sessionId) {

    /**
     * See https://docs.webfaction.com/xmlrpc-api/apiref.html#method-create_dns_override
     */
    fun createOverride(
        domain: String,
        aIp: String = "",
        cname: String = "",
        mxName: String = "",
        mxPriority: String = "",
        spfRecord: String = "",
        aaaaIp: String = "",
        srvRecord: String = ""
    ) = call(
        "create_dns_override", domain,
        aIp,
        cname,
        mxName,
        mxPriority,
        spfRecord,
        aaaaIp,
        srvRecord
    )

    fun deleteOverride(
        domain: String,
        aIp: String = "",
        cname: String = "",
        mxName: String = "",
        mxPriority: String = "",
        spfRecord: String = "",
        aaaaIp: String = "",
        srvRecord: String = ""
    ) = call(
        "delete_dns_override",
        domain,
        aIp,
        cname,
        mxName,
        mxPriority,
        spfRecord,
        aaaaIp,
        srvRecord
    )

    /**
     * See https://docs.webfaction.com/xmlrpc-api/apiref.html#method-list_dns_overrides
     */
    fun listOverrides() = call("list_dns_overrides")
}

/**
import "dart:async"

import "package:webfaction_api/src/data/dns.dart"

import "api.dart"

/// Create, list, and delete DNS overrides
///
/**
 * See /**
 * https://docs.webfaction.com/xmlrpc-api/apiref.html#dns
*/
*/
class DnsApi extends Api {
DnsApi(sessionId: String, Function rpc) : super(sessionId, rpc)


fun createOverrideFromInstance(DnsOverride obj) => createOverride(
obj.domain,
obj.aIp,
obj.cname,
obj.mxName,
obj.mxPriority,
obj.spfRecord,
obj.aaaaIp,
obj.srvRecord)

/**
 * See /**
 * https://docs.webfaction.com/xmlrpc-api/apiref.html#method-delete_dns_override
*/
*/

fun deleteOverrideFromInstance(DnsOverride obj) => deleteOverride(
obj.domain,
obj.aIp,
obj.cname,
obj.mxName,
obj.mxPriority,
obj.spfRecord,
obj.aaaaIp,
obj.srvRecord)


 */