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

  
