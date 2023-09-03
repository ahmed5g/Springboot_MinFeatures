package tn.esprit.EcommerceComplaint.ComplaintSystem.complaint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComplaintService {

    @Autowired
    private  ComplaintRepository complaintRepository;


    public Complaint createComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    public Complaint getComplaintById(Long complaintId) {
        return complaintRepository.findById(complaintId).orElse(null);
    }

    public Complaint updateComplaintStatus(Long complaintId, Complaint.ComplaintStatus newStatus) {
        Complaint complaint = complaintRepository.findById(complaintId).orElse(null);
        if (complaint != null) {
            complaint.setStatus(newStatus);
            return complaintRepository.save(complaint);
        }
        return null;
    }

    public boolean deleteComplaint(Long complaintId) {
        if (complaintRepository.existsById(complaintId)) {
            complaintRepository.deleteById(complaintId);
            return true;
        }
        return false;
    }
}

