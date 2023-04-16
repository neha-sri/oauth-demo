package com.nsri.oauthdemo.controllers

import com.nsri.oauthdemo.model.CustomOAuth2User
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


@Controller
class HomeController {
    @Value("\${spring.application.name}")
    var appName: String? = null

    @Value("\${spring.security.oauth2.client.provider.github.authorization-uri}")
    var authorizationUri: String? = null

    @GetMapping("/")
    fun home(model: Model, authentication: Authentication): String {
        model.addAttribute("appName", appName)
        if (authentication.isAuthenticated) {
            val customOAuth2User = authentication.principal as CustomOAuth2User
            model.addAttribute("name", customOAuth2User.fullName)
            model.addAttribute("email", customOAuth2User.email)
            model.addAttribute("login", customOAuth2User.login)
            return "home"
        }

        model.addAttribute("authorizationUri", authorizationUri)
        return "login"
    }

    @GetMapping("/welcome")
    fun welcome(): String {
        return "welcome"
    }
}