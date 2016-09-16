package org.apache.commons.httpclient.protocol;

public interface ProtocolProvider {
	public Protocol getProtocol(String id);
}
