package lucy.study.connectionredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RedisRunner implements ApplicationRunner {
    @Autowired
    StringRedisTemplate template;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ValueOperations<String, String> values = template.opsForValue();
        values.set("name", "lucy");
        values.set("framework", "spring");
        values.set("message", "hi");

        Account account = new Account();
        account.setEmail("loveyou_06@naver.com");
        account.setUsername("lucy");

        accountRepository.save(account);

        Optional<Account> getById = accountRepository.findById(account.getId());
        System.out.println(getById.orElse(new Account()).getUsername());
        System.out.println(getById.orElse(new Account()).getEmail());
    }
}


