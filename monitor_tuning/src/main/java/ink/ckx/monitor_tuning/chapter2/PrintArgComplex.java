package ink.ckx.monitor_tuning.chapter2;

import ink.ckx.monitor_tuning.chapter1.User;
import org.openjdk.btrace.core.BTraceUtils;
import org.openjdk.btrace.core.annotations.*;

import java.lang.reflect.Field;

@BTrace
public class PrintArgComplex {

    @OnMethod(
            clazz = "ink.ckx.monitor_tuning.chapter2.Ch2Controller",
            method = "arg2",
            location = @Location(Kind.ENTRY)
    )
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, User user) {
        //print all fields
        BTraceUtils.printFields(user);
        //print one field
        Field filed2 = BTraceUtils.field("ink.ckx.monitor_tuning.chapter2.User", "name");
        BTraceUtils.println(BTraceUtils.get(filed2, user));
        BTraceUtils.println(pcn + "," + pmn);
        BTraceUtils.println();
    }
}