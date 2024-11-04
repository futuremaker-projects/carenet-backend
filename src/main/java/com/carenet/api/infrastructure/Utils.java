package com.carenet.api.infrastructure;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static <T> OrderSpecifier[] getOrderList(Sort sort, Class<T> clazz) {
        List<OrderSpecifier> orders = new ArrayList<>();
        sort.stream().forEach(order -> {
            Order direction = order.isAscending() ? Order.ASC : Order.DESC;
            PathBuilder pathBuilder = new PathBuilder(clazz, convertLowercaseFirstChar(clazz.getSimpleName()));
            orders.add(new OrderSpecifier(direction, pathBuilder.get(order.getProperty())));
        });
        return orders.toArray(OrderSpecifier[]::new);
    }

    public static String convertLowercaseFirstChar(String className) {
        return Character.toLowerCase(className.charAt(0)) + className.substring(1);
    }

    public static <T> Boolean hasNext(List<T> contents, int pageSize) {
        if (contents.size() > pageSize) {
            contents.remove(pageSize);
            return true;
        }
        return false;
    }

}
