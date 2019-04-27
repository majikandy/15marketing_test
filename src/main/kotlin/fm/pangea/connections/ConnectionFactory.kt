package fm.pangea.connections

import fm.pangea.Protocol

interface ConnectionFactory {
    fun Create(protocol: Protocol): ApiConnection
}
