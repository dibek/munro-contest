package org.dibek.munro.controller;

import com.jayway.jsonpath.JsonPath;
import org.dibek.munro.MunroApplication;
import org.dibek.munro.service.MunroService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { MunroApplication.class })
@AutoConfigureMockMvc
@AutoConfigureRestDocs("build/generated-snippets")
@SpringBootTest
class MunroControllerTest {


    private static final Logger log = LoggerFactory.getLogger(MunroControllerTest.class);

    @Autowired
    private MockMvc mvc;

    protected MockMvc getMvc() {
        return mvc;
    }


    @Autowired
    MunroService munroService;

    @BeforeEach
    void setUp() {
        MunroController munroController = new MunroController(munroService);
        MockMvcBuilders.standaloneSetup(munroController);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void getAllMunros() throws Exception {
        ResultActions resultActions = getMvc().perform(MockMvcRequestBuilders.get("/v1/api/munros")
        .accept(MediaType.APPLICATION_JSON)
        );

        resultActions
        .andExpect(status().isOk())
        .andDo(document("munros"));
        String result = resultActions.andReturn().getResponse().getContentAsString();
        log.debug(result);
    }

    @Test
    public void getMunrosRange900_1000() throws Exception {
        getMvc().perform(MockMvcRequestBuilders.get("/v1/api/munros")
                .accept(MediaType.APPLICATION_JSON)
                .param("minHeight","1100")
                .param("maxHeight","1200")
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].gridRef").value(hasItem("NN971733")))
                .andExpect(jsonPath("$[*].name").value(hasItem("Ben More")))
                .andDo(document("munros-params"));
    }




}