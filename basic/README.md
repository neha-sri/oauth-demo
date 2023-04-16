# Spring Security Authentication Basics

## What To Expect
This example helps you configure a basic Spring application with GitHub OAuth2.0. The OAuth app will have to be configured in Github and then we connect those credentials to our application. Once authenticated, we redirect to a basic static index.html page.

## Getting Started
In order to run this application, you will need to create a GitHub OAuth app. You can do this by going to your GitHub settings and selecting Developer Settings. From there, select OAuth Apps and then New OAuth App. You will need to provide a callback URL. This is the URL that GitHub will redirect to after a successful authentication. For this example, we will use http://localhost:8080/login/oauth2/code/github. You can use any URL you like, but it must match the URL you provide in the application.yml file.

> For a detailed tutorial, please see this medium article: 
> [Basic Kotlin/Java + Spring app with GitHub OAuth 2.0](https://medium.com/@neha-sri/basic-kotlin-java-spring-boot-app-with-github-oauth-2-0-e01d6dc0e866)

