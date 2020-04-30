package com.example.demo.products;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public double countPrice(){
        List<Double> allPrices = products.stream()
                .map(price->price.getPrice())
                .collect(Collectors.toList());

      double sum =  allPrices.stream()
              .reduce(0.0, Double::sum);
        return sum;
    }

    public List<Product> findAll() {
        return new ArrayList<>(this.products);
    }

    public void add(Product product) {
        products.add(product);
    }

}
