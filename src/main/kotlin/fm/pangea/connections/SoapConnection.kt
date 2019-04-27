package fm.pangea.connections

import fm.pangea.client.EnterResponse
import fm.pangea.client.GetBalanceResponse

class SoapConnection : ApiConnection {
    override fun getBalance(id: String, guid: String): GetBalanceResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun enter(id: String, guid: String, key: String, platform: String, gameName: String): EnterResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}