package ink.ckx.monitor_tuning.chapter2;

import org.openjdk.btrace.core.BTraceUtils;
import org.openjdk.btrace.core.annotations.*;
import org.openjdk.btrace.core.types.AnyType;

@BTrace
public class PrintArgSimple {

    @OnMethod(
            clazz = "ink.ckx.monitor_tuning.chapter2.Ch2Controller",
            method = "arg1",
            location = @Location(Kind.ENTRY)
    )
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, AnyType[] args) {
        BTraceUtils.printArray(args);
        BTraceUtils.println(pcn + "," + pmn);
        BTraceUtils.println();
    }
}