package br.com.insuranceadvisor.usecases.rules;

import br.com.insuranceadvisor.model.Analysis;
import br.com.insuranceadvisor.model.RiskProfile;
import br.com.insuranceadvisor.usecases.Score;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Under30YearsRuleStrategy implements RulesStrategy{

    private static final Logger LOGGER = LoggerFactory.getLogger(Under30YearsRuleStrategy.class);

    @Override
    public void executeRule(Analysis toAnalysis, RiskProfile riskProfile, Score score) {
        LOGGER.info("Called Under30YearsRuleStrategy!");

        if (toAnalysis.getAge() < 30) {
            score.setAuto(score.getAuto() - 2);
            score.setDisability(score.getDisability() - 2);
            score.setHome(score.getHome() - 2);
            score.setLife(score.getLife() - 2);
        }
    }
}
