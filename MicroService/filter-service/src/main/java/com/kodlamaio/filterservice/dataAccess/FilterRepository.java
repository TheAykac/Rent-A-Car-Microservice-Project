package com.kodlamaio.filterservice.dataAccess;

import com.kodlamaio.filterservice.entities.Filter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FilterRepository extends MongoRepository<Filter, String> {

    List<Filter> getFilterByBrandName(String name);

    List<Filter> getFilterByDailyPrice(double dailyPrice);

    List<Filter> getFilterByModelname(String modelName);

    List<Filter> getFilterByDailyPriceGreaterThanEqual(double dailyPrice);

    List<Filter> getFilterByDailyPriceLessThanEqual(double dailyPrice);

    List<Filter> getFiltersByBrandNameOrModelname(String brandName, String modelName);
}
