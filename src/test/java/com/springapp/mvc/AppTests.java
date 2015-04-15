package com.springapp.mvc;

import com.google.gson.Gson;
import com.springapp.entity.Shop;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class AppTests {
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void simple() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/shop/daniel?age=24.9"));

        MvcResult mvcResult = resultActions.andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        String responseContentAsString = response.getContentAsString();

        assertEquals("bla", responseContentAsString);

        System.out.println(responseContentAsString);

        resultActions.andExpect(status().isOk());

        Gson gson = new Gson();
        Shop expectedShop = new Shop();
        expectedShop.setName("daniel is24.9 years old");


        resultActions.andExpect(content().json(gson.toJson(expectedShop)));

        //resultActions.andExpect(view().name("hello"));
    }
}
