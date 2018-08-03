package pw.mcclure.webfaction.api.simple

import pw.mcclure.webfaction.client.RpcAdapter
import pw.mcclure.webfaction.client.WebfactionRpc

class DbApi(rpc: RpcAdapter = WebfactionRpc(), sessionId: String = "") :
    Api(rpc, sessionId) {
    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-create_db>
     */
    fun create(name: String, dbType: String, password: String, dbUser: String) =
        call("create_db", name, dbType, password, dbUser);

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-create_db_user>
     */
    fun createUser(username: String, password: String, dbType: String) =
        call("create_db_user", username, password, dbType);

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-change_db_user_password>
     */
    fun changeUserPassword(username: String, password: String, dbType: String) =
        call("change_db_user_password", username, password, dbType);

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-delete_db>
     */
    fun delete(name: String, dbType: String) = call("delete_db", name, dbType);

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-delete_db_user>
     */
    fun deleteUser(username: String, dbType: String) =
        call("delete_db_user", username, dbType);

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-grant_db_permissions>
     */
    fun grandPermissions(username: String, database: String, dbType: String) =
        call("grant_db_permissions", username, database, dbType);

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-enable_addon>
     */
    fun enableAddon(database: String, addon: String) =
        call("enable_addon", database, "postgresql", addon);

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-list_dbs>
     */
    fun list() = call("list_dbs");

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-list_db_users>
     */
    fun listUsers() = call("list_db_users");

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-make_user_owner_of_db>
     */
    fun makeUserOwner(username: String, database: String, dbType: String) =
        call("make_user_owner_of_db", username, database, dbType);

    /**
     * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-create_db>
     */
    fun revokePermissions(username: String, database: String, dbType: String) =
        call("revoke_db_permissions", username, database, dbType);

}

/**
 * import "dart:async";

import "package:webfaction_api/src/data/db.dart";

import "api.dart";

/// CRUD, authentication and permissions for databases and database users
///

/**
 * See <https://docs.webfaction.com/xmlrpc-api/apiref.html#method-change_db_password>
*/
fun changePassword(username: String, password, dbType: String) =
call("change_db_password", username, password, dbType);

fun changePasswordFromInstance(Db db, password: String) =
changePassword(db.dbUser, password, db.dbType);

fun createFromInstance(Db db) =
create(db.name, db.dbType, db.password, db.dbUser);


fun createUserFromInstance(DbUser user) =
createUser(user.username, user.password, user.dbType);


fun changeUserPasswordFromInstance(DbUser user, password: String) =
changeUserPassword(user.username, password, user.dbType);


fun deleteFromInstance(Db db) = delete(db.name, db.dbType);


fun deleteUserFromInstance(DbUser user) =
deleteUser(user.username, user.dbType);


fun makeUserOwnerFromInstance(DbUser user, Db db) =
makeUserOwner(user.username, db.name, db.dbType);

fun revokePermissionsFromInstances(DbUser user, Db db) =
revokePermissions(user.username, db.name, db.dbType);
}

 */