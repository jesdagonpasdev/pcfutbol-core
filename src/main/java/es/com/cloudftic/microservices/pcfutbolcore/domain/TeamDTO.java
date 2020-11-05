package es.com.cloudftic.microservices.pcfutbolcore.domain;

import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TeamDTO {

    @NonNull
    private Integer id;

    private String name;
    private LocalDate foundationDate;
    private BigDecimal capital;

}
