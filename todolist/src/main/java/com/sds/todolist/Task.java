package com.sds.todolist;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Task {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(length = 20)
        private String owner;

        @Column(length = 100, columnDefinition = "TEXT", nullable = false)
        private String content;

        @Column(length = 20)
        private String status;

        @Column(nullable = false)
        private LocalDateTime created_date;

        @Column(nullable = false)
        private LocalDateTime modified_date;

//        @Builder
//        public TASK(String title, String content, String author) {
//            this.title = title;
//            this.content = content;
//            this.author = author;
//        }

}
