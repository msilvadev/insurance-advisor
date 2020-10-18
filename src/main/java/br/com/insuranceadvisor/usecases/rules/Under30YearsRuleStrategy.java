package br.com.insuranceadvisor.usecases.rules;

import br.com.insuranceadvisor.model.Analysis;
import br.com.insuranceadvisor.model.RiskProfile;
import br.com.insuranceadvisor.usecases.Score;
import org.springframework.stereotype.Component;

@Component
public class Under30YearsRuleStrategy implements RulesStrategy{

    @Override
    public void executeRule(Analysis toAnalysis, RiskProfile riskProfile, Score score) {
        if (toAnalysis.getAge() > 30) {
            score.setAuto(-2);
            score.setDisability(-2);
            score.setHome(-2);
            score.setLife(-2);
        }
    }
}
