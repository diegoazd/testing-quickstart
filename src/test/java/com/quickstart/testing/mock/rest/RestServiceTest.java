package com.quickstart.testing.mock.rest;

import com.quickstart.testing.config.RestConfig;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import software.betamax.Recorder;
import software.betamax.TapeMode;
import software.betamax.junit.Betamax;
import software.betamax.junit.RecorderRule;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={RestConfig.class})
public class RestServiceTest {

    @Autowired
    RestService restService;

    @Rule
    public RecorderRule recorder = new RecorderRule();

    @Test
    @Betamax(tape = "v1/mockTape", mode = TapeMode.READ_WRITE)
    public void shouldGetMessageFromApi() {
        final String s = restService.getMessage();
        System.out.println(s);
        final String shouldResponse = "{\n" +
                " \"msg\": \"Hello world!\"\n" +
                "}";
        assertEquals(shouldResponse, s);
    }
}