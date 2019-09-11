package com.aris.ESD_Document.util;

import com.aris.ESD_Document.db.entities.Document;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.ISet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfiguration {

    @Bean
    public Config config(){
        return new Config();
    }

    @Bean
    public HazelcastInstance instance(Config config){
        return Hazelcast.newHazelcastInstance(config);
    }

    @Bean
    public IMap<Long, Document> mapOfDocument(HazelcastInstance instance){
        return instance.getMap("mapOfDocument");
    }

    @Bean
    public ISet<Document> setOfDocument(HazelcastInstance instance){
        return instance.getSet("setOfDocument");
    }
}
