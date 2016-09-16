package org.apache.commons.httpclient.protocol;

public abstract class WrappedProtocolProvider implements ProtocolProvider {
	protected final ProtocolProvider wrapped;
	
	protected WrappedProtocolProvider(ProtocolProvider wrapped) {
		this.wrapped = wrapped;
	}
	
	protected abstract Protocol getWrappedProtocol(String id);
	
	public Protocol getProtocol(String id) {
		Protocol ret = getWrappedProtocol(id);
		if (ret != null) {
			return ret;
		}
		return wrapped.getProtocol(id);
	}

}
