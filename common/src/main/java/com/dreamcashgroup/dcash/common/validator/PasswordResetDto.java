package com.dreamcashgroup.dcash.common.validator;

import com.dreamcashgroup.dcash.common.annotation.MatchPassword;

import javax.validation.constraints.NotBlank;

@MatchPassword
public class PasswordResetDto {

	@NotBlank(message = "Password cannot be blank")
	private String password;

	@NotBlank(message = "Confirmed password cannot be blank")
	private String passwordConfirmation;

	@NotBlank(message = "Token has to be supplied along with a password reset request")
	private String token;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
