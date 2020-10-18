package br.com.insuranceadvisor.usecases;

import br.com.insuranceadvisor.model.Analysis;
import br.com.insuranceadvisor.model.RiskProfile;
import br.com.insuranceadvisor.usecases.rules.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ScoreRulesProfile {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScoreRulesProfile.class);

    private final IneligibleRuleStrategy ineligibleRuleStrategy;

    private final Under30YearsRuleStrategy under30YearsRuleStrategy;

    private final Between30And40YearsRuleStrategy between30And40YearsRuleStrategy;

    private final IncomeAbove200000RuleStrategy incomeAbove200000RuleStrategy;

    private final MortgagedHouseRuleStrategy mortgagedHouseRuleStrategy;

    private final HasDependentsRuleStrategy hasDependentsRuleStrategy;

    private final IsMarriedRuleStrategy isMarriedRuleStrategy;

    private final VehicleProducedLast5YearsRuleStrategy vehicleProducedLast5YearsRuleStrategy;

    public ScoreRulesProfile(IneligibleRuleStrategy ineligibleRuleStrategy,
                             Under30YearsRuleStrategy under30YearsRuleStrategy,
                             Between30And40YearsRuleStrategy between30And40YearsRuleStrategy,
                             IncomeAbove200000RuleStrategy incomeAbove200000RuleStrategy,
                             MortgagedHouseRuleStrategy mortgagedHouseRuleStrategy,
                             HasDependentsRuleStrategy hasDependentsRuleStrategy,
                             IsMarriedRuleStrategy isMarriedRuleStrategy,
                             VehicleProducedLast5YearsRuleStrategy vehicleProducedLast5YearsRuleStrategy) {
        this.ineligibleRuleStrategy = ineligibleRuleStrategy;
        this.under30YearsRuleStrategy = under30YearsRuleStrategy;
        this.between30And40YearsRuleStrategy = between30And40YearsRuleStrategy;
        this.incomeAbove200000RuleStrategy = incomeAbove200000RuleStrategy;
        this.mortgagedHouseRuleStrategy = mortgagedHouseRuleStrategy;
        this.hasDependentsRuleStrategy = hasDependentsRuleStrategy;
        this.isMarriedRuleStrategy = isMarriedRuleStrategy;
        this.vehicleProducedLast5YearsRuleStrategy = vehicleProducedLast5YearsRuleStrategy;
    }

    public void evaluate(Analysis toAnalysis, RiskProfile riskProfile, Score score){
        LOGGER.info("Called evaluate({})", toAnalysis);

        executeRules(toAnalysis, riskProfile, score);

        LOGGER.info("Final score calculated => {}", score.toString());
    }

    private void executeRules(Analysis toAnalysis, RiskProfile riskProfile, Score score) {
        LOGGER.info("Executing rules...");

        ineligibleRuleStrategy.executeRule(toAnalysis, riskProfile, score);
        under30YearsRuleStrategy.executeRule(toAnalysis, riskProfile, score);
        between30And40YearsRuleStrategy.executeRule(toAnalysis, riskProfile, score);
        incomeAbove200000RuleStrategy.executeRule(toAnalysis, riskProfile, score);
        mortgagedHouseRuleStrategy.executeRule(toAnalysis, riskProfile, score);
        hasDependentsRuleStrategy.executeRule(toAnalysis, riskProfile, score);
        isMarriedRuleStrategy.executeRule(toAnalysis, riskProfile, score);
        vehicleProducedLast5YearsRuleStrategy.executeRule(toAnalysis, riskProfile, score);

        LOGGER.info("Rules executed with success!");
    }
}
