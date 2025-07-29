# Task Management API

This is a Spring Boot application that provides REST APIs for managing tasks and task lists.

## API Endpoints

### Task Lists

#### Get All Task Lists

```http
GET /task-lists
```

Returns a list of all task lists.

**Response**

```json
[
  {
    "id": "uuid",
    "title": "string",
    "description": "string",
    "count": 0,
    "progress": 0.0,
    "tasks": [
      {
        "id": "uuid",
        "title": "string",
        "description": "string",
        "dueDate": "datetime",
        "priority": "LOW|MEDIUM|HIGH",
        "status": "OPEN|CLOSED"
      }
    ]
  }
]
```

#### Create a Task List

```http
POST /task-lists
```

Creates a new task list.

**Request Body**

```json
{
  "title": "string",
  "description": "string"
}
```

**Response**

```json
{
  "id": "uuid",
  "title": "string",
  "description": "string",
  "count": 0,
  "progress": 0.0,
  "tasks": []
}
```

## Data Types

### TaskList

| Field       | Type    | Description                            |
| ----------- | ------- | -------------------------------------- |
| id          | UUID    | Unique identifier                      |
| title       | String  | Title of the task list                 |
| description | String  | Description of the task list           |
| count       | Integer | Number of tasks in the list            |
| progress    | Double  | Progress percentage of completed tasks |
| tasks       | Task[]  | Array of tasks belonging to this list  |

### Task

| Field       | Type         | Description                      |
| ----------- | ------------ | -------------------------------- |
| id          | UUID         | Unique identifier                |
| title       | String       | Title of the task                |
| description | String       | Description of the task          |
| dueDate     | DateTime     | Due date for the task            |
| priority    | TaskPriority | Priority level (LOW/MEDIUM/HIGH) |
| status      | TaskStatus   | Status (OPEN/CLOSED)             |
