package com.techbook.issuetrackingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techbook.issuetrackingsystem.model.Issue;
import com.techbook.issuetrackingsystem.repository.IssueRepository;

@Service
public class IssueService {

	@Autowired
	private IssueRepository issueRepository;

	public List<Issue> getAllIssues() {
		return issueRepository.findAll();
	}

	public Optional<Issue> getIssueById(Long id) {
		return issueRepository.findById(id);
	}

	public Issue saveIssue(Issue issue) {
		return issueRepository.save(issue);
	}

	public void deleteIssue(Long id) {
		issueRepository.deleteById(id);
	}

}
