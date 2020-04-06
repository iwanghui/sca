package com.wh.sca.gw.repository;

import com.alibaba.fastjson.JSON;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class ApolloRouteDefinitionRepository implements RouteDefinitionRepository {


    @ApolloConfig("sca-route-list.json")
    Config config;

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        String definitionJson = config.getProperty("content","");
        List<RouteDefinition> rs = JSON.parseArray(definitionJson,RouteDefinition.class);
        return Flux.fromIterable(rs);
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return null;
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return null;
    }
}
