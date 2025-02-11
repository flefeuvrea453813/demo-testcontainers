# demo-testcontainers
Demo testcontainer with springboot3


```bash
docker compose -f infra.docker-compose.yml up -d
```

docker exec postgres psql -U postgres -d postgres -c "CREATE SCHEMA IF NOT EXISTS demo;"
