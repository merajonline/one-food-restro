package org.example.restro.repository;

import org.example.restro.model.Dish;
import org.example.restro.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

    List<Dish> findAllByItemIdIn(List<Long> itemIds);

    List<Dish> findAllByItemIdInAndAvailabilityStatus(List<Long> itemIds, int availabilityStatus);

    Optional<Dish> findAllByItem(Item item);

    List<Dish> findAllByRestaurantId(Long restaurantId);

}
