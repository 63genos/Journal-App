package com.edigest.journalApp.cache;

import com.edigest.journalApp.entity.ConfigJournalAppEntity;
import com.edigest.journalApp.repository.ConfigJournalAppRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    public enum keys{
        WEATHER_API;
    }

    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

    public Map<String, String> appCache;


    @PostConstruct
    public void init(){
        appCache = new HashMap<>();
        List<ConfigJournalAppEntity> all = configJournalAppRepository.findAll();
//        System.out.println(all);
        for (ConfigJournalAppEntity configJournalAppEntity : all) {
            appCache.put(configJournalAppEntity.getKey(), configJournalAppEntity.getValue());
        }
//        System.out.println("here" + appCache.get("WEATHER_API"));
//        System.out.println(appCache.size());
//        for (Map.Entry<String, String> e : appCache.entrySet())
//            System.out.println("EKey: " + e.getKey()
//                    + " EValue: " + e.getValue());
    }

}