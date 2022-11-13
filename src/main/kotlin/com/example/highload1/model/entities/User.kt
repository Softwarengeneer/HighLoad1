package com.example.highload1.model.entities

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull



@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
abstract class User {
    @Id
    @Column(name = "id")
    private var id: Int? = null;

    @Column(name = "name")
    @NotNull
    private var name: String? = null;

    @Column(name = "balance")
    private var balance: Double? = null;

    @Column(name = "collection")
    private var collection: String? = null;
}