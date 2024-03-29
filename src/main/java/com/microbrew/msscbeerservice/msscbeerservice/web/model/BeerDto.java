package com.microbrew.msscbeerservice.msscbeerservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
//todo mapper added and circle ci as well
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

  @Null private UUID id;

  @Null private Integer version;

  @Null private OffsetDateTime createdDate;

  @Null private OffsetDateTime lastModifiedDate;

  @NotBlank private String beerName;
  @NotNull private BeerStyleEnum beerStyle;
  @Positive private Long upc;

  @NotNull private BigDecimal price;
  @Positive private Integer quantityOnHand;
}
