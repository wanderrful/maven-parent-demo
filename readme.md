# Maven-Parent-Demo

To run from root folder:

1. `mvn package` to build all modules

2. `mvn exec:java -pl web -D exec.mainClass=App` to call the entry point

Should output:

```
[App.main()] INFO App - hello from core!... and service!
```

The Core Module contains the "hello from core!" and the Service Module adds the "... and service!" before serving the final result to the Web Module. 