package com.techbook.issuetrackingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techbook.issuetrackingsystem.model.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long> {

}
