package com.example.highload1.model.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull


@Entity
@Table(name = "user")
abstract class User: UserDetails {
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

    @Column(name = "role")
    private val role: Role? = null

    @JsonIgnore
    override fun getAuthorities(): Collection<GrantedAuthority?> {
        return setOf(SimpleGrantedAuthority(role!!.name))
    }
}