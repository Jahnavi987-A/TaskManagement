package com.example.TaskManagement.model;

// import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
// import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(max=100,message = "Title cannot exceed 100 characters.")
    private String title;

    @Size(max=500,message="Description cannot exceed 500 characters.")
    private String description;

    @Future(message = "Deadline must be in future.")
    private LocalDateTime deadline;

    @NotBlank(message = "Priority cannot be emoty.")
    private String priority;

    @NotBlank(message = "Status cannot be emoty.")
    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
