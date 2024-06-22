# Spring store
It's an ecommerce api project, made so you can study and remember some concepts. In this project I implement the concept of hexagonal architecture for greater decoupling from business rules.

I'm also going to add some interesting things like deploying via container on EC2, using s3 as file storage and RDS to maintain my Postgre database.

## How to run dev environment
First you need have docker and docker-compose installed in your machine. 
Then you can run the following command inside the project root folder:

### Run the dev dependencies
```bash
docker compose -f docker/docker-compose-dev.yml up -d
```

### Stop the dev dependencies
```bash
docker compose -f docker/docker-compose-dev.yml stop
```

### Remove the dev dependencies
```bash
docker compose -f docker/docker-compose-dev.yml down -v
```
