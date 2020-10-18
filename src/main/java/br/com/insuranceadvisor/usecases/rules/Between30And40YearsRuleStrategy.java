package br.com.insuranceadvisor.usecases.rules;

import br.com.insuranceadvisor.model.Analysis;
import br.com.insuranceadvisor.model.RiskProfile;
import br.com.insuranceadvisor.usecases.Score;
import org.springframework.stereotype.Component;

@Component
public class Between30And40YearsRuleStrategy implements RulesStrategy{

    @Override
    public void executeRule(Analysis toAnalysis, RiskProfile riskProfile, Score score) {
        if (toAnalysis.getAge() >= 30 && toAnalysis.getAge() <= 40) {
            score.setAuto(-1);
            score.setDisability(-1);
            score.setHome(-1);
            score.setLife(-1);
        }
    }
}
