package tn.esprit.EcommerceComplaint.ComplaintSystem.complaint;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(value = "Complaint Controller", tags = { "Complaint" })
@Controller
@RequestMapping("/api/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;


    @ApiOperation(value = "Create a New Complaint", response = Complaint.class)
    @PostMapping(produces = "application/json")
    public ResponseEntity<Complaint> createComplaint(@RequestBody Complaint complaint) {
        Complaint createdComplaint = complaintService.createComplaint(complaint);
        return new ResponseEntity<>(createdComplaint, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get All Complaints", response = List.class)
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Complaint>> getAllComplaints() {
        List<Complaint> complaints = complaintService.getAllComplaints();
        return new ResponseEntity<>(complaints, HttpStatus.OK);
    }

    @ApiOperation(value = "Get Complaint Details by ID", response = Complaint.class)
    @GetMapping(value = "/{complaintId}", produces = "application/json")
    public ResponseEntity<Complaint> getComplaintById(@PathVariable Long complaintId) {
        Complaint complaint = complaintService.getComplaintById(complaintId);
        if (complaint == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(complaint, HttpStatus.OK);
    }

    @ApiOperation(value = "Update Complaint Status by ID", response = Complaint.class)
    @PutMapping(value = "/{complaintId}", produces = "application/json")
    public ResponseEntity<Complaint> updateComplaintStatus(
            @PathVariable Long complaintId,
            @RequestParam Complaint.ComplaintStatus newStatus) {
        Complaint updatedComplaint = complaintService.updateComplaintStatus(complaintId, newStatus);
        if (updatedComplaint == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedComplaint, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Complaint by ID")
    @DeleteMapping(value = "/{complaintId}")
    public ResponseEntity<Void> deleteComplaint(@PathVariable Long complaintId) {
        boolean deleted = complaintService.deleteComplaint(complaintId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
