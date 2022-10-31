package com.sds.todolist.web.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Task {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(length = 20, nullable = false)
        private String owner;

        @Column(length = 100, nullable = false)
        private String content;

        @Column(length = 20,nullable = false)
        private String status;

        @Column(nullable = false)
        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        private LocalDateTime created_date;

        @Column(nullable = true)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        private LocalDateTime modified_date;

        @Builder
        public Task(String owner, String content, String status, LocalDateTime created_date, LocalDateTime modified_date) {
            this.owner = owner;
            this.content = content;
            this.status = status;
            this.created_date=created_date;
            this.modified_date=modified_date;
        }

        public void update(String content,String status,LocalDateTime modified_date){
                this.content=content;
                this.status=status;
                this.modified_date=modified_date;
        }

}
