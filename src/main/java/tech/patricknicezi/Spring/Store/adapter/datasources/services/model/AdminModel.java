package tech.patricknicezi.Spring.Store.adapter.datasources.services.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GeneratedColumn;

import java.time.OffsetDateTime;

@Table(name = "admins")
@Entity(name = "AdminPostgres")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class AdminModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;

    @Column(name = "phone_number")
    private String phone;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;


}
