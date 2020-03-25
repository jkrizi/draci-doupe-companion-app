package net.homecredit.trainee.drd.util;

import net.homecredit.trainee.drd.util.Dice;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class BeanConfiguration {
    @Bean
    public Dice dice(Random random) {
        return new Dice(random);
    }

    @Bean
    public Random random() {
        return new Random();
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
