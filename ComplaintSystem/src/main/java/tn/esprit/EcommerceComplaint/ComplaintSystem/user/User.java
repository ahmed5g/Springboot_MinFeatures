package tn.esprit.EcommerceComplaint.ComplaintSystem.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import tn.esprit.EcommerceComplaint.ComplaintSystem.complaint.Complaint;


import java.util.List;

@Data
@Entity
public class User {

    public enum UserRole{
        MODERATOR, CUSTOMER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true)
    private String username;

    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    // One-to-Many relationship with Complaints
    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
    private List<Complaint> complaints;
}
