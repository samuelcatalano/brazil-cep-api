package org.acme.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class LondonAddress implements Serializable {

    @JsonProperty("postcode")
    private String postcode;
    @JsonProperty("country")
    private String country;
    @JsonProperty("region")
    private String region;
    @JsonProperty("admin_district")
    private String adminDistrict;
    @JsonProperty("admin_ward")
    private String adminWard;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("latitude")
    private Double latitude;

}
