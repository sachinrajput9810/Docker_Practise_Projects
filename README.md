# 🚀 Docker Practice Projects: Java, MySQL & More

This repository contains multiple small projects created to **explore, learn, and test Docker functionalities** using Java applications and MySQL databases.

These projects were built with the intent of:

- Understanding containerization of normal Java applications
- Testing Docker Compose features and service dependencies
- Exploring container-to-container communication using Docker Networks
- Connecting Dockerized apps to both **local MySQL databases** and **Dockerized MySQL containers**
- Implementing concepts like health checks, wait-for-it scripts, and container build flows

---

## 🧠 Concepts Covered

| Concept | Covered In |
|--------|-------------|
| ✅ Dockerfile usage for Java apps | All Java app projects |
| ✅ Docker Compose setup | `docker-compose.yml` in multiple projects |
| ✅ Wait-for-MySQL (netcat script) | `wait-for-mysql.sh` |
| ✅ Containerized MySQL DB | `mysqldb` service |
| ✅ Connecting to **local MySQL DB** from container | One practice project |
| ✅ Docker **internal networking** | `depends_on`, service names used as host |
| ✅ Healthcheck usage in Docker | `healthcheck:` in MySQL service |
| ✅ Multi-container orchestration | Full Compose setup |
| ✅ Port conflicts and solutions | Explored using alternate ports |

---
