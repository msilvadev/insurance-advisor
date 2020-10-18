package br.com.insuranceadvisor.usecases;

import br.com.insuranceadvisor.usecases.rules.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScoreRulesProfile {

    @Autowired
    private IneligibleRuleStrategy ineligibleRuleStrategy;

    @Autowired
    private Under30YearsRuleStrategy under30YearsRuleStrategy;

    @Autowired
    private Between30And40YearsRuleStrategy between30And40YearsRuleStrategy;

    @Autowired
    private IncomeAbove200000RuleStrategy incomeAbove200000RuleStrategy;

    @Autowired
    private MortgagedHouseRuleStrategy mortgagedHouseRuleStrategy;

    @Autowired
    private HasDependentsRuleStrategy hasDependentsRuleStrategy;

    @Autowired
    private IsMarriedRuleStrategy isMarriedRuleStrategy;

    @Autowired
    private VehicleProducedLast5YearsRuleStrategy vehicleProducedLast5YearsRuleStrategy;


}
