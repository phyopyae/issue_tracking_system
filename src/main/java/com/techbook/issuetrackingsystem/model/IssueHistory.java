package com.techbook.issuetrackingsystem.model;

import java.time.LocalDateTime;

import com.techbook.issuetrackingsystem.enums.ChangeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "issue_history")
public class IssueHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long historyId;
	
	@ManyToOne
	@JoinColumn(name = "issue_id", nullable = false)
	private Issue issue;
	
	@ManyToOne
	@JoinColumn(name = "changed_by", nullable = false)
	private User changedBy;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ChangeType changeType;
	
	@Column(columnDefinition = "TEXT")
	private String oldValue;
	
	@Column(columnDefinition = "TEXT")
	private String newValue;
	
	@Column(name = "changed_at", updatable = false)
	private LocalDateTime changedAt = LocalDateTime.now();

	@PrePersist
	protected void onCreate() {
		changedAt = LocalDateTime.now();
	}

	public Long getHistoryId() {
		return historyId;
	}

	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}

	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

	public User getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(User changedBy) {
		this.changedBy = changedBy;
	}

	public ChangeType getChangeType() {
		return changeType;
	}

	public void setChangeType(ChangeType changeType) {
		this.changeType = changeType;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public LocalDateTime getChangedAt() {
		return changedAt;
	}

	public void setChangedAt(LocalDateTime changedAt) {
		this.changedAt = changedAt;
	}
}
