# How to execute the project

	1 - Clone repository from github
	
	$ git clone https://github.com/wescleysrn/pokemon-server.git

	2 - Access the project
	
	$ cd pokemon-server
	
	3 - Install libraries and dependencies
	
	$ mvn clean package
	
	4 - Run the project
	
	$ mvnw spring-boot:run
	
	5 - Test API
	
	http://localhost:8080/api/openweather/bycity/London

## Pokemon-Server

<p align="justify">Java project aimed at providing the features of the Pokemon challenge.</p>
<p align="center">
  <img src="https://github.com/wescleysrn/mestradounb/blob/master/imagens/pokemon/001.png">
</p>
<p align="justify">The project was created using the Angular framework, with Server Side Rendering, PWA capability and using bootstrap as a style sheet.</p>
<p align="justify">The main Angular libraries such as forms, route, http, etc. were used.</p>
<p align="center">
  <img src="https://github.com/wescleysrn/mestradounb/blob/master/imagens/pokemon/002.png">
</p>
<p align="justify">The solution allows you to enter the name of a city and based on that city, the weather API is consumed, which searches for the current temperature, if it is raining at the moment, etc.</p>
<p align="justify">According to the weather of the city, the Pokemon API is consumed to display the image of a Pokemon of a type according to the weather.</p>
<p align="center">
  <img src="https://github.com/wescleysrn/mestradounb/blob/master/imagens/pokemon/003.png">
</p>
<p align="justify">It is possible to load other Pokemons of the same type or clear the data that was loaded for a new query.</p>
<p align="justify">Two solutions were created, a frontend and a backend, and to work the API search by the backend it is necessary to run the pokemon-server project in Java.</p>
<p align="justify">The solution is also responsive and has all developer data.</p>
<p align="center">
  <img src="https://github.com/wescleysrn/mestradounb/blob/master/imagens/pokemon/004.png">
</p>

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
