package br.com.insuranceadvisor.usecases.rules;

import br.com.insuranceadvisor.models.Analysis;
import br.com.insuranceadvisor.models.RiskProfile;
import br.com.insuranceadvisor.usecases.Score;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class VehicleProducedLast5YearsRuleStrategy implements RulesStrategy{

    private static final Logger LOGGER = LoggerFactory.getLogger(VehicleProducedLast5YearsRuleStrategy.class);

    @Override
    public void executeRule(Analysis toAnalysis, RiskProfile riskProfile, Score score) {
        LOGGER.info("Called VehicleProducedLast5YearsRuleStrategy!");

        if (LocalDate.now().getYear() - toAnalysis.getVehicle().getYear() <= 5){
            score.setAuto(score.getAuto() + 1);
        }
    }
}
