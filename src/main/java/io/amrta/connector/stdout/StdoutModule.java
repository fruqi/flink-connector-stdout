package io.amrta.connector.stdout;

import com.google.auto.service.AutoService;
import org.apache.flink.statefun.flink.io.datastream.SinkFunctionSpec;
import org.apache.flink.statefun.sdk.io.EgressSpec;
import org.apache.flink.statefun.sdk.reqreply.generated.TypedValue;
import org.apache.flink.statefun.sdk.spi.StatefulFunctionModule;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

import java.util.Map;

@AutoService(StatefulFunctionModule.class)
public class StdoutModule implements StatefulFunctionModule {
    @Override
    public void configure(Map<String, String> map, Binder binder) {
        EgressSpec<TypedValue> spec = new SinkFunctionSpec<>(Identifiers.EGRESS_STDOUT, new SinkFunction<TypedValue>() {
            @Override
            public void invoke(TypedValue value, Context context) throws Exception {
                System.out.println("StdoutModule - value = " + value.getValue().toStringUtf8());
            }
        });

        binder.bindEgress(spec);
    }
}
