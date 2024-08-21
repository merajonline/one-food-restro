package org.example.restro.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishResponseDto {

    @JsonProperty("dishDtos")
    List<DishDto> dishDtos;

    @Override
    public String toString() {
        return Arrays.toString(new List[]{dishDtos});
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DishDto {

        private Long id;
        private Double price;
        private int dishAvailabilityStatus;
        private String itemName;
        private Long itemId;
        private Long restaurantId;
        private int restaurantStatus;
        private int maxItemProcessingCap;
        private int currItemProcessingCap;
        private Double restaurantRating;
        private int orderedQuantity;

    }

}
