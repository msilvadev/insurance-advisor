package br.com.insuranceadvisor.usecases.rules;

import br.com.insuranceadvisor.model.Analysis;
import br.com.insuranceadvisor.model.OwnershipStatus;
import br.com.insuranceadvisor.model.RiskProfile;
import br.com.insuranceadvisor.usecases.Score;

public class MortgagedHouseRuleStrategy implements RulesStrategy{

    @Override
    public void executeRule(Analysis toAnalysis, RiskProfile riskProfile, Score score) {
        if (toAnalysis.getHouse().getOwnershipStatus() == OwnershipStatus.MORTGAGED) {
            score.setHome(score.getHome() + 1);
            score.setDisability(score.getDisability() + 1);
        }
    }
}
