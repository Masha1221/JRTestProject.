package com.example.demo.responses;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Accessors
@Setter
@Getter
@AllArgsConstructor
public class StatusResponse {

    private boolean oldStatus;
    private boolean newStatus;
    private Integer userId;


    public StatusResponse(int userId, Boolean newStatus, Boolean oldStatus) {
        this.userId = userId;
        this.newStatus = newStatus;
        this.oldStatus = oldStatus;
    }
}
