package br.com.insuranceadvisor.usecases.rules;

import br.com.insuranceadvisor.model.Analysis;
import br.com.insuranceadvisor.model.RiskProfile;
import br.com.insuranceadvisor.usecases.Score;

public interface RulesStrategy {
    void executeRule(Analysis toAnalysis, RiskProfile riskProfile, Score score);
}
