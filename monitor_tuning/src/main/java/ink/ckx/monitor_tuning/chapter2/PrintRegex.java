package ink.ckx.monitor_tuning.chapter2;

import org.openjdk.btrace.core.BTraceUtils;
import org.openjdk.btrace.core.annotations.BTrace;
import org.openjdk.btrace.core.annotations.OnMethod;
import org.openjdk.btrace.core.annotations.ProbeClassName;
import org.openjdk.btrace.core.annotations.ProbeMethodName;

@BTrace
public class PrintRegex {

    @OnMethod(
            clazz = "ink.ckx.monitor_tuning.chapter2.Ch2Controller",
            method = "/.*/"
    )
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn) {
        BTraceUtils.println(pcn + "," + pmn);
        BTraceUtils.println();
    }
}
