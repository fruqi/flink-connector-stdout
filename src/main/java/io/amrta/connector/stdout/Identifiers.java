package io.amrta.connector.stdout;

import org.apache.flink.statefun.sdk.io.EgressIdentifier;
import org.apache.flink.statefun.sdk.reqreply.generated.TypedValue;

public final class Identifiers {
    public static final String NAMESPACE = "io.amrta.connector";
    public static final String EGRESS_NAME = "stdout";

    public static final EgressIdentifier<TypedValue> EGRESS_STDOUT = new EgressIdentifier<>(NAMESPACE, EGRESS_NAME, TypedValue.class);
}
