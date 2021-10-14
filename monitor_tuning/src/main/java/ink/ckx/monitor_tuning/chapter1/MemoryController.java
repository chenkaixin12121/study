package ink.ckx.monitor_tuning.chapter1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author chenkaixin
 * @description
 * @since 2021/10/10
 */
@RestController
public class MemoryController {

    private List<User> userList = new ArrayList<>();

    private List<Class<?>> classList = new ArrayList<>();

    /**
     * -Xmx32M -Xms32M
     *
     * @return
     */
    @GetMapping("/heap")
    public String head() {
        int i = 0;
        while (true) {
            userList.add(new User("用户" + i++, UUID.randomUUID().toString()));
        }
    }

    /**
     * -XX:MetaspaceSize=32M -XX:MaxMetaspaceSize=32M
     *
     * @return
     */
    @GetMapping("/nonHeap")
    public String nonHeap() {
        while (true) {
            classList.addAll(Metaspace.createClasses());
        }
    }
}