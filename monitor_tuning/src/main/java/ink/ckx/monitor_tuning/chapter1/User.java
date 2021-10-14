package ink.ckx.monitor_tuning.chapter1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenkaixin
 * @description
 * @since 2021/10/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String username;

    private String password;
}