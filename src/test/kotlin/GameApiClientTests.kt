import fm.pangea.client.GameApiClient
import fm.pangea.Protocol
import fm.pangea.client.*
import fm.pangea.connections.ApiConnection
import fm.pangea.connections.ConnectionFactoryImpl
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

class GameApiTests {

    @Test
    fun enter_game_connecting_via_REST_uses_the_REST_factory_to_proxy_the_call() {
        val restConnectionMock = RestConnectionMock()
        val gameClient = GameApiClient(ConnectionFactoryImpl(restConnectionMock, SoapConnectionMock()))

        gameClient.connect(Protocol.REST)
        val response = gameClient.enterGame("123", "456", "789", "real", "jumpy bird")

        assertEquals(restConnectionMock.fakeEnterResponseOk, response)
    }

    @Test
    fun get_balance_connecting_via_SOAP_uses_the_SOAP_factory_to_proxy_the_call() {
        val soapConnectionMock = SoapConnectionMock()
        val gameClient = GameApiClient(ConnectionFactoryImpl(RestConnectionMock(), soapConnectionMock))

        gameClient.connect(Protocol.SOAP)
        val response = gameClient.getBalance("123","456")

        assertEquals(soapConnectionMock.fakeGetBalanceResponseOk, response)
    }

    class SoapConnectionMock : ApiConnection {
        val fakeGetBalanceResponseOk =
            GetBalanceResponse("123", Result.Ok, Balance(Currency.getInstance("GBP"), "real", 100, 1))

        override fun getBalance(id: String, guid: String): GetBalanceResponse {
            // Simulates getting balance via SOAP to the API
            return fakeGetBalanceResponseOk
        }

        override fun enter(id: String, guid: String, key: String, platform: String, gameName: String): EnterResponse {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    class RestConnectionMock : ApiConnection {
        val fakeEnterResponseOk = EnterResponse(
            "123",
            Result.Ok,
            Balance(Currency.getInstance("GBP"), "real", 100, 1),
            User("normal", "real", 1441421),
            listOf(
                Control(true, "game-data"),
                Control(true, "combos"),
                Control(true, "game-info")
            )
        );

        override fun getBalance(id: String, guid: String): GetBalanceResponse {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun enter(id: String, guid: String, key: String, platform: String, gameName: String): EnterResponse {
            // Simulates entering game via REST to the API
            return fakeEnterResponseOk;
        }
    }
}


