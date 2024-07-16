package com.edigest.journalApp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "config_journal_app")
@Data
@NoArgsConstructor
public class ConfigJournalAppEntity {

    @Id
    private ObjectId id;
    @NonNull
    @Indexed(unique = true)
    private String key;
    @NonNull
    private String value;

}

