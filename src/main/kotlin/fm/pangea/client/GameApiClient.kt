package fm.pangea.client

import fm.pangea.Protocol
import fm.pangea.connections.ApiConnection
import fm.pangea.connections.ConnectionFactory

class GameApiClient(private var connectionFactory: ConnectionFactory) {

    private lateinit var connection: ApiConnection

    fun connect(protocol: Protocol) {
        this.connection = this.connectionFactory.Create(protocol);
    }

    fun enterGame(id: String, guid: String, key: String, platform: String, gameName: String): EnterResponse {
        return this.connection.enter(id, guid, key, platform, gameName)
    }

    fun getBalance(id: String, guid: String): Any {
        return this.connection.getBalance(id, guid)
    }
}