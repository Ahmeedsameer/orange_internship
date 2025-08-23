    package com.managment.system.entites;

    import com.fasterxml.jackson.annotation.JsonIgnore;
    import jakarta.persistence.*;

    import java.time.LocalDate;


    @Entity
    @Table(name = "task")
    public class Task {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        @Column(nullable = false)
        private String taskname;
        @Column
        private String title;
        @Column
        private String descraption;
        @Column
        @Enumerated(EnumType.STRING)
        private Status status;
        @ManyToOne
        @JoinColumn(name = "user",nullable = false)
        @JsonIgnore
       private User user;
        @Column(name = "due_date")
        private LocalDate dueDate;


        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTaskname() {
            return taskname;
        }

        public void setTaskname(String taskname) {
            this.taskname = taskname;
        }

        public String getDescraption() {
            return descraption;
        }

        public void setDescraption(String descraption) {
            this.descraption = descraption;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public LocalDate getDueDate() {
            return dueDate;
        }

        public void setDueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
        }
    }
