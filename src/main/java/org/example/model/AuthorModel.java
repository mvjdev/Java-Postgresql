package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data /*@Getter,@Setter,@hashcode,@equals,@toString*/
@AllArgsConstructor
@NoArgsConstructor
public class AuthorModel {
    private int authorId;
    private String authorName;
    private char genderAuthor;
}
