package com.kh.springdb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistration {
	 @JsonProperty("username")
	    private String username;

	    @JsonProperty("password")
	    private String password;

	    @JsonProperty("name")
	    private String name;

	    @JsonProperty("email")
	    private String email;

	    @JsonProperty("address")
	    private String address;

	    @JsonProperty("phone")
	    private String phone;

	    @JsonProperty("role")
	    private Role role;
	}