# Run

Use Intellij run configs in .run folder or:

```maven
mvn spring-boot:run
```

## Debug

```maven
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"
```


# Test

### Get Loggers
```curl
curl --request GET \
  --url 'http://localhost:8080/logging/loggers?filter=com.nf'
```

### Set LogLevel
```
curl --request PUT \
  --url http://localhost:8080/logging/loggers \
  --header 'content-type: application/json' \
  --data '{
  "logger": "com.nf",
  "level": "info"
}'
```