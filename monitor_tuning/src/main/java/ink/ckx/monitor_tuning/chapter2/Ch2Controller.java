package ink.ckx.monitor_tuning.chapter2;

import ink.ckx.monitor_tuning.chapter1.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 1. 下载 btrace：https://github.com/btraceio/btrace/releases/tag/v2.0.0
 * 2. 添加 D:\btrace-v2.2.0-bin\libs 目录下的三个 jar 包
 */
@RestController
@RequestMapping("/ch2")
public class Ch2Controller {

    @RequestMapping("/arg1")
    public String arg1(@RequestParam("name") String name) {
        return "hello," + name;
    }

    @RequestMapping("/arg2")
    public User arg2(User user) {
        return user;
    }

    @RequestMapping("/constructor")
    public User constructor(User user) {
        return user;
    }

    @RequestMapping("/same1")
    public String same(@RequestParam("name") String name) {
        return "hello," + name;
    }

    @RequestMapping("/same2")
    public String same(@RequestParam("name") String name, @RequestParam("id") int id) {
        return "hello," + name + "," + id;
    }

    @RequestMapping("/exception")
    public String exception() {
        try {
            System.out.println("start...");
            System.out.println(1 / 0);
            System.out.println("end...");
        } catch (Exception e) {
            //
        }
        return "success";
    }
}