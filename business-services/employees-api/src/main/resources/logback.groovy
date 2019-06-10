import net.logstash.logback.appender.*
import net.logstash.logback.encoder.*

import static groovy.json.JsonOutput.toJson

def appenderList = []

appender("logstash", LogstashTcpSocketAppender) {
    encoder(LogstashEncoder)
    remoteHost = "localhost"
    port = 5000
}

appenderList << 'logstash'

appender("console", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger - %msg%n"
    }
}

appenderList << 'console'

root(INFO, appenderList)