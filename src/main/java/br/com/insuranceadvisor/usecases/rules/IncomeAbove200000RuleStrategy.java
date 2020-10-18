package br.com.insuranceadvisor.usecases.rules;

import br.com.insuranceadvisor.model.Analysis;
import br.com.insuranceadvisor.model.RiskProfile;
import br.com.insuranceadvisor.usecases.Score;

public class IncomeAbove200000RuleStrategy implements RulesStrategy{

    @Override
    public void executeRule(Analysis toAnalysis, RiskProfile riskProfile, Score score) {
        if (toAnalysis.getIncome() < 200_000) {
            score.setAuto(score.getAuto() - 1);
            score.setDisability(score.getDisability() - 1);
            score.setHome(score.getHome() - 1);
            score.setLife(score.getLife() - 1);
        }
    }
}
