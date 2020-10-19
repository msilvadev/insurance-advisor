package br.com.insuranceadvisor.usecases.rules;

import br.com.insuranceadvisor.models.Analysis;
import br.com.insuranceadvisor.models.RiskProfile;
import br.com.insuranceadvisor.usecases.Score;

public interface RulesStrategy {
    void executeRule(Analysis toAnalysis, RiskProfile riskProfile, Score score);
}
