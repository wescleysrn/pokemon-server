
# Pokemon-Server

    Java project aimed at providing the features of the Pokemon challenge.

## Start Project

    To start the project was used Spring Initializr:
    https://start.spring.io/

    Projet: Maven Project
    Language: Java
    Spring Boot: 2.6.4

    Metadata
    Group: br.com.pokemon
    Artifact: pokemon-server
    Name: Pokemon Server
    Description: Project backend of the Code Challenge Pokemon
    Package Name: br.com.pokemon

    Packaging: jar
    Java: 8

    Dependencies:
        - Spring Web

## Commands

    First packages install
    mvn clean package

    Run the project
    .\mvnw spring-boot:run

## Project Packages and Class

    br.com.pokemon.dto
        CityWeatherDTO
        PokemonDTO
        PokemonDetailDTO

    br.com.pokemon.mediator
        OpenWeatherMediator
        PokemonMediator

    br.com.pokemon.rest
        OpenWeatherRest
        PokemonRest

