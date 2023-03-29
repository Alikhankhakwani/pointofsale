package com.example.pointofsale.Model;

import com.example.pointofsale.entity.Pricing;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include. NON_NULL)
public class PricingModel {
    private Long pricingId;

    private String pricingAmount;

    public Pricing disassemble() {
        Pricing pricing = new Pricing();
        pricing.setPricingId(pricingId);
        pricing.setPricingAmount(pricingAmount);
        return pricing;
    }
    public PricingModel assemble(Pricing pricing){
        PricingModel pricingModel=new PricingModel();
        pricingModel.setPricingId(pricing.getPricingId());
        pricingModel.setPricingAmount(pricing.getPricingAmount());

        return pricingModel;

    }
}
