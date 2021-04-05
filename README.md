# About
Creating  a CRUD(Create, Read, Update, Delete) using  the REST standard


## Technologies
Java, Spring, Hibernate, Docker


## Run project

```
$ docker build --tag=stoom:latest .
$ docker run -d -p8888:8080 stoom:latest
```

## URLs

| METHOD  | CONTENT-TYPE     | URL |
|---------|------------------|-----|
| GET     |                  | http://127.0.0.1:8888/locate/|
| GET     |                  | http://127.0.0.1:8888/locate/{id}|
| POST    | Application/json | http://127.0.0.1:8888/locate/{id}|
| PUT     | Application/json | http://127.0.0.1:8888/locate/{id}|
| DELETE  |                  | http://127.0.0.1:8888/locate/{id}|



## Exemple CURL

```
curl --request GET \
  --url http://127.0.0.1:8888/locate/
```