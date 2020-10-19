package br.com.insuranceadvisor.usecases;

import br.com.insuranceadvisor.models.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
public class RiskAnalysisUseCaseTest {

    @Autowired
    private RiskAnalysisUseCase useCase;

    private Analysis toAnalysis;

    @Test
    public void calculateRiskIneligibleTest(){
        int[] riskQuestion = {0, 1, 0};
        toAnalysis = new Analysis(60, 2, new HouseStatus(OwnershipStatus.OWNED), 0,
                MaritalStatus.MARRIED, riskQuestion, new Vehicle(2018));
        RiskProfile response = useCase.calculateRisk(toAnalysis);

        assertThat(response.getDisability()).isEqualTo(RiskProfileStatus.INELIGIBLE);
        assertThat(response.getAuto()).isEqualTo(RiskProfileStatus.INELIGIBLE);
        assertThat(response.getHome()).isEqualTo(RiskProfileStatus.INELIGIBLE);
    }

    @Test
    public void calculateRiskIneligibleMoreThan60YearsOldTest(){
        int[] riskQuestion = {0, 1, 0};
        toAnalysis = new Analysis(70, 2, new HouseStatus(OwnershipStatus.OWNED), 0,
                MaritalStatus.MARRIED, riskQuestion, new Vehicle(2018));
        RiskProfile response = useCase.calculateRisk(toAnalysis);

        assertThat(response.getDisability()).isEqualTo(RiskProfileStatus.INELIGIBLE);
        assertThat(response.getLife()).isEqualTo(RiskProfileStatus.INELIGIBLE);
    }

    @Test
    public void calculateRiskEconomicTest(){
        int[] riskQuestion = {0, 1, 0};
        toAnalysis = new Analysis(30, 0, new HouseStatus(OwnershipStatus.OWNED), 1,
                MaritalStatus.MARRIED, riskQuestion, new Vehicle(2018));
        RiskProfile response = useCase.calculateRisk(toAnalysis);

        assertThat(response.getDisability()).isEqualTo(RiskProfileStatus.ECONOMIC);
        assertThat(response.getAuto()).isEqualTo(RiskProfileStatus.ECONOMIC);
        assertThat(response.getHome()).isEqualTo(RiskProfileStatus.ECONOMIC);
        assertThat(response.getLife()).isEqualTo(RiskProfileStatus.ECONOMIC);
    }

    @Test
    public void calculateRiskRegularLifeTest(){
        int[] riskQuestion = {0, 1, 0};
        toAnalysis = new Analysis(40, 5, new HouseStatus(OwnershipStatus.MORTGAGED), 1,
                MaritalStatus.MARRIED, riskQuestion, new Vehicle(1995));
        RiskProfile response = useCase.calculateRisk(toAnalysis);

        assertThat(response.getLife()).isEqualTo(RiskProfileStatus.REGULAR);
    }

    @Test
    public void calculateRiskRegularDisabilityTest(){
        int[] riskQuestion = {0, 1, 0};
        toAnalysis = new Analysis(40, 5, new HouseStatus(OwnershipStatus.MORTGAGED), 1,
                MaritalStatus.SINGLE, riskQuestion, new Vehicle(1995));
        RiskProfile response = useCase.calculateRisk(toAnalysis);

        assertThat(response.getDisability()).isEqualTo(RiskProfileStatus.REGULAR);
    }

    @Test
    public void calculateRiskRegularHomeTest(){
        int[] riskQuestion = {0, 1, 0};
        toAnalysis = new Analysis(60, 0, new HouseStatus(OwnershipStatus.MORTGAGED), 1,
                MaritalStatus.SINGLE, riskQuestion, new Vehicle(1995));
        RiskProfile response = useCase.calculateRisk(toAnalysis);

        assertThat(response.getHome()).isEqualTo(RiskProfileStatus.REGULAR);
    }

    @Test
    public void calculateRiskRegularAutoTest(){
        int[] riskQuestion = {0, 1, 0};
        toAnalysis = new Analysis(60, 3, new HouseStatus(OwnershipStatus.MORTGAGED), 1,
                MaritalStatus.MARRIED, riskQuestion, new Vehicle(1995));
        RiskProfile response = useCase.calculateRisk(toAnalysis);

        assertThat(response.getHome()).isEqualTo(RiskProfileStatus.REGULAR);
    }
}
