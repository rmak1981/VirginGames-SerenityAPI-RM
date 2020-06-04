package com.virgingames.testsuite;

import com.virgingames.errormessages.ErrorMessages;
import com.virgingames.steps.VirginGameSteps;
import com.virgingames.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/*
 * Ravi's Creation
 * Date of Creation 01/06/20
 */

@RunWith(SerenityRunner.class)
public class Test001 extends TestBase {

    @Steps
    VirginGameSteps gameSteps;


    String gameName = "superJackpot" ;
    int gameFrequency  = 300000;

    @WithTags({
            @WithTag("productFeature:Smoke"),
            @WithTag("productFeature:Regression")
    })

    @Test
    @Title("This test will Get All Games :")
    public void getAllVirginGames() {

        gameSteps.getAllGames().statusCode(200);
    }

    @WithTags({
            @WithTag("productFeature:Sanity"),
            @WithTag("productFeature:Regression")
    })

    @Test
    @Title("This test will get game by it's frequency : ")
    public void getGamesFreq() {

        int gameFreq = gameSteps.getAllGames().extract().jsonPath().get("bingoLobbyInfoResource.streams[3].defaultGameFrequency");
        assertThat(gameFreq,equalTo(gameFrequency));
        gameSteps.getGameByFrequency(gameFreq).statusCode(200);
    }



}
