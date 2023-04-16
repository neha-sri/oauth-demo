package com.nsri.oauthdemo.services

import com.nsri.oauthdemo.model.CustomOAuth2User
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Service

@Service
class CustomOAuth2UserService : OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    override fun loadUser(userRequest: OAuth2UserRequest): OAuth2User {
        val delegate = DefaultOAuth2UserService()
        val oAuth2User = delegate.loadUser(userRequest)

        val name: String? = oAuth2User.getAttribute("name")
        val email: String? = oAuth2User.getAttribute("email")
        val login: String? = oAuth2User.getAttribute("login")

        // Log the attribute values
        println("Name: $name")
        println("Email: $email")
        println("Login: $login")

        return CustomOAuth2User(name?: "Unknown", email?: "Unknown", login)
    }
}
