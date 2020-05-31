package com.home;

public class TestServiceImpl implements TestService {

	@Override
	public String getName() {
		return get();
	}

	public String get() {
		return "def";
	}
}
