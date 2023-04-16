package com.nsri.oauthdemo.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.oauth2.core.user.OAuth2User

data class CustomOAuth2User(
    val fullName: String,
    val email: String,
    val login: String?
): OAuth2User {
    override fun getAttributes(): Map<String, Any> {
        val attributes = HashMap<String, Any>()
        if (fullName.isNotEmpty()) {
            attributes["name"] = fullName
        }
        if (email.isNotEmpty()) {
            attributes["email"] = email
        }
        if (!login.isNullOrEmpty()) {
            attributes["login"] = login
        }
        return attributes
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf()
    }

    override fun getName(): String {
        return login ?: ""
    }
}