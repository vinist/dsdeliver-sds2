package com.github.vinist.dsdeliver.dto;

import com.github.vinist.dsdeliver.entities.Order;
import com.github.vinist.dsdeliver.entities.OrderStatus;
import com.github.vinist.dsdeliver.entities.Product;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
public class OrderDto implements Serializable {
    
    private Long id;
    private String address;
    private Double latitude;
    private Double longitude;
    private Instant moment;
    private OrderStatus status;
    
    @Setter(AccessLevel.NONE)
    private List<ProductDto> products = new ArrayList<>();
    
    public OrderDto(Order entity) {
        this.id = entity.getId();
        this.address = entity.getAddress();
        this.latitude = entity.getLatitude();
        this.longitude = entity.getLongitude();
        this.moment = entity.getMoment();
        this.status = entity.getStatus();
        this.products = entity.getProducts().stream().map(ProductDto::new).collect(Collectors.toList());
    }
}
