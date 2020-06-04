package com.virgingames.steps;

import com.virgingames.constants.EndPoints;
import com.virgingames.model.GamesPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

/*
 * Ravi's Creation
 * Date of Creation 01/06/20
 */

public class VirginGameSteps {


    @Step("Get All Games detail")

    public static ValidatableResponse getAllGames() {


        GamesPojo gamesPojo = new GamesPojo();

        return SerenityRest.rest()
                // request body
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)

                // response body
                .when()
                .get(EndPoints.END_POINT)

                .then()
                .log()
                .body();
    }

    @Step("Get Game Frequency ")
    public static ValidatableResponse getGameByFrequency(int gameFreq) {

        return SerenityRest.rest()
                // request body
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
//                .pathParam("game Frequency", gameFreq)

                // response body
                .when()
                .get(EndPoints.END_POINT)

                .then()
                .log()
                .ifValidationFails();
    }

}
