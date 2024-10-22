# Run

Use Intellij run configs in .run folder or:

```maven
mvn spring-boot:run
```

## Debug

```maven
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"
```