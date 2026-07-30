
mvn clean package
podman network create training-net 
podman rm -f training-mysql training-app 
podman run -d --name training-mysql --network training-net -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=training_management_db -p 3307:3306 mysql:8.4
Start-Sleep -Seconds 25
podman build -t training-management-app .
podman run -d --name training-app --network training-net -p 8085:8085 -e DB_URL="jdbc:mysql://training-mysql:3306/training_management_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC" -e DB_USERNAME=root -e DB_PASSWORD=123456 training-management-app
podman ps
