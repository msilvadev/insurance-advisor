package br.com.insuranceadvisor.usecases.rules;

import br.com.insuranceadvisor.models.Analysis;
import br.com.insuranceadvisor.models.MaritalStatus;
import br.com.insuranceadvisor.models.RiskProfile;
import br.com.insuranceadvisor.usecases.Score;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class IsMarriedRuleStrategy implements RulesStrategy{

    private static final Logger LOGGER = LoggerFactory.getLogger(IsMarriedRuleStrategy.class);

    @Override
    public void executeRule(Analysis toAnalysis, RiskProfile riskProfile, Score score) {
        LOGGER.info("Called IsMarriedRuleStrategy!");
        if (toAnalysis.getMaritalStatus() == MaritalStatus.MARRIED) {
            score.setLife(score.getLife() + 1);
            score.setDisability(score.getDisability() - 1);
        }
    }
}
