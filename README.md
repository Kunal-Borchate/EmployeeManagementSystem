# Employee Management System (EMS)

Employee Management System (EMS) is a web application designed to manage employees and departments within an organization. This project provides RESTful APIs for performing CRUD (Create, Read, Update, Delete) operations on both employees and departments.

## Features

- Create, retrieve, update, and delete employees.
- Create, retrieve, update, and delete departments.
- RESTful API endpoints for interacting with employees and departments.
- Cross-origin resource sharing (CORS) enabled to allow requests from any origin.

## Technologies Used

- Java
- Spring Boot
- Spring MVC
- Lombok
- RESTful APIs

## Project Structure

The project follows a standard MVC (Model-View-Controller) architecture:

- `com.udemy.ems.controller`: Contains controllers for handling HTTP requests.
- `com.udemy.ems.dto`: Data transfer objects used for transferring data between layers.
- `com.udemy.ems.entity`: Entity classes representing database entities.
- `com.udemy.ems.service`: Contains service classes implementing business logic.

## Usage

To use this project:

1. Clone the repository.
2. Import the project into your preferred Java IDE.
3. Configure the project dependencies and database settings.
4. Run the application.
5. Access the RESTful APIs to perform CRUD operations on employees and departments.

## Endpoints

### Employees

- `POST /api/employees`: Create a new employee.
- `GET /api/employees/{id}`: Retrieve an employee by ID.
- `GET /api/employees`: Retrieve all employees.
- `PUT /api/employees/{id}`: Update an employee by ID.
- `DELETE /api/employees/{id}`: Delete an employee by ID.

### Departments

- `POST /api/departments`: Create a new department.
- `GET /api/departments/{id}`: Retrieve a department by ID.
- `GET /api/departments`: Retrieve all departments.
- `PUT /api/departments/{id}`: Update a department by ID.
- `DELETE /api/departments/{id}`: Delete a department by ID.

# Employee Management System (EMS) - Frontend

Employee Management System (EMS) is a web application designed to manage employees and departments within an organization. This repository contains the frontend codebase built with React.

## Features

- Interface to interact with the Employee Management System backend.
- User-friendly interface for managing employees and departments.
- Utilizes RESTful APIs provided by the backend for CRUD operations.

## Technologies Used

- React
- React Router
- Axios (for making HTTP requests)
- Bootstrap (for styling)

## Usage

To use this frontend:

1. Clone the repository.
2. Install dependencies using `npm install`.
3. Configure the backend API URL in the codebase (usually in a configuration file).
4. Run the frontend using `npm start`.
5. Access the frontend interface via the provided URL (typically `http://localhost:3000`).

## Configuration

Before running the frontend, ensure that you've configured the backend API URL. You can typically find this configuration in a file named `config.js` or `constants.js`. Update the API URL to match the location of your running backend instance.

```javascript
// Example config.js file
const API_BASE_URL = 'http://localhost:8080/api'; // Update this URL
export default API_BASE_URL;




