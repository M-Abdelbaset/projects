package com.home;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "conf")
public class YMLProps {

	private String name;
	private List<String> imgIds;
	private Map<String, String> dirs;
	private Address address;
	
	public static class Address {
		private String ip, port;

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}

		public String getPort() {
			return port;
		}

		public void setPort(String port) {
			this.port = port;
		}

		@Override
		public String toString() {
			return "Address [ip=" + ip + ", port=" + port + "]";
		}
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getImgIds() {
		return imgIds;
	}

	public void setImgIds(List<String> imgIds) {
		this.imgIds = imgIds;
	}

	public Map<String, String> getDirs() {
		return dirs;
	}

	public void setDirs(Map<String, String> dirs) {
		this.dirs = dirs;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "YMLProps [name=" + name + ", imgIds=" + imgIds + ", dirs=" + dirs + ", address=" + address + "]";
	}

	
	
}