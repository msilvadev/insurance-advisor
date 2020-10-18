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
            score.setAuto(score.getAuto() - 1);
            score.setDisability(score.getDisability() - 1);
            score.setHome(score.getHome() - 1);
            score.setLife(score.getLife() - 1);
        }
    }
}
