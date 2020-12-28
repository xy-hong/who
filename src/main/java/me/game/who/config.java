package me.game.who;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class config {

    @Bean
    ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
