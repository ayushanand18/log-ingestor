# Design
> API and Data Design for the Application.

## API Design
* `PUT` `/add` data:
    ```json
    {
        "data": {
            "level": "error | info | warn",
            "message": "string",
            "resourceId": "server-1234",
            "timestamp":  "2023-09-15T08:00:00Z",
            "traceId": "abc-xyz-123",
            "commit": "5e5342f",
            "metadata": {
                "parentResourceId": "server-0987"
            }
        }
    }
    ```
* `GET` `/find` params:
    - `traceId`: `string`
    - `from`:  `timestamp (from)`
    - `to`: `timestamp (to)`
    - `level`: `error | info | warn`
    - `resourceId`: `string`

## Data Design
We'll use a postgres database.
