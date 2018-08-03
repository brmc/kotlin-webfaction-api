package pw.mcclure.webfaction.api.simple

import pw.mcclure.webfaction.client.RpcAdapter
import pw.mcclure.webfaction.client.WebfactionRpc

/**
 * CRUD operations for websites
 *
 * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#websites>
 */
class WebsiteApi(rpc: RpcAdapter = WebfactionRpc(), sessionId: String = "") :
    Api(rpc, sessionId) {
    fun create(
        website_name: String,
        ip: String,
        https: Boolean,
        subdomains: List<String>,
        certificate: String,
        siteApps: List<List<String>>
    ) =
        call(
            "create_website",
            website_name, ip, https, subdomains, certificate, siteApps
        )

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-delete_website>
     */
    fun delete(websiteName: String, ip: String, https: Boolean) =
        call("delete_website", websiteName, ip, https)

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-list_bandwidth_usage>
     */
    fun listBandwidthUsage() = call("list_bandwidth_usage")

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-list_websites>
     */
    fun list() = call("list_websites")

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-update_website>
     */
    fun update(
        website_name: String,
        ip: String,
        https: Boolean,
        subdomains: List<String>,
        certificate: String,
        siteApps: List<List<String>>
    ) =
        call(
            "update_website",
            website_name, ip, https, subdomains, certificate, siteApps
        )
}
/*import "dart:async"

import "package:webfaction_api/src/api/api.dart"
import "package:webfaction_api/src/data/website.dart"

/// 
class WebsiteApi extends Api {
  WebsiteApi(sessionId: String, Function rpc) : super(sessionId, rpc)

  /**
* See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-create_website>
*/

  fun createFromInstance(Website website) = create(website.name, website.ip,
      website.https, website.subdomains, website.certificate, website.siteApps)

    fun deleteFromInstance(Website website) =
      delete(website.name, website.ip, website.https)


  fun updateFromInstance(Website website) = update(website.name, website.ip,
      website.https, website.subdomains, website.certificate, website.siteApps)
}
*/
