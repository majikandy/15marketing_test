package fm.pangea.connections

import fm.pangea.Protocol

class ConnectionFactoryImpl(private val restConnection: ApiConnection, private val soapConnection: ApiConnection) :
    ConnectionFactory {

    override fun Create(protocol: Protocol) : ApiConnection {
        if (protocol == Protocol.REST)
            return restConnection;
        if (protocol == Protocol.SOAP)
            return soapConnection;

        throw NotImplementedError();
    }
}

