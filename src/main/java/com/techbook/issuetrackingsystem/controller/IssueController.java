package com.techbook.issuetrackingsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techbook.issuetrackingsystem.model.Issue;
import com.techbook.issuetrackingsystem.service.IssueService;

@RestController
@RequestMapping("/issues")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @GetMapping
    public List<Issue> getAllIssues() {
        return issueService.getAllIssues();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Issue> getIssueById(@PathVariable Long id) {
        Optional<Issue> issue = issueService.getIssueById(id);
        return issue.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Issue> createIssue(@RequestBody Issue issue) {
    	Issue createdIssue = issueService.saveIssue(issue);
        return new ResponseEntity<>(createdIssue, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Issue> updateIssue(@PathVariable Long id, @RequestBody Issue issueDetails) {
        Optional<Issue> existingIssue = issueService.getIssueById(id);
        if (existingIssue.isPresent()) {
        	Issue issue = existingIssue.get();
            issue.setTitle(issueDetails.getTitle());
            issue.setDescription(issueDetails.getDescription());
            issue.setStatus(issueDetails.getStatus());
            issue.setPriority(issueDetails.getPriority());
            issue.setAssignee(issueDetails.getAssignee());
            issue.setReporter(issueDetails.getReporter());
            issue.setDueDate(issueDetails.getDueDate());
            issueService.saveIssue(issue);
            return ResponseEntity.ok(issue);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIssue(@PathVariable Long id) {
        if (issueService.getIssueById(id).isPresent()) {
            issueService.deleteIssue(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}

