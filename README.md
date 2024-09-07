<h2>Issue Tracking System API Documentation</h2>
<h3>Base URL</h3>

`/issues`

<h3>Endpoints</h3>

1. Get All Issues

	- URL: /issues
	- Method: GET
	- Description: Retrieves a list of all issues.
	- Response:
  		* Status Code: 200 OK
  		* Content-Type: application/json
  		* Response Body:
```    
[
  {
    "id": 1,
    "title": "Issue 1",
    "description": "Description for Issue 1.",
    "status": "OPEN"
  },
  {
    "id": 2,
    "title": "Issue 2",
    "description": "Description for Issue 2.",
    "status": "IN PROGRESS"
  }
]
```
2. Get Issue by ID
   
	- URL: /issues/{id}
	- Method: GET
	- Description: Retrieves a specific issue by its ID.
	- URL Parameters:
  		* id (Long) - The ID of the issue to retrieve.
	- Response:
  		* Status Code: 200 OK
  		* Content-Type: application/json
  		* Response Body:
```
{
  "id": 1,
  "title": "Issue 1",
  "description": "Description for Issue 1.",
  "status": "OPEN"
}
```
3. Create Issue

	- URL: /issues
	- Method: POST
	- Description: Creates a new issue.
	- Request Body:
  		* Content-Type: application/json
  		* Request Body:
```
{
  "title": "New Issue 3",
  "description": "Description for New Issue 3.",
  "status": "OPEN"
}
```
3. Create Issue Response
	- Response:
  		* Status Code: 201 Created
  		* Content-Type: application/json
  		* Response Body:
				
```
{
  "id": 3,
  "title": "New Issue Title",
  "description": "Detailed description of the new issue.",
  "status": "OPEN"
}
```
4. Update Issue

	- URL: /issues/{id}
	- Method: PUT
	- Description: Updates an existing issue.
	- URL Parameters:
  		* id (Long) - The ID of the issue to update.
	- Request Body:
  		* Content-Type: application/json
  		* Request Body:
```
{
  "title": "Issue 2",
  "description": "Description for Issue 2.",
  "status": "RESOLVED"
}
```
4. Update Issue OK Response
	- Response:
  		* Status Code: 200 OK
  		* Content-Type: application/json
  		* Response Body:

```
{
  "id": 2,
  "title": "Issue 2",
  "description": "Description for Issue 2.",
  "status": "RESOLVED"
}
```
4. Update Issue Not Found Response
	- Response:
  		* Status Code: 404 Not Found
  		* Response Body: Empty

5. Delete Issue

	- URL: /issues/{id}
	- Method: DELETE
	- Description: Deletes an issue by its ID.
	- URL Parameters:
  		* id (Long) - The ID of the issue to delete.
	- Response:
  		* Status Code: 204 No Content
  		* Response Body: Empty
  		* Status Code: 404 Not Found
  		* Response Body: Empty







