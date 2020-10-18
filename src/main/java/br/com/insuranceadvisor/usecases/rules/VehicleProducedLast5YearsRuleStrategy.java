package br.com.insuranceadvisor.usecases.rules;

import br.com.insuranceadvisor.model.Analysis;
import br.com.insuranceadvisor.model.RiskProfile;
import br.com.insuranceadvisor.usecases.Score;

import java.time.LocalDate;

public class VehicleProducedLast5YearsRuleStrategy implements RulesStrategy{

    @Override
    public void executeRule(Analysis toAnalysis, RiskProfile riskProfile, Score score) {
        if (LocalDate.now().getYear() - toAnalysis.getVehicle().getYear() > 5){
            score.setAuto(score.getAuto() + 1);
        }
    }
}
