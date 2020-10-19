package br.com.insuranceadvisor.usecases.rules;

import br.com.insuranceadvisor.models.Analysis;
import br.com.insuranceadvisor.models.OwnershipStatus;
import br.com.insuranceadvisor.models.RiskProfile;
import br.com.insuranceadvisor.usecases.Score;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MortgagedHouseRuleStrategy implements RulesStrategy{

    private static final Logger LOGGER = LoggerFactory.getLogger(MortgagedHouseRuleStrategy.class);

    @Override
    public void executeRule(Analysis toAnalysis, RiskProfile riskProfile, Score score) {
        LOGGER.info("Called MortgagedHouseRuleStrategy!");

        if (toAnalysis.getHouse().getOwnershipStatus() == OwnershipStatus.MORTGAGED) {
            score.setHome(score.getHome() + 1);
            score.setDisability(score.getDisability() + 1);
        }
    }
}
