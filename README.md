# SlackPool
SlackPool is a Slack App for creating simple pools in your workspace.

## Run the project
```bash
gradlew bootJar
```

## Project Overview
Project is a simple Spring Boot application. It uses [Bolt for Java](https://slack.dev/java-slack-sdk/guides/getting-started-with-bolt) in [socket mode](https://slack.dev/java-slack-sdk/guides/socket-mode).
Using socket mode means, that there is no need to expose any public API. 
Instead, **SlackCommandsController** is a class that is used as central entrypoint for handling all slack commands.

## Contributors
- [TomaszWegrzyn](https://github.com/TomaszWegrzyn)
- [grzy512](https://github.com/grzy512)

## License
[MIT](https://choosealicense.com/licenses/mit/)