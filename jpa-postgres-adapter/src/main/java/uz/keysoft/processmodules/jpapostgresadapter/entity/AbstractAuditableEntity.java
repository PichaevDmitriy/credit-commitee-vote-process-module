package uz.keysoft.processmodules.jpapostgresadapter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AbstractAuditableEntity extends AbstractEntity {
  @CreationTimestamp
  @Column(name = "CREATED_DATE", updatable = false)
  LocalDateTime createdDate;
  @UpdateTimestamp
  @Column(name = "UPDATED_DATE", insertable = false)
  LocalDateTime updatedDate;
  boolean isDeleted;

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final AbstractAuditableEntity that = (AbstractAuditableEntity) o;
    return isDeleted == that.isDeleted && this.getId().equals(that.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getId(), isDeleted);
  }
}
