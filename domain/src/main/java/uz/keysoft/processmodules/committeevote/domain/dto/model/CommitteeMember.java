package uz.keysoft.processmodules.committeevote.domain.dto.model;


import static lombok.AccessLevel.PRIVATE;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class CommitteeMember implements Serializable {
  String id;
  String firstName;
  String lastName;
}
