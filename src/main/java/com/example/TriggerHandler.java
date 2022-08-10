package com.example;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.TimerTrigger;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

import java.util.Optional;

public class TriggerHandler extends FunctionInvoker<Object, Object> {


    @FunctionName("timerTrigger")
    public void execute(
            @TimerTrigger(name = "timerInfo", schedule = "0 */5 * * * *") String timerInfo,
            final ExecutionContext context
    ) {
        handleRequest (Optional.of(Object.class), context);
    }
}