package com.example.demo;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class DemoApplicationTests {


	@Autowired
	private MockMvc mockMvc;

	@Test
	@Rollback(true)
	@WithMockUser
	void postTest1() throws Exception {

		String requestBody = "{\"weight\": 70.5, \"day\": 10, \"month\": \"March\", \"year\": 2024}";

		mockMvc.perform(post("/bodyweights/add")
						.contentType(MediaType.APPLICATION_JSON).content(requestBody))
						.andExpect(status().isCreated());
	}

}
