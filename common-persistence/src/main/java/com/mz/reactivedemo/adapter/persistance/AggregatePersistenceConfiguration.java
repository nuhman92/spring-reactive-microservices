package com.mz.reactivedemo.adapter.persistance;

import akka.actor.ActorSystem;
import com.mz.reactivedemo.adapter.persistance.impl.AggregateRepositoryImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AggregatePersistenceConfiguration {

  @Bean
  @Scope(BeanDefinition.SCOPE_SINGLETON)
  public ActorSystem actorSystem(@Value("${kafka.consumer.group-id}") String actorySystemName) {
    return ActorSystem.create(actorySystemName);
  }

  @Bean
  @Scope(BeanDefinition.SCOPE_PROTOTYPE)
  public AggregateRepository persistenceRepository(ActorSystem actorSystem) {
    return new AggregateRepositoryImpl(actorSystem);
  }
}
