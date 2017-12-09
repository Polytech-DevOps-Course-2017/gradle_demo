# FindMin in Java

## Tasks

| Command                      | Action      |
| :-------------------         | :----------- |
| `./gradlew zipIt`            | to zip a binary into `./build/distributions/FindMin-1.0-SNAPSHOT.zip` |
| `./gradlew deployIt`         | to create a Docker image |
| `./gradlew runDummyTest`     | to run simple test |
| `./gradlew test        `     | to run tests |

## Actual usage

* With Java
``` bash
$ java -jar build/libs/FindMin-1.0-SNAPSHOT.jar "1 2 3 4 5 6 -3"
Minimum found: -3
```

* With Docker
``` bash
$ docker run  sashadock/gradle_demo "1 2 3 4 5 6"
Minimum found: 1
```

## Author
Aleksandra Zhuravleva, guravleva.aleksandra@gmail.com
