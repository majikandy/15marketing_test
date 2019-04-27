package fm.pangea.connections

import fm.pangea.client.EnterResponse
import fm.pangea.client.GetBalanceResponse

interface ApiConnection {
    fun enter(id: String, guid: String, key:String, platform:String, gameName:String) : EnterResponse
    fun getBalance(id: String, guid: String): GetBalanceResponse;
}
