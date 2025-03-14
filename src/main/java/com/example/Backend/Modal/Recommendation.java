package com.example.Backend.Modal;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recommendation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Người nhận đề xuất

    @ManyToOne
    @JoinColumn(name = "recommended_user_id", nullable = false)
    private User recommendedUser; // Người được đề xuất kết bạn

    @Column(name = "score", nullable = false)
    private Double score; // Điểm số đề xuất dựa trên thuật toán

}