package cn.kgc.tangcco.user.entity;

import lombok.Data;

@Data
public class User {
	private Integer userId;
	private String account,password,nickname;
}
