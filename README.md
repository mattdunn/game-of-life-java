# Game of Life in Java

An implementation of [Conways Game of Life](https://en.wikipedia.org/wiki/Conway's_Game_of_Life) done during a coding dojo by AirNZ crew.

Includes Gradle build file, Docker files and Eclipse project files.

Inside the docker container, this repositories files are shared under /app

## Dependencies

### If using Docker container (optional)

- docker
- docker-compose

## How to

- run Gradle tests inside Docker container

  `docker-compose run app test`