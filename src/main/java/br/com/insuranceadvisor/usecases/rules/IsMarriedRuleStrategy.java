package br.com.insuranceadvisor.usecases.rules;

import br.com.insuranceadvisor.model.Analysis;
import br.com.insuranceadvisor.model.MaritalStatus;
import br.com.insuranceadvisor.model.RiskProfile;
import br.com.insuranceadvisor.usecases.Score;
import org.springframework.stereotype.Component;

@Component
public class IsMarriedRuleStrategy implements RulesStrategy{

    @Override
    public void executeRule(Analysis toAnalysis, RiskProfile riskProfile, Score score) {
        if (toAnalysis.getMaritalStatus() == MaritalStatus.MARRIED) {
            score.setLife(score.getLife() + 1);
            score.setDisability(score.getDisability() - 1);
        }
    }
}
