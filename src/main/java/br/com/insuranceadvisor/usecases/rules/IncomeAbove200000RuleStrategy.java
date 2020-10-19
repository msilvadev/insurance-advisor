package br.com.insuranceadvisor.usecases.rules;

import br.com.insuranceadvisor.models.Analysis;
import br.com.insuranceadvisor.models.RiskProfile;
import br.com.insuranceadvisor.usecases.Score;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class IncomeAbove200000RuleStrategy implements RulesStrategy{

    private static final Logger LOGGER = LoggerFactory.getLogger(IncomeAbove200000RuleStrategy.class);

    @Override
    public void executeRule(Analysis toAnalysis, RiskProfile riskProfile, Score score) {
        LOGGER.info("Called IncomeAbove200000RuleStrategy!");

        if (toAnalysis.getIncome() > 200000) {
            score.setAuto(score.getAuto() - 1);
            score.setDisability(score.getDisability() - 1);
            score.setHome(score.getHome() - 1);
            score.setLife(score.getLife() - 1);
        }
    }
}
