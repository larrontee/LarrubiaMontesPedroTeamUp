package com.alixar.teamup.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class UserEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(nullable = false)
   private String username;

   @Column(nullable = false)
   private String password;

   @Column(nullable = false)
   private String name;

   @Column(nullable = false)
   private String surnames;

   @Column(nullable = false)
   private String email;

   private String profilePhoto;

   @Column(nullable = false)
   private LocalDate birthdate;

   private String description;
   
   @Column(nullable = false)
   @ManyToMany(fetch = FetchType.EAGER, targetEntity = RoleEntity.class, cascade = CascadeType.PERSIST)
   @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
   private Set<RoleEntity> roles;
   
   @ManyToMany
   private Set<UserEntity> amigos;
   
   
   

   
   @OneToMany(mappedBy = "remitente")
   private Set<RequestEntity> solicitudesEnviadas;

   @OneToMany(mappedBy = "destinatario")
   private Set<RequestEntity> solicitudesRecibidas;
   
// private Set<TeamEntity> equiposCreados;
// private Set<TeamEntity> equiposUnidos;
// 
// @OneToMany(mappedBy = "creator_id")
// private Set<EventEntity> eventsCreados;

 
// @OneToMany()
// private Set<EventEntity> eventosUnidos;
   
//   
   
   


}
