package es.com.cloudftic.microservices.pcfutbolcore.domain;

import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TeamDTO {

    public TeamDTO() {}

    @NonNull
    private Integer id;

    private String name;
    private LocalDate foundationDate;
    private BigDecimal capital;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("_______________");
        sb.append("\n");
        sb.append("ID: " + id);
        sb.append("\n");
        sb.append("Nombre: " + name);
        sb.append("\n");
        sb.append("Fecha de fundación: " + foundationDate);
        sb.append("\n");
        sb.append("Capital: " + capital);
        sb.append("\n");
        sb.append("_______________");

        return sb.toString();
    }
}
