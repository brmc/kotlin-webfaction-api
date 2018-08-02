package pw.mcclure.webfaction.api

import pw.mcclure.webfaction.client.RpcAdapter
import pw.mcclure.webfaction.client.WebfactionRpc

class DomainApi(rpc: RpcAdapter = WebfactionRpc(), sessionId: String = "") :
    Api(rpc, sessionId) {

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-create_domain>
     */
    fun create(domain: String, subdomains: Array<String>) =
        call("create_domain", domain, *subdomains)

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-delete_domain>
     */
    fun delete(name: String, subdomains: Array<String>) =
        call("delete_domain", name, *subdomains)

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-list_domains>
     */
    fun list() = call("list_domains");
}

/**
 * import 'dart:async';

import 'package:webfaction_api/src/api/api.dart';
import 'package:webfaction_api/src/data/domain.dart';

/// Create, list, and delete domains
///
/// See <https://docs.webfaction.com/xmlrpc-api/apiref.html#domains>
class DomainApi extends Api {
DomainApi(String sessionId, [Function rpc]) : super(sessionId, rpc);


Future createFromInstance(Domain domain) =>
create(domain.domain, domain.subdomains);

Future deleteFromInstance(Domain domain) =>
delete(domain.domain, domain.subdomains);


 */
