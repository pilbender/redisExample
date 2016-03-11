package org.raescott.redisexample;

import org.springframework.data.annotation.Id;

/**
 * @author Richard Scott Smith <scott.smith@isostech.com>
 */
public class RedisBean {
	@Id
	private String id;
	private String name;
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
