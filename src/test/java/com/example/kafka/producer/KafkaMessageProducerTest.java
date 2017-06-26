package com.example.kafka.producer;

import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static org.junit.Assert.*;

public class KafkaMessageProducerTest {

    @Test
    public void dateFormatTest() throws Exception {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        String timestampFull = now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL));
        String timestampLong = now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG));
        System.out.println(timestampFull);
        System.out.println(timestampLong);
        assertNotNull(timestampFull);
        assertNotNull(timestampLong);
    }
}