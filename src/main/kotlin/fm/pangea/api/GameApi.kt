package fm.pangea.api

import fm.pangea.client.EnterResponse
import fm.pangea.client.GetBalanceResponse
import java.util.*

interface GameApi {
    fun enter(id: String, guid: String, key:String, platform:String, gameName:String) : EnterResponse
    fun getBalance(id: String, guid: UUID): GetBalanceResponse;
}
