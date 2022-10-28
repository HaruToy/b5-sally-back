package com.sds.todolist.web;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Todo {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(length = 20, nullable = false)
        private String owner;

        @Column(length = 100, columnDefinition = "TEXT", nullable = false)
        private String content;

        @Column(length = 20)
        private String status;

        @Column(nullable = true)
        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        private LocalDateTime created_date;

        @Column(nullable = true)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        private LocalDateTime modified_date;

        @Builder
        public Todo(String owner, String content, String status, LocalDateTime created_date) {
            this.owner = owner;
            this.content = content;
            this.status = status;
            this.created_date=created_date;
        }

        public void update(String content,String status,LocalDateTime modified_date){
                this.content=content;
                this.status=status;
                this.modified_date=modified_date;
        }

}
