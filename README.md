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

#### Get Task List by ID

```http
GET /task-lists/{task_list_id}
```

Returns a specific task list by its ID.

**Parameters**

| Name         | Type | In   | Description                     |
| ------------ | ---- | ---- | ------------------------------- |
| task_list_id | UUID | path | ID of the task list to retrieve |

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

#### Update Task List

```http
PUT /task-lists/{task_list_id}
```

Updates an existing task list.

**Parameters**

| Name         | Type | In   | Description                   |
| ------------ | ---- | ---- | ----------------------------- |
| task_list_id | UUID | path | ID of the task list to update |

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

#### Delete Task List

```http
DELETE /task-lists/{task_list_id}
```

Deletes a task list.

**Parameters**

| Name         | Type | In   | Description                   |
| ------------ | ---- | ---- | ----------------------------- |
| task_list_id | UUID | path | ID of the task list to delete |

**Response**

```http
204 No Content
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
