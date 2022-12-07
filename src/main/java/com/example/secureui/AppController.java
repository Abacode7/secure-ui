package com.example.secureui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@Controller
public class AppController {
    @Autowired
    private WebClient webClient;

    @GetMapping("/")
    public String loadHome(){
        return "home";
    }

    @GetMapping("/details")
    public String loadDetails(Model m){
        Flux<TollStation> response = this.webClient.get()
        .uri("http://localhost:8082/api/tollStations")
        .retrieve()
        .bodyToFlux(TollStation.class);

        List<TollStation> tollStations = response.collectList().block();
        m.addAttribute("tollStations", tollStations);

        return "details";
    }
}
