package pw.mcclure.webfaction.api.simple

import pw.mcclure.webfaction.client.RpcAdapter
import pw.mcclure.webfaction.client.WebfactionRpc

open class AppApi(rpc: RpcAdapter = WebfactionRpc(), sessionId: String = "") :
    Api(rpc, sessionId) {
    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-create_app>
     *
     * Application [type]s can be found with the [listTypes] method
     */
    fun create(
        name: String,
        type: String,
        autostart: Boolean = false,
        extraInfo: String = "",
        openPort: Boolean = false
    ) = call(
        "create_app",
        name,
        type,
        autostart,
        extraInfo,
        openPort
    ) as HashMap<*, *>

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-delete_app>
     */
    fun delete(name: String) = call("delete_app", name) as Array<*>

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-list_apps>
     */
    fun list() = call("list_apps") as Array<*>

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-list_app_types>
     */
    fun listTypes() = call("list_app_types") as Array<*>
}

/*

App.fromMap(Map data )
{
    id = data['id'];
    name = data['name'];
    type = data['type'];
    autostart = data['autostart'];
    port = data['port'];
    openPort = data['open_port'];
    extraInfo = data['extra_info'];
    machine = data['machine'];
}
}
*/

/*
import 'package:webfaction_api/src/api/app.dart';

/// See [AppApi]
class App {
  num id;
  String name;
  String type;
  Boolean autostart;
  num port;
  Boolean openPort;
  String extraInfo;
  String machine;

  App(this.name, this.type,
      [this.autostart = false, this.extraInfo = '', this.openPort = false]);

  App.fromMap(Map data) {
    id = data['id'];
    name = data['name'];
    type = data['type'];
    autostart = data['autostart'];
    port = data['port'];
    openPort = data['open_port'];
    extraInfo = data['extra_info'];
    machine = data['machine'];
  }
}

class AppType {
  String name;
  String label;
  String description;

  // Webfaction returns a string here
  String autostart;
  String extraInfo;
  Boolean openPort;

  AppType(
    this.name,
    this.label,
    this.description,
    this.autostart,
    this.openPort,
    this.extraInfo,
  );

  AppType.fromMap(data) {
    name = data['name'];
    label = data['label'];
    description = data['description'];
    autostart = data['autostart'];
    openPort = data['open_port'];
    extraInfo = data['extra_info'];
  }
}
        */