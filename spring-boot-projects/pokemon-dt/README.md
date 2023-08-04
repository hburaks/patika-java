# API Documentation

This is the API documentation for the project. It provides information about the available endpoints, request parameters, and response formats.

## Base URL

The base URL for all API endpoints is `http://localhost:8084`. All endpoints should be appended to this base URL.

## Endpoints

### Get All Pokemon

- Endpoint: `/pokemon`
- Method: `GET`
- Description: Retrieves a list of all Pokemon entities.
- Response: Array of PokemonEntity objects.

### Create a New Pokemon

- Endpoint: `/pokemon`
- Method: `POST`
- Description: Creates a new Pokemon entity.
- Request Body: PokemonEntity object (application/json)
- Response: The created PokemonEntity object.

### Get All Gyms

- Endpoint: `/gym`
- Method: `GET`
- Description: Retrieves a list of all Gym entities.
- Response: Array of GymEntity objects.

### Create a New Gym

- Endpoint: `/gym`
- Method: `POST`
- Description: Creates a new Gym entity.
- Request Body: GymEntity object (application/json)
- Response: The created GymEntity object.

### Get All Characters

- Endpoint: `/character`
- Method: `GET`
- Description: Retrieves a list of all Character entities.
- Response: Array of CharacterEntity objects.

### Create a New Character

- Endpoint: `/character`
- Method: `POST`
- Description: Creates a new Character entity.
- Request Body: CharacterEntity object (application/json)
- Response: The created CharacterEntity object.

### Get Pokemon and Character by Names

- Endpoint: `/pokemonName/{pokemonName}/characterName/{characterName}`
- Method: `GET`
- Description: Retrieves a list of BaseEntity objects that match the given Pokemon and Character names.
- Parameters: `pokemonName` (string, path) and `characterName` (string, path)
- Response: Array of BaseEntity objects.

### Get Pokemon by Type

- Endpoint: `/pokemon/type/{type}`
- Method: `GET`
- Description: Retrieves a list of Pokemon entities of the specified type.
- Parameters: `type` (string, path) - Possible values: GROUND, NORMAL, PSYCHIC, WATER, FIRE, ELECTRIC, BUG, GRASS
- Response: Array of PokemonEntity objects.

### Get Pokemon by Name

- Endpoint: `/pokemon/name/{name}`
- Method: `GET`
- Description: Retrieves the Pokemon entity with the specified name.
- Parameters: `name` (string, path)
- Response: PokemonEntity object.

### Get Pokemon by Name Starting With

- Endpoint: `/pokemon/name/start/{name}`
- Method: `GET`
- Description: Retrieves a list of Pokemon entities with names starting with the given value.
- Parameters: `name` (string, path)
- Response: Array of PokemonEntity objects.

### Get Gyms Established Before Date

- Endpoint: `/gym-establish-before/date/{date}`
- Method: `GET`
- Description: Retrieves a list of Gym entities established before the specified date.
- Parameters: `date` (integer, path) - Unix timestamp in seconds.
- Response: Array of GymEntity objects.

### Get Characters by Type (Unused Parameters)

- Endpoint: `/character/type/{type}`
- Method: `GET`
- Description: Retrieves a list of Character entities. (Note: Unused parameters, might be incomplete.)
- Response: Array of CharacterEntity objects.

### Get Character by Name

- Endpoint: `/Character/name/{name}`
- Method: `GET`
- Description: Retrieves the Character entity with the specified name.
- Parameters: `name` (string, path)
- Response: CharacterEntity object.

## Data Models

The API uses the following data models:

### PokemonEntity

- id (integer)
- uuid (string, UUID format)
- creationDate (string, date-time format)
- updatedDate (string, date-time format)
- name (string)
- power (integer)
- pokemonTypeEnum (string, enum) - Possible values: GROUND, NORMAL, PSYCHIC, WATER, FIRE, ELECTRIC, BUG, GRASS

### GymEntity

- id (integer)
- uuid (string, UUID format)
- creationDate (string, date-time format)
- updatedDate (string, date-time format)
- name (string)
- establishDate (integer)
- qualityStar (integer)

### CharacterEntity

- id (integer)
- uuid (string, UUID format)
- creationDate (string, date-time format)
- updatedDate (string, date-time format)
- name (string)
- age (integer)
- pokemonTypeEnum (string, enum) - Possible values: GROUND, NORMAL, PSYCHIC, WATER, FIRE, ELECTRIC, BUG, GRASS

### BaseEntity

- id (integer)
- uuid (string, UUID format)
- creationDate (string, date-time format)
- updatedDate (string, date-time format)

## Error Handling

The API may return appropriate HTTP status codes and error messages for invalid requests or errors. Please refer to the individual endpoint descriptions for possible error scenarios.
