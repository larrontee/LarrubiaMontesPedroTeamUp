package com.alixar.teamup.model;

import java.awt.Event;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class TeamEvent extends EventEntity {
	@ManyToMany
	@JoinTable(name = "event_teams", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "team_id"))
	private Set<TeamEntity> teams;

	@ManyToOne
	@JoinColumn(name = "winner_team_id")
	private TeamEntity winnerTeam;

}