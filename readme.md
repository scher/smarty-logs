## Installation and Start

1. build project:
    ```bash
    mvn clean package
    ```
4. Run application 
    ```
    java -cp target/smarty_logs_parser-1.0-SNAPSHOT.jar com.logs.Runner <fileName>
    ```
## Example:
    ```
    java -cp target/smarty_logs_parser-1.0-SNAPSHOT.jar com.logs.Runner myLogs.logs
    The number of unique IP addresses: 12
    The top 3 most visited URLs: [/asset.css, /docs/manage-websites/, /download/counter/]
    The top 3 most active IP addresses: [50.112.00.123, 168.41.191.40, 177.71.128.21]
    ```