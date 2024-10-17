package uz.keysoft.processmodules.jpapostgresadapter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Entity
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CUSTOMER")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  @Column(name = "FIRST_NAME")
  String firstName;
  @Column(name = "LAST_NAME")
  String lastName;

  @CreationTimestamp
  @Column(name = "CREATED_DATE", updatable = false)
  LocalDateTime createdDate;
  @UpdateTimestamp
  @Column(name = "UPDATED_DATE", insertable = false)
  LocalDateTime updatedDate;
  boolean isDeleted;

  @Override
  public final boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CustomerEntity that)) return false;

    return isDeleted() == that.isDeleted() && Objects.equals(getId(), that.getId()) && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getCreatedDate(), that.getCreatedDate());
  }

  @Override
  public int hashCode() {
    int result = Objects.hashCode(getId());
    result = 31 * result + Objects.hashCode(getFirstName());
    result = 31 * result + Objects.hashCode(getLastName());
    result = 31 * result + Objects.hashCode(getCreatedDate());
    result = 31 * result + Boolean.hashCode(isDeleted());
    return result;
  }
}
