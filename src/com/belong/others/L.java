package com.belong.others;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.StandardProtocolFamily;
import java.net.StandardSocketOptions;
import java.nio.channels.DatagramChannel;
import java.nio.channels.MembershipKey;

public class L {

	public static void main(String[] args) {
		try {
			NetworkInterface networkInterface=NetworkInterface.getByName("net1");
			DatagramChannel dc=DatagramChannel.open(StandardProtocolFamily.INET);
			dc.setOption(StandardSocketOptions.SO_REUSEADDR, true);
			dc.bind(new InetSocketAddress(8080));
			dc.setOption(StandardSocketOptions.IP_MULTICAST_IF, networkInterface);
			InetAddress group = InetAddress.getByName("127.0.0.1");
			MembershipKey key=dc.join(group, networkInterface);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
