package lucy.study.connectionredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisRunner implements ApplicationRunner {
    @Autowired
    StringRedisTemplate template;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ValueOperations<String, String> values = template.opsForValue();
        values.set("name", "lucy");
        values.set("framework", "spring");
        values.set("message", "hi");
    }
}
