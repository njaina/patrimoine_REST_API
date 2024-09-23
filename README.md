
# Patrimoine Management REST API

## Description

This API allows you to manage patrimoine records. You can create, update, and retrieve patrimoine details. The data is stored in a JSON file.

## Technologies Used

- Java 11+
- Spring Boot
- Jackson (for JSON processing)

## Endpoints

### 1. Create or Update a Patrimoine

**HTTP Method:** `PUT`

**Endpoint:** `/patrimoines/{id}`

**Curl Example:**

```bash
curl -X PUT http://localhost:8080/patrimoines/1 \
-H "Content-Type: application/json" \
-d '{"possesseur": "John Doe"}'
```
**Response:**


```json
{
    "possesseur": "John Doe"
}
```

### 2. Get a Patrimoine byId

**HTTP Method:** `GET`

**Endpoint:** `/patrimoines/{id}`

**Curl Example:**

```bash
curl  http://localhost:8080/patrimoines/1 \
```
**Response:**

```json
{
    "possesseur": "John Doe",
    "derniereModification":	"2024-09-23T15:40:42.938875461"
}
```

## Running the Application

1. Clone the repository:

   ```bash
   git clone https://github.com/njaina/patrimoine_REST_API
   ```

2. Navigate to project directory
  ```bash
  cd patrimoine
  ```
3. Build the project
  ```bash
  mvn clean install
  ```
4. Run the application
  ```bash
  mvn spring-boot:run
  ```
