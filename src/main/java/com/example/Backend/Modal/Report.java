package com.example.Backend.Modal;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "report")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reporter_id", nullable = false)
    private User reporter; // Người báo cáo

    @ManyToOne
    @JoinColumn(name = "reported_user_id", nullable = false)
    private User reportedUser; // Người bị báo cáo

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post; // Bài viết bị báo cáo (nếu có)

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment; // Bình luận bị báo cáo (nếu có)

    @Column(name = "reason", nullable = false, length = 500)
    private String reason; // Lý do báo cáo

    @Column(name = "report_time", nullable = false)
    private LocalDateTime reportTime; // Thời gian báo cáo

    @Column(name = "status", nullable = false)
    private String status; // Trạng thái xử lý (PENDING, APPROVED, REJECTED)
}