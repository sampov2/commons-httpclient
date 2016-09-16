package org.apache.commons.httpclient.protocol;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DefaultProtocolProvider implements ProtocolProvider {
	private final static DefaultProtocolProvider instance = new DefaultProtocolProvider();
	
	private final Map protocols;
	
	private DefaultProtocolProvider() {
		Map tmp = new HashMap();
		
		tmp.put("http", new Protocol("http", DefaultProtocolSocketFactory.getSocketFactory(), 80));

        tmp.put("https", new Protocol("https", SSLProtocolSocketFactory.getSocketFactory(), 443));
		
		this.protocols = Collections.synchronizedMap(tmp);
	}
	
	public static DefaultProtocolProvider getInstance() {
		return instance;
	}
	
	public void registerProtocol(String id, Protocol protocol) {
		this.protocols.put(id, protocol);
	}
	
	public Protocol getProtocol(String id) {
		Protocol ret = (Protocol)protocols.get(id);
		
		if (ret == null) {
			throw new IllegalStateException("unsupported protocol: '" + id + "'");
		}
		
		return ret;
	}

}
