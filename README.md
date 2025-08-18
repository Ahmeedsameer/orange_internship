# Online Store Database with Docker + MariaDB

## Task

* Run MariaDB in Docker and connect to it  
* Create database and tables  
* Insert sample data  
* Use volumes to persist data after container removal  

---

## 1. Pull MariaDB Image

```bash
docker pull mariadb:latest
```

---

## 2. Run MariaDB in a Container

```bash
docker run -d --name mariadb-docker -e MYSQL_ROOT_PASSWORD=1234 -p 3306:3306 mariadb:latest
```

---

## 3. Connect to MariaDB inside the Container

```bash
docker exec -it mariadb-docker mariadb -u root -p1234
```

---

## 4. Create Database

```sql
CREATE DATABASE online_store;
USE online_store;
```

---

## 5. Import Tables from `init.sql`

### PowerShell (Windows)

```powershell
Get-Content C:\Users\ahmed\init.sql | docker exec -i mariadb-docker mariadb -u root -p1234 online_store
```

---

## 6. Verify Tables

```sql
SHOW TABLES;
```

### Output:
```
+------------------------+
| Tables_in_online_store |
+------------------------+
| customer               |
| order_product          |
| orders                 |
| products               |
+------------------------+
```

---

## 7. Insert Sample Data

```sql
INSERT INTO customer (name, email, addres, phone)
VALUES
('Ahmed Samir', 'ahmed@example.com', 'Cairo, Egypt', '01012345678'),
('Omar', 'omar@example.com', 'Alexandria, Egypt', '01198765432');
```

---

## 8. Stop & Remove the Container

```bash
docker stop mariadb-docker
docker rm mariadb-docker
```

---

## 9. Run Again (Check Persistence)

```bash
docker run -d --name mariadb-docker -e MYSQL_ROOT_PASSWORD=1234 -p 3306:3306 mariadb:latest
```

### Re-import if needed

```powershell
Get-Content C:\Users\ahmed\init.sql | docker exec -i mariadb-docker mariadb -u root -p1234 online_store
```
