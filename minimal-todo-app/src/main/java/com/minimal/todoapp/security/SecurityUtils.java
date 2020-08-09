package com.minimal.todoapp.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
public class SecurityUtils {

	/**
	 * Token expiration time 1 days.
	 */
	public static final long EXPIRATION_TIME = 24 * 60 * 60 * 1000;

	/**
	 * Secret key for signature
	 */
	public static final String SECRET_KEY = "mySecretKey";

	/**
	 * The company who provided token.
	 * You can customize issuer name, this is given as an example.
	 */
	public static final String ISSUER = "www.farukgenc.com";

	/**
	 * Token Prefix
	 * We will use this prefix when parsing JWT Token
	 */
	public static final String TOKEN_PREFIX = "Bearer ";

	/**
	 * Authorization Prefix in HttpServletRequest
	 * Authorization: <type> <credentials>
	 * For Example : Authorization: Bearer YWxhZGRpbjpvcGVuc2VzYW1l
	 */
	public static final String HEADER_STRING = "Authorization";

	public static final String LOGIN_REQUEST_URI = "/login";

	public static final String REGISTRATION_REQUEST_URI = "/register";

	private SecurityUtils() {
		throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
	}

	/**
	 * @return the currently authenticated username
	 */
	public static String getAuthenticatedUsername() {

		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		final UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return userDetails.getUsername();
	}

}
