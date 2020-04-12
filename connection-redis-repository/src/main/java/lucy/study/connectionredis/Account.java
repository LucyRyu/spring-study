package lucy.study.connectionredis;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("accounts")
@Data
public class Account {

    @Id
    String id;
    private String username;
    private String email;

}
