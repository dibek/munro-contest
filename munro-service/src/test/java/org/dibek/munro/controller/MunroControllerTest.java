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

import static org.assertj.core.api.Assertions.not;
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
                .param("category", "top")
                .param("sort","name")
                .param("direction","DESC")
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].gridRef").value(hasItem("NN246729")))
                .andExpect(jsonPath("$[*].name").value(hasItem("Mam Sodhail - Ciste Dhubh")))
                .andDo(document("munros-params"));
    }

    @Test
    public void getMunroCategoryTOP() throws Exception {
        getMvc().perform(MockMvcRequestBuilders.get("/v1/api/munros")
                .accept(MediaType.APPLICATION_JSON)
                .param("minHeight","1100")
                .param("maxHeight","1200")
                .param("category", "top")
                .param("sort","name")
                .param("direction","DESC")
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].category").value(hasItem("TOP")))
                .andDo(document("munros-params"));
    }

    @Test
    public void getMunroCategoryMUN() throws Exception {
        getMvc().perform(MockMvcRequestBuilders.get("/v1/api/munros")
                .accept(MediaType.APPLICATION_JSON)
                .param("minHeight","1100")
                .param("maxHeight","1200")
                .param("category", "mun")
                .param("sort","name")
                .param("direction","DESC")
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].category").value(hasItem("MUN")))
                .andDo(document("munros-params"));
    }

    @Test
    public void getMunroCategorySortByHeightAsc() throws Exception {
        getMvc().perform(MockMvcRequestBuilders.get("/v1/api/munros")
                .accept(MediaType.APPLICATION_JSON)
                .param("sort","heightMeter")
                .param("direction","ASC")
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].heightMeter").value("899"))
                .andDo(document("munros-params"));
    }

    @Test
    public void getMunroCategorySortByHeightDesc() throws Exception {
        getMvc().perform(MockMvcRequestBuilders.get("/v1/api/munros")
                .accept(MediaType.APPLICATION_JSON)
                .param("sort","heightMeter")
                .param("direction","DESC")
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].heightMeter").value("1344.53"))
                .andDo(document("munros-params"));
    }

    @Test
    public void getMunroCategorySortByNameAsc() throws Exception {
        getMvc().perform(MockMvcRequestBuilders.get("/v1/api/munros")
                .accept(MediaType.APPLICATION_JSON)
                .param("sort","name")
                .param("direction","ASC")
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("A' Bhuidheanach Bheag"))
                .andDo(document("munros-params"));
    }

    @Test
    public void getMunroCategorySortByNameDesc() throws Exception {
        getMvc().perform(MockMvcRequestBuilders.get("/v1/api/munros")
                .accept(MediaType.APPLICATION_JSON)
                .param("sort","name")
                .param("direction","DESC")
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Tom a' Choinich - Tom a' Choinich Beag"))
                .andDo(document("munros-params"));
    }

}