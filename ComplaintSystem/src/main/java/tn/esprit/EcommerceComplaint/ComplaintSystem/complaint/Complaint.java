package tn.esprit.EcommerceComplaint.ComplaintSystem.complaint;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.Data;
import tn.esprit.EcommerceComplaint.ComplaintSystem.user.User;



@Data
@Entity
public class Complaint {

    public enum ComplaintStatus{
        On_Hold, APPROVED, DECLINED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long complaintId;

    private String orderId;

    private String description;

    @Enumerated(EnumType.STRING)
    private ComplaintStatus status;

    // Many-to-One relationship with User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdBy;
}

