package com.microbrew.msscbeerservice.msscbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microbrew.msscbeerservice.msscbeerservice.web.model.BeerDto;
import com.microbrew.msscbeerservice.msscbeerservice.web.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

  @Autowired MockMvc mockMvc;

  @Autowired ObjectMapper objectMapper;

  @Test
  void getBeerById() throws Exception {
    mockMvc
        .perform(get("/api/v1/beer/" + UUID.randomUUID()).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void saveBeer() throws Exception {
    BeerDto beerDto = getValidBeerDto();
    String beerToJson = objectMapper.writeValueAsString(beerDto);
    mockMvc
        .perform(post("/api/v1/beer").contentType(MediaType.APPLICATION_JSON).content(beerToJson))
        .andExpect(status().isCreated());
  }

  @Test
  void updateBeerById() throws Exception {
    BeerDto beerDto = getValidBeerDto();
    String beerToJson = objectMapper.writeValueAsString(beerDto);
    mockMvc
        .perform(
            put("/api/v1/beer/" + UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerToJson))
        .andExpect(status().isNoContent());
  }

  BeerDto getValidBeerDto() {
    return BeerDto.builder()
        .beerName("New one")
        .beerStyle(BeerStyleEnum.ALE)
        .price(new BigDecimal("2.90"))
        .upc(12312312312L)
        .build();
  }
}