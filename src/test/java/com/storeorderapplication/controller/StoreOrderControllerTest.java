package com.storeorderapplication.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.storeorderapplication.controller.StoreOrderController;
import com.storeorderapplication.service.StoreOrderService;
import com.storeorderapplication.util.FileConfigurer;


@WebMvcTest(controllers = StoreOrderController.class)
class StoreOrderControllerTest {
	
	@MockBean
	private FileConfigurer fileConfigurer;
	
	@MockBean
	private StoreOrderService storeOrderService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@DisplayName(value = "Test uploadFile Method")
	public void uploadFile() throws Exception {

		  MockMultipartFile file = new MockMultipartFile("file", "file.txt", "text/plain", "1".getBytes());

	      mockMvc.perform(MockMvcRequestBuilders.fileUpload("/api/uploadStoreOrder")
	                .file(file))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andReturn();
	}
}