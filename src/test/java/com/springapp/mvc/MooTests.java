package com.springapp.mvc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.WebApplicationContext;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class MooTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp(){
        this.mockMvc = webAppContextSetup(wac).build();
    }

    @Test
    public void testMoo() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/shop/daniel?age=24"));

        MvcResult mvcResult = resultActions.andReturn();
        String responseAsString = mvcResult.getResponse().getContentAsString();


        File file = new File("C:\\cygwin64\\home\\daniel.fernandes\\Code\\springMvc\\src\\test\\resources\\moo.json");

        if(!file.exists()){
            file.createNewFile();
        }

        FileOutputStream fileOutputStream = new FileOutputStream(file);

        fileOutputStream.write(
                responseAsString.getBytes()
        );

        fileOutputStream.flush();
        fileOutputStream.close();


    }
}
