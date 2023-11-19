package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriberModel {
    private int subscriberId;
    private String subscriberName;
    private String subscriberReference;
    private Integer borrowedBookId;
    private boolean borrow;
}
