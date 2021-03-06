package fm.pangea.client

import fm.pangea.Protocol
import fm.pangea.connections.ApiConnection
import fm.pangea.connections.ConnectionFactory

class GameApiClient(private val connectionFactory: ConnectionFactory) {
    private lateinit var apiConnection: ApiConnection

    fun connect(protocol: Protocol) {
        this.apiConnection = this.connectionFactory.Create(protocol);
    }

    fun enterGame(id: String, guid: String, key: String, platform: String, gameName: String): EnterResponse {
        return this.apiConnection.enter(id, guid, key, platform, gameName)
    }

    fun getBalance(id: String, guid: String): Any {
        return this.apiConnection.getBalance(id, guid)
    }
}
