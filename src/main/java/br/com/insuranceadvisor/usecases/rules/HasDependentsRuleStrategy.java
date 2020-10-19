package br.com.insuranceadvisor.usecases.rules;

import br.com.insuranceadvisor.models.Analysis;
import br.com.insuranceadvisor.models.RiskProfile;
import br.com.insuranceadvisor.usecases.Score;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HasDependentsRuleStrategy implements RulesStrategy{
    private static final Logger LOGGER = LoggerFactory.getLogger(HasDependentsRuleStrategy.class);

    @Override
    public void executeRule(Analysis toAnalysis, RiskProfile riskProfile, Score score) {
        LOGGER.info("Called HasDependentsRuleStrategy!");

        if (toAnalysis.getDependents() > 0) {
            score.setDisability(score.getDisability() + 1);
            score.setLife(score.getLife() + 1);
        }
    }
}
