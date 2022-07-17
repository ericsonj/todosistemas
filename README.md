# Todosistemas Test

## REST API

### GET users

```
curl -X GET 'https://app.ericsonj.net/todosistemas/api/users'
```

### GET tasks

```
curl -X GET 'https://app.ericsonj.net/todosistemas/api/tasks'
```

### POST tasks

```
curl -X POST 'https://app.ericsonj.net/todosistemas/api/tasks' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "task1",
    "endDate": 1658085549132,
    "assignedTo": 1
}'
```

### PATCH tasks

```
curl -X PATCH 'https://app.ericsonj.net/todosistemas/api/tasks/1' \
--header 'Content-Type: application/json' \
--data-raw '{
	"name": "task update 3"
}'

```

### DELETE tasks

```
curl --location --request DELETE 'https://app.ericsonj.net/todosistemas/api/tasks/5'
```