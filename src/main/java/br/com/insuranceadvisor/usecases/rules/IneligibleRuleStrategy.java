package br.com.insuranceadvisor.usecases.rules;

import br.com.insuranceadvisor.model.Analysis;
import br.com.insuranceadvisor.model.RiskProfile;
import br.com.insuranceadvisor.model.RiskProfileStatus;
import br.com.insuranceadvisor.usecases.Score;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class IneligibleRuleStrategy implements RulesStrategy{

    public void executeRule(Analysis toAnalysis, RiskProfile riskProfile, Score score) {
        if (toAnalysis.getIncome() == 0 || Objects.isNull(toAnalysis.getVehicle()) ||
                Objects.isNull(toAnalysis.getHouse()) ) {
            riskProfile.setDisability(RiskProfileStatus.INELIGIBLE);
            riskProfile.setAuto(RiskProfileStatus.INELIGIBLE);
            riskProfile.setHome(RiskProfileStatus.INELIGIBLE);
        }

        if (toAnalysis.getAge() > 60){
            riskProfile.setDisability(RiskProfileStatus.INELIGIBLE);
            riskProfile.setLife(RiskProfileStatus.INELIGIBLE);
        }
    }
}
